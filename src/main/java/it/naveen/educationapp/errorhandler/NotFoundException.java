package it.naveen.educationapp.errorhandler;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class NotFoundException extends RuntimeException {
    private final String errorCode;
    private final String errorMessage;
    private final int httpStatusCode;

    private final transient Object[] parameters;

    public NotFoundException(String errorCode) {
        this(errorCode, null, null);
    }

    public NotFoundException(String errorCode, String errorMessage) {
        this(errorCode, errorMessage, null);
    }

    public NotFoundException(String errorCode, String errorMessage, int httpStatusCode) {
        this(errorCode, errorMessage, null, httpStatusCode);
    }

    public NotFoundException(String errorCode, String errorMessage, Throwable throwable) {
        this(errorCode, errorMessage, throwable, -1);
    }

    public NotFoundException(String errorCode, String errorMessage, Throwable throwable, int httpStatusCode,
                       Object... parameters) {
        super(errorMessage, throwable);
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
        this.httpStatusCode = httpStatusCode;
        this.parameters = parameters.clone();
    }
}
