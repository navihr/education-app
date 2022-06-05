package it.naveen.educationapp.service.impl;

import it.naveen.educationapp.model.request.DepartmentRequest;
import it.naveen.educationapp.repository.DepartmentRepository;
import it.naveen.educationapp.service.EducationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteDepartmentService implements EducationService<DepartmentRequest, Boolean> {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Boolean process(DepartmentRequest input) {
        boolean toRet = true;
        try {
            departmentRepository.deleteById(input.getId());
        } catch (Exception e) {
            logger.error("Throw error while delete department detail", e);
            toRet = false;
        }
        return toRet;
    }
}
