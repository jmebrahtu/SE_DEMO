package edu.miu.cs425.studentmgmt.service;

import edu.miu.cs425.studentmgmt.model.Student;
import edu.miu.cs425.studentmgmt.repository.StudentRepository;

import java.util.List;

public interface StudentService {




    public abstract List<Student> getAllStudent();
    public abstract Student saveStudent(Student student);
    public abstract Student getStudentById(long studentId);
    public abstract void deleteStudentById(long studentId);
    public abstract List<Student> searchStudent(String searchString);
    //Iterable<Student> getAllStudents();

}


