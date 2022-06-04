package it.naveen.educationapp.model.response;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

@Setter
@Getter
@Accessors(chain = true)
public class StudentResponse implements Serializable {
    private int studentId;

    private int instituteId;

    private int departmentId;

    private String name;

    private Date dob;

    private String city;

    private String state;

    private String country;
}
