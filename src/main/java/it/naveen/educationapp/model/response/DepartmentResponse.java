package it.naveen.educationapp.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import it.naveen.educationapp.model.entity.Institution;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Set;

@Setter
@Getter
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class DepartmentResponse implements Serializable {
    private int id;

    private String name;

    private int institution_id;
}
