package edu.miu.cs425.studentregistrar.controller;

import edu.miu.cs425.studentregistrar.model.Student;
import edu.miu.cs425.studentregistrar.model.Students;
import edu.miu.cs425.studentregistrar.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value="/mystudentsmgmt/api/student", produces = MediaType.APPLICATION_JSON_VALUE)
public class StudentRestController {

    private StudentService studentService;

    @Autowired
    // constructor
    public  StudentRestController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(value = "/list")
    public Students list() {

        List<Student> s= studentService.getAllStudent();
        Students st=new Students();
        st.setStu(s);

//        sl.setStudents(s);
        return st;
    }

    @GetMapping(value = "/get/{studentId}")
    public Student getStudentById(@PathVariable long studentId) {
        return studentService.getStudentById(studentId);
    }

    @PostMapping(value = "/register")
    public Student registerNewStudent(@Valid @RequestBody Student student) {
        return studentService.registerNewStudent(student);
    }

    @PutMapping(value = "/update/{studentId}")
    public Student updateStudent(@Valid @RequestBody Student editedStudent, @PathVariable long studentId ){
        return studentService.updateStudent(editedStudent,studentId );
    }

    @DeleteMapping(value = "/delete/{studentId}")
    public void deleteStudent(@PathVariable long studentId) {
        studentService.deleteStudentById(studentId);
    }

    @GetMapping(value = "/search/{firstName}")
    public List<Student> getStudentByFirstName(@PathVariable String firstName) {
        return studentService.searchStudent(firstName);
    }
}
