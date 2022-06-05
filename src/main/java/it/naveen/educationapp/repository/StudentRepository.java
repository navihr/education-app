package it.naveen.educationapp.repository;

import it.naveen.educationapp.model.entity.Student;
import it.naveen.educationapp.model.entity.StudentId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<Student, StudentId> {
    List<Student> findAllByStudentId_Department_Id(int departmentId);

    List<Student> findAllByStudentId_Institute_Id(int instituteId);

    List<Student> findAllByStudentId_Institute_IdAndStudentId_Department_Id(int instituteId, int departmentId);
}
