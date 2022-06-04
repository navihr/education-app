package it.naveen.educationapp.service.impl;

import it.naveen.educationapp.model.domain.DepartmentDomain;
import it.naveen.educationapp.model.entity.Department;
import it.naveen.educationapp.model.request.DepartmentRequest;
import it.naveen.educationapp.model.response.DepartmentResponse;
import it.naveen.educationapp.repository.DepartmentRepository;
import it.naveen.educationapp.service.EducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateDepartmentService implements EducationService<DepartmentRequest, DepartmentResponse> {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentResponse process(DepartmentRequest input) {
        Department department = new DepartmentDomain().convertToDomain(input).convertToEntity();
        department = departmentRepository.save(department);
        return new DepartmentDomain().convertToDomain(department).convertToResponse();
    }
}
