package it.naveen.educationapp.service.impl;

import it.naveen.educationapp.errorhandler.NotFoundException;
import it.naveen.educationapp.model.domain.StudentDomain;
import it.naveen.educationapp.model.entity.Department;
import it.naveen.educationapp.model.entity.Institution;
import it.naveen.educationapp.model.entity.Student;
import it.naveen.educationapp.model.entity.StudentId;
import it.naveen.educationapp.model.request.StudentRequest;
import it.naveen.educationapp.model.response.StudentResponse;
import it.naveen.educationapp.repository.StudentRepository;
import it.naveen.educationapp.service.EducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReadStudentService implements EducationService<StudentRequest, StudentResponse> {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public StudentResponse process(StudentRequest input) {
        Optional<Student> student = studentRepository.findById(new StudentId(input.getStudentId(), new Institution().setId(input.getInstituteId()), new Department().setId(input.getDepartmentId())));
        if (student != null && student.isPresent()) {
            return new StudentDomain().convertToDomain(student.get()).convertToResponse();
        }
        throw new NotFoundException("EA_003", "Student data not found", 404);
    }
}
