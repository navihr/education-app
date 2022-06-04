package it.naveen.educationapp.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@Accessors(chain = true)
@JsonIgnoreProperties(value = { "createdTime", "updatedTime"})
public class Student implements Serializable {

    @EmbeddedId
    private StudentId studentId;

    private String name;

    private Date dob;

    private String city;

    private String state;

    private String country;

    private Date createdTime;

    private Date updatedTime;
}
