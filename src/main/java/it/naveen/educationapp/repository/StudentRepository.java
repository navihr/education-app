package it.naveen.educationapp.repository;

import it.naveen.educationapp.model.entity.Student;
import it.naveen.educationapp.model.entity.StudentId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<Student, StudentId> {
}
