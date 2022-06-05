package it.naveen.educationapp.service.impl;

import it.naveen.educationapp.model.request.InstitutionRequest;
import it.naveen.educationapp.repository.InstitutionRepository;
import it.naveen.educationapp.service.EducationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteInstitutionService implements EducationService<InstitutionRequest, Boolean> {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private InstitutionRepository institutionRepository;

    @Override
    public Boolean process(InstitutionRequest input) {
        boolean toRet = true;
        try {
            institutionRepository.deleteById(input.getId());
        } catch (Exception e) {
            logger.error("Throw error while delete institution detail", e);
            toRet = false;
        }
        return toRet;
    }
}
