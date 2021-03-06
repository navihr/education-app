package it.naveen.educationapp.repository;

import it.naveen.educationapp.model.entity.Department;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends CrudRepository<Department, Integer> {
    Department findByIdAndInstitution_Id(int id, int institutionId);

    List<Department> findAllByInstitution_Id(int institutionId);
}
