package it.naveen.educationapp.controller;

import it.naveen.educationapp.model.request.StudentRequest;
import it.naveen.educationapp.model.response.StudentResponse;
import it.naveen.educationapp.service.impl.CreateStudentService;
import it.naveen.educationapp.service.impl.DeleteStudentService;
import it.naveen.educationapp.service.impl.ReadStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/institution/{institutionId}/department/{departmentId}/student")
public class StudentController {

    @Autowired
    private CreateStudentService createStudentService;

    @Autowired
    private ReadStudentService readStudentService;

    @Autowired
    private DeleteStudentService deleteStudentService;

    @PostMapping
    public ResponseEntity<StudentResponse> createStudent(@PathVariable Integer institutionId, @PathVariable Integer departmentId, @RequestBody StudentRequest studentRequest) {
        studentRequest.setInstituteId(institutionId).setDepartmentId(departmentId);
        StudentResponse studentResponse = createStudentService.process(studentRequest);
        return new ResponseEntity<>(studentResponse, HttpStatus.CREATED);
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<StudentResponse> getStudent(@PathVariable Integer institutionId, @PathVariable Integer departmentId, @PathVariable Integer studentId) {
        StudentRequest studentRequest = new StudentRequest().setStudentId(studentId)
                .setDepartmentId(departmentId)
                .setInstituteId(institutionId);
        StudentResponse studentResponse = readStudentService.process(studentRequest);
        return new ResponseEntity<>(studentResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{studentId}")
    public ResponseEntity<StudentResponse> deleteStudent(@PathVariable Integer institutionId, @PathVariable Integer departmentId, @PathVariable Integer studentId) {
        StudentRequest studentRequest = new StudentRequest().setStudentId(studentId)
                .setDepartmentId(departmentId)
                .setInstituteId(institutionId);
        boolean isDeleted = deleteStudentService.process(studentRequest);
        if (isDeleted) {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }
}
