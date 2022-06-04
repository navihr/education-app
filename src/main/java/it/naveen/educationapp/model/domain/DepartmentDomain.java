package it.naveen.educationapp.model.domain;

import it.naveen.educationapp.model.entity.Department;
import it.naveen.educationapp.model.entity.Institution;
import it.naveen.educationapp.model.request.DepartmentRequest;
import it.naveen.educationapp.model.response.DepartmentResponse;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Setter
@Getter
@Accessors(chain = true)
public class DepartmentDomain implements Serializable {
    private int id;

    private String name;

    private InstitutionDomain institution;

    private Date createdTime;

    private Date updatedTime;

    public Department convertToEntity() {
        Department department = new Department().setName(getName())
                .setCreatedTime(getCreatedTime())
                .setUpdatedTime(getUpdatedTime());
        if (getId() > 0) {
            department.setId(getId());
        }
        if (getInstitution() != null) {
            department.setInstitution(getInstitution().convertToEntity());
        }
        return department;
    }

    public DepartmentDomain convertToDomain(Department department) {
        return this.setId(department.getId()).setName(department.getName())
                .setInstitution(new InstitutionDomain().convertToDomain(department.getInstitution(), true))
                .setCreatedTime(new Date())
                .setUpdatedTime(new Date());
    }

    public DepartmentDomain convertToDomain(DepartmentRequest department) {
        this.setName(department.getName())
                .setCreatedTime(new Date())
                .setUpdatedTime(new Date());
        if (department.getInstitution() != null) {
            this.setInstitution(new InstitutionDomain().convertToDomain(department.getInstitution()));
        }
        return this;
    }

    public DepartmentResponse convertToResponse() {
        return new DepartmentResponse().setId(getId()).setName(getName())
                .setInstitution_id(getInstitution().getId());
    }
}
