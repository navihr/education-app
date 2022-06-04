package it.naveen.educationapp.model.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

@Setter
@Getter
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class StudentRequest implements Serializable {
    private int studentId;

    private int instituteId;

    private int departmentId;

    private String name;

    private Date dob;

    private String city;

    private String state;

    private String country;
}
