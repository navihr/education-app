package it.naveen.educationapp.repository;

import it.naveen.educationapp.model.entity.Institution;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstitutionRepository extends CrudRepository<Institution, Integer> {
}
