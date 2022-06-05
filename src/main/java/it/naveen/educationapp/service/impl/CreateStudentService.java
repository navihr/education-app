package it.naveen.educationapp.service.impl;

import it.naveen.educationapp.model.domain.StudentDomain;
import it.naveen.educationapp.model.entity.Student;
import it.naveen.educationapp.model.request.StudentRequest;
import it.naveen.educationapp.model.response.StudentResponse;
import it.naveen.educationapp.repository.StudentRepository;
import it.naveen.educationapp.service.EducationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateStudentService implements EducationService<StudentRequest, StudentResponse> {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public StudentResponse process(StudentRequest input) {
        logger.info("Enter request to create student service.");
        Student student = new StudentDomain().convertToDomain(input).convertToEntity();
        student = studentRepository.save(student);
        return new StudentDomain().convertToDomain(student).convertToResponse();
    }
}
