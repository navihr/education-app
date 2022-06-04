package it.naveen.educationapp.controller;

import it.naveen.educationapp.model.request.InstitutionRequest;
import it.naveen.educationapp.model.response.InstitutionResponse;
import it.naveen.educationapp.service.impl.CreateInstitutionService;
import it.naveen.educationapp.service.impl.ReadInstitutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/institution")
public class InstitutionController {

    @Autowired
    private CreateInstitutionService createInstitutionService;

    @Autowired
    private ReadInstitutionService readInstitutionService;

    @PostMapping
    public ResponseEntity<InstitutionResponse> createInstitution(@RequestBody InstitutionRequest institutionRequest) {
        InstitutionResponse institutionResponse = createInstitutionService.process(institutionRequest);
        return new ResponseEntity<>(institutionResponse, HttpStatus.CREATED);
    }

    @GetMapping("/{institutionId}")
    public ResponseEntity<InstitutionResponse> readInstitution(@PathVariable Integer institutionId) {
        InstitutionRequest institutionRequest = new InstitutionRequest().setId(institutionId);
        InstitutionResponse institutionResponse = readInstitutionService.process(institutionRequest);
        return new ResponseEntity<>(institutionResponse, HttpStatus.OK);
    }
}
