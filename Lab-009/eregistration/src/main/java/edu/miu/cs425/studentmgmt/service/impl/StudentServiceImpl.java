package edu.miu.cs425.studentmgmt.service.impl;

import edu.miu.cs425.studentmgmt.model.Student;
import edu.miu.cs425.studentmgmt.repository.StudentRepository;
import edu.miu.cs425.studentmgmt.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    @Autowired
    // constructor
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // save students in the db
    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);

    }

    // list of student retrive from db
    @Override
    public List<Student> getAllStudent() {
        return (List<Student>) studentRepository.findAll();
    }

    /// retrive students byid from db
    @Override
    public Student getStudentById(long studentId) {
        return studentRepository.findByStudentId(studentId);
    }


    // Delete method (deleting student from the database
    @Override
    public void deleteStudentById(long studentId) {
        studentRepository.deleteById(studentId);

    }

    @Override
    public Page<Student> getAllStudentPaged( int pageNo ,int size) {
       // return  studentRepository.findAll(PageRequest.of(pageNo);
        return studentRepository.findAll(PageRequest.of(pageNo, size, Sort.by("firstName")));
    }

    // Search method(searching based a given attribute(value)
    @Override
    public List<Student> searchStudent(String searchString) {
        if(containsDecimalPoint(searchString) && isCGPA(searchString)) {
            return studentRepository.findAllByCgpaEquals(Double.parseDouble(searchString));

        } else if(isDate(searchString)) {
            return studentRepository.findAllByDateOfEnrollemnetEquals(LocalDate.parse(searchString, DateTimeFormatter.ISO_DATE));
        } else {
            return studentRepository.findAllByfirstNameContainingOrLastNameContainingOrStudentNumberContainingOrderByStudentId(searchString,searchString,searchString);
            //astNameContainingOrStudentNumberContainingOrderByStudentId(searchString, searchString, searchString);
        }
    }

    private boolean isCGPA(String searchString) {
        boolean isParseableAsCGPA = false;
        try {
            Double.parseDouble(searchString);
            isParseableAsCGPA = true;
        } catch(Exception ex) {
            if(ex instanceof ParseException) {
                isParseableAsCGPA = false;
            }
        }
        return isParseableAsCGPA;


    }


    private boolean isDate(String searchString) {
        boolean isParseableAsDate = false;
        try {
            LocalDate.parse(searchString, DateTimeFormatter.ISO_DATE);
            isParseableAsDate = true;
        } catch (Exception ex) {
            if (ex instanceof DateTimeParseException) {
                isParseableAsDate = false;
            }
        }
        return isParseableAsDate;
    }

    private boolean containsDecimalPoint(String searchString) {
        return searchString.contains(".");
    }

       }




