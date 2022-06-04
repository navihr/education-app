package it.naveen.educationapp.service.impl;

import it.naveen.educationapp.model.domain.InstitutionDomain;
import it.naveen.educationapp.model.entity.Institution;
import it.naveen.educationapp.model.request.InstitutionRequest;
import it.naveen.educationapp.model.response.InstitutionResponse;
import it.naveen.educationapp.repository.InstitutionRepository;
import it.naveen.educationapp.service.EducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateInstitutionService implements EducationService<InstitutionRequest, InstitutionResponse> {
    @Autowired
    private InstitutionRepository institutionRepository;

    @Override
    public InstitutionResponse process(InstitutionRequest input) {
        Institution institution = new InstitutionDomain().convertToDomain(input).convertToEntity();
        institution = institutionRepository.save(institution);
        return new InstitutionDomain().convertToDomain(institution, false).convertToResponse();
    }
}
