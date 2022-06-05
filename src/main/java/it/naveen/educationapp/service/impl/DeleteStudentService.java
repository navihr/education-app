package it.naveen.educationapp.service.impl;

import it.naveen.educationapp.model.entity.Department;
import it.naveen.educationapp.model.entity.Institution;
import it.naveen.educationapp.model.entity.StudentId;
import it.naveen.educationapp.model.request.StudentRequest;
import it.naveen.educationapp.repository.StudentRepository;
import it.naveen.educationapp.service.EducationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteStudentService implements EducationService<StudentRequest, Boolean> {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Boolean process(StudentRequest input) {
        boolean toRet = true;
        try {
            studentRepository.deleteById(new StudentId(input.getStudentId(),
                    new Institution().setId(input.getInstituteId()),
                    new Department().setId(input.getDepartmentId())));
        } catch (Exception e) {
            logger.error("Throw error while delete student detail", e);
            toRet = false;
        }
        return toRet;
    }
}
