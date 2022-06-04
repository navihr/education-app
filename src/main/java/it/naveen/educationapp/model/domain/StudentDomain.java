package it.naveen.educationapp.model.domain;

import it.naveen.educationapp.model.entity.Department;
import it.naveen.educationapp.model.entity.Institution;
import it.naveen.educationapp.model.entity.Student;
import it.naveen.educationapp.model.entity.StudentId;
import it.naveen.educationapp.model.request.StudentRequest;
import it.naveen.educationapp.model.response.StudentResponse;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

@Setter
@Getter
@Accessors(chain = true)
public class StudentDomain implements Serializable {
    private int studentId;

    private int instituteId;

    private int departmentId;

    private String name;

    private Date dob;

    private String city;

    private String state;

    private String country;

    private Date createdTime;

    private Date updatedTime;

    public StudentDomain convertToDomain(StudentRequest student) {
        return this.setStudentId(student.getStudentId())
                .setDepartmentId(student.getDepartmentId())
                .setInstituteId(student.getInstituteId())
                .setName(student.getName())
                .setDob(student.getDob())
                .setCity(student.getCity())
                .setState(student.getState())
                .setCountry(student.getCountry())
                .setCreatedTime(new Date())
                .setUpdatedTime(new Date());
    }

    public StudentDomain convertToDomain(Student student) {
        return this.setStudentId(student.getStudentId().getId())
                .setDepartmentId(student.getStudentId().getDepartment().getId())
                .setInstituteId(student.getStudentId().getInstitute().getId())
                .setName(student.getName())
                .setDob(student.getDob())
                .setCity(student.getCity())
                .setState(student.getState())
                .setCountry(student.getCountry())
                .setCreatedTime(new Date())
                .setUpdatedTime(new Date());
    }

    public Student convertToEntity() {
        StudentId id = new StudentId();
        if(getInstituteId() > 0) {
            id.setInstitute(new Institution().setId(getInstituteId()));
        }
        if(getDepartmentId() > 0) {
            id.setDepartment(new Department().setId(getDepartmentId()));
        }
        if(getStudentId() > 0) {
            id.setId(getStudentId());
        }
        return new Student().setStudentId(id)
                .setName(getName())
                .setDob(getDob())
                .setCity(getCity())
                .setState(getState())
                .setCountry(getCountry())
                .setCreatedTime(getCreatedTime())
                .setUpdatedTime(getUpdatedTime());
    }

    public StudentResponse convertToResponse() {
        return new StudentResponse().setStudentId(getStudentId())
                .setDepartmentId(getDepartmentId())
                .setInstituteId(getInstituteId())
                .setName(getName())
                .setDob(getDob())
                .setCity(getCity())
                .setState(getState())
                .setCountry(getCountry());
    }
}
