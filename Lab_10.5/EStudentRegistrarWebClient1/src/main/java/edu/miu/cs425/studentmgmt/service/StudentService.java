package edu.miu.cs425.studentmgmt.service;

import edu.miu.cs425.studentmgmt.model.Student;
//import edu.miu.cs425.studentmgmt.repository.StudentRepository;
import org.springframework.data.domain.Page;

import java.util.List;

public interface StudentService {

    List<Student> getAllStudents();
    Student registerNewStudent(Student newStudent);
    Student getStudentById(long studentId);
    void updateStudent(Student updStudent,long studentId);
    void deleteStudentById(long studentId);
    Student save(Student student);
   // List<Student> getAllStudentSorted();
    // List<Student> searchStudent(String searchString);
    //Student save(Student  stud);

}


