package it.naveen.educationapp.model.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class ErrorResponse implements Serializable {
    private String responseCode;
    private String responseMsg;
    private List<Error> errors;
    private long timeStamp;

    public ErrorResponse() {
        this.timeStamp = System.currentTimeMillis();
    }

    public void addErrors(Error e) {
        if(e == null) {
            return;
        }
        if(errors == null) {
            errors = new ArrayList<>();
        }
        errors.add(e);
    }
}
