package it.naveen.educationapp.model.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import it.naveen.educationapp.model.entity.Institution;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Set;

@Setter
@Getter
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DepartmentRequest implements Serializable {

    private int id;

    private String name;

    private InstitutionRequest institution;
}
