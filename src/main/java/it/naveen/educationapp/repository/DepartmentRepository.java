package it.naveen.educationapp.repository;

import it.naveen.educationapp.model.entity.Department;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends CrudRepository<Department, Integer> {
    Department findByIdAndInstitution_Id(int id, int institutionId);
}
