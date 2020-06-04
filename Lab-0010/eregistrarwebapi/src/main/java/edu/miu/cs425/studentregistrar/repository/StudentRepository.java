package edu.miu.cs425.studentregistrar.repository;


import edu.miu.cs425.studentregistrar.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {



}


