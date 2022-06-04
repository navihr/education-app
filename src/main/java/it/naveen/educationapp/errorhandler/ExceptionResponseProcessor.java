package it.naveen.educationapp.errorhandler;

import it.naveen.educationapp.model.common.Error;
import it.naveen.educationapp.model.common.ErrorResponse;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.io.Serializable;

@ControllerAdvice
@NoArgsConstructor
public class ExceptionResponseProcessor extends ResponseEntityExceptionHandler {

    @ExceptionHandler({NotFoundException.class, IllegalArgumentException.class})
    public final ResponseEntity<ErrorResponse> handleExceptionInternal(Exception ex, WebRequest request) {
        logger.debug("Start IbExceptionResponseProcessor -> handleExceptionInternal method");
        ErrorResponse errorHandlerResponse = new ErrorResponse();
        HttpStatus status = null;
        if (ex instanceof MethodArgumentNotValidException || ex instanceof IllegalArgumentException) {
            if(ex instanceof MethodArgumentNotValidException) {
                BindingResult bindingResult = ((MethodArgumentNotValidException) ex).getBindingResult();
                setMethodArgumentNotValidExceptionResponse(bindingResult, errorHandlerResponse);
            }
            else if(ex instanceof IllegalArgumentException) {
                errorHandlerResponse.addErrors(new Error().setTitle("java.lang.IllegalArgumentException")
                        .setMessage(ex.getMessage()));
            }
            status = HttpStatus.BAD_REQUEST;
        } else if (ex instanceof NotFoundException) {
            NotFoundException e = (NotFoundException) ex;
            int statusCode = e.getHttpStatusCode();
            HttpStatus httpStatus = HttpStatus.valueOf(statusCode);
            httpStatus = (httpStatus != null) ? httpStatus : HttpStatus.INTERNAL_SERVER_ERROR;
            status = httpStatus;
            errorHandlerResponse.setResponseCode(e.getErrorCode());
            errorHandlerResponse.setResponseMsg(e.getErrorMessage());
        } else {
            status = HttpStatus.INTERNAL_SERVER_ERROR;
            errorHandlerResponse.setResponseCode("UN-HANDLED");
            errorHandlerResponse.setResponseMsg(ex.getMessage());
        }

        return new ResponseEntity<>(errorHandlerResponse, status);
    }

    private void setMethodArgumentNotValidExceptionResponse(BindingResult bindingResult, ErrorResponse errorHandlerResponse) {
        for(FieldError fieldError : bindingResult.getFieldErrors()) {
            errorHandlerResponse.addErrors(new Error().setTitle(fieldError.getField())
                    .setCode(fieldError.getCode()).setRejectedValue((Serializable) fieldError.getRejectedValue())
                    .setMessage(fieldError.getDefaultMessage()));
        }
    }
}
