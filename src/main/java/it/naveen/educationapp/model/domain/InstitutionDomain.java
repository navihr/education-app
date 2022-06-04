package it.naveen.educationapp.model.domain;

import it.naveen.educationapp.model.entity.Department;
import it.naveen.educationapp.model.entity.Institution;
import it.naveen.educationapp.model.request.InstitutionRequest;
import it.naveen.educationapp.model.response.DepartmentResponse;
import it.naveen.educationapp.model.response.InstitutionResponse;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Setter
@Getter
@Accessors(chain = true)
public class InstitutionDomain implements Serializable {

    private int id;

    private String name;

    private String city;

    private String state;

    private String country;

    private Set<DepartmentDomain> departments;

    private Date createdTime;

    private Date updatedTime;

    public Institution convertToEntity() {
        Institution institution = new Institution().setName(getName())
                .setCity(getCity())
                .setState(getState())
                .setCountry(getCountry())
                .setCreatedTime(getCreatedTime())
                .setUpdatedTime(getUpdatedTime());
        if (getId() > 0) {
            institution.setId(getId());
        }
        if (getDepartments() != null && getDepartments().size() > 0) {
            institution.setDepartments(getDepartments().stream().map(departmentDomain -> {
                    Department department = departmentDomain.convertToEntity();
                    department.setInstitution(institution);
                    return department;
            }).collect(Collectors.toSet()));
        }
        return institution;
    }

    public InstitutionDomain convertToDomain(Institution institution, boolean avoidDepartment) {
         this.setId(institution.getId())
                .setName(institution.getName())
                .setCity(institution.getCity())
                .setState(institution.getState())
                .setCountry(institution.getCountry())
                .setCreatedTime(institution.getCreatedTime())
                .setUpdatedTime(institution.getUpdatedTime());
         if (institution.getDepartments() != null && !avoidDepartment) {
             this.setDepartments(institution.getDepartments().stream().map(department -> new DepartmentDomain()
                     .convertToDomain(department)).collect(Collectors.toSet()));
         }
         return this;
    }

    public InstitutionDomain convertToDomain(InstitutionRequest institution) {
        this.setName(institution.getName())
                .setCity(institution.getCity())
                .setState(institution.getState())
                .setCountry(institution.getCountry())
                .setCreatedTime(new Date())
                .setUpdatedTime(new Date());
        if (institution.getDepartments() != null) {
            this.setDepartments(institution.getDepartments().stream().map(departmentRequest ->
                new DepartmentDomain()
                    .convertToDomain(departmentRequest)).collect(Collectors.toSet()));
        }
        if (institution.getId() > 0) {
            this.setId(institution.getId());
        }
        return this;
    }

    public InstitutionResponse convertToResponse() {
        return new InstitutionResponse().setId(getId())
                .setName(getName())
                .setCity(getCity())
                .setState(getState())
                .setCountry(getCountry())
                .setDepartments(getDepartments().stream()
                        .map(departmentDomain -> departmentDomain.convertToResponse()).collect(Collectors.toSet()));
    }


}
