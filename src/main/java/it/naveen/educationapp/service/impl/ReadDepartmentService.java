package it.naveen.educationapp.service.impl;

import it.naveen.educationapp.errorhandler.NotFoundException;
import it.naveen.educationapp.model.domain.DepartmentDomain;
import it.naveen.educationapp.model.entity.Department;
import it.naveen.educationapp.model.request.DepartmentRequest;
import it.naveen.educationapp.model.response.DepartmentResponse;
import it.naveen.educationapp.repository.DepartmentRepository;
import it.naveen.educationapp.service.EducationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReadDepartmentService implements EducationService<DepartmentRequest, DepartmentResponse> {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private DepartmentRepository departmentRepository;


    @Override
    public DepartmentResponse process(DepartmentRequest input) {
        logger.info("Enter request to read department service.");
        Department department  = departmentRepository.findByIdAndInstitution_Id(input.getId(), input.getInstitution().getId());
        if(department != null) {
            return new DepartmentDomain().convertToDomain(department).convertToResponse();
        }
        throw new NotFoundException("EA_002", "Department data not found", 404);
    }
}
