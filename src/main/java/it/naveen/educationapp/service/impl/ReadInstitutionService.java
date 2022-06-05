package it.naveen.educationapp.service.impl;

import it.naveen.educationapp.errorhandler.NotFoundException;
import it.naveen.educationapp.model.domain.InstitutionDomain;
import it.naveen.educationapp.model.entity.Institution;
import it.naveen.educationapp.model.request.InstitutionRequest;
import it.naveen.educationapp.model.response.InstitutionResponse;
import it.naveen.educationapp.repository.InstitutionRepository;
import it.naveen.educationapp.service.EducationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReadInstitutionService implements EducationService<InstitutionRequest, InstitutionResponse> {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private InstitutionRepository institutionRepository;

    @Override
    public InstitutionResponse process(InstitutionRequest input) {
        logger.info("Enter request to read institution service.");
        Optional<Institution> institution = institutionRepository.findById(input.getId());
        if (institution != null && institution.isPresent()) {
            return new InstitutionDomain().convertToDomain(institution.get(), false).convertToResponse();
        }
        throw new NotFoundException("EA_001", "Institution data not found", 404);
    }
}
