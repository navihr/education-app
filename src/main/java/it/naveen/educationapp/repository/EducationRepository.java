package it.naveen.educationapp.repository;

import java.util.List;

public interface EducationRepository<I> {
    Object save(I input);
    I findById(Object id);
    List<I> findAll();
    I update(I input);
    boolean deleteById(Object id);
    boolean deleteAll();
}
