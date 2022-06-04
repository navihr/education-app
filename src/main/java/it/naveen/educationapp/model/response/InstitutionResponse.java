package it.naveen.educationapp.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import it.naveen.educationapp.model.entity.Department;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Set;

@Setter
@Getter
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class InstitutionResponse implements Serializable {
    private int id;

    private String name;

    private String city;

    private String state;

    private String country;

    private Set<DepartmentResponse> departments;
}
