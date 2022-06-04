package it.naveen.educationapp.model.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import it.naveen.educationapp.model.entity.Department;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Set;

@Setter
@Getter
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class InstitutionRequest implements Serializable {
    private int id;

    private String name;

    private String city;

    private String state;

    private String country;

    private Set<DepartmentRequest> departments;
}
