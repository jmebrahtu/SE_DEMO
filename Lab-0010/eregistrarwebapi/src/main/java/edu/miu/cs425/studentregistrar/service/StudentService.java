package edu.miu.cs425.studentregistrar.service;


import edu.miu.cs425.studentregistrar.model.Student;

import java.util.List;

public interface StudentService {

    List<Student> getAllStudent();
   Student registerNewStudent(Student newStudent);
    List<Student> getAllStudentSorted();
    Student getStudentById(long studentId);
   Student updateStudent(Student updStudent,long studentId);
    void deleteStudentById(long studentId);
    List<Student> searchStudent(String firstName);

}


