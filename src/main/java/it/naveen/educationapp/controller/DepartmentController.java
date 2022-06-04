package it.naveen.educationapp.controller;

import it.naveen.educationapp.model.request.DepartmentRequest;
import it.naveen.educationapp.model.request.InstitutionRequest;
import it.naveen.educationapp.model.response.DepartmentResponse;
import it.naveen.educationapp.service.impl.CreateDepartmentService;
import it.naveen.educationapp.service.impl.ReadDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/institution/{institutionId}/department")
public class DepartmentController {

    @Autowired
    private CreateDepartmentService createDepartmentService;

    @Autowired
    private ReadDepartmentService readDepartmentService;

    @PostMapping
    public ResponseEntity<DepartmentResponse> createDepartment(@PathVariable Integer institutionId, @RequestBody DepartmentRequest departmentRequest) {
        InstitutionRequest institutionRequest = new InstitutionRequest();
        institutionRequest.setId(institutionId);
        departmentRequest.setInstitution(institutionRequest);
        DepartmentResponse departmentResponse = createDepartmentService.process(departmentRequest);
        return new ResponseEntity<>(departmentResponse, HttpStatus.CREATED);
    }

    @GetMapping("/{departmentId}")
    public ResponseEntity<DepartmentResponse> getDepartment(@PathVariable Integer institutionId, @PathVariable Integer departmentId) {
        DepartmentRequest departmentRequest = new DepartmentRequest();
        departmentRequest.setId(departmentId);
        departmentRequest.setInstitution(new InstitutionRequest().setId(institutionId));
        DepartmentResponse departmentResponse = readDepartmentService.process(departmentRequest);
        return new ResponseEntity<>(departmentResponse, HttpStatus.CREATED);
    }
}
