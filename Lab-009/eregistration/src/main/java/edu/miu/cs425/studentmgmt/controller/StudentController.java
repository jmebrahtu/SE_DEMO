package edu.miu.cs425.studentmgmt.controller;

import edu.miu.cs425.studentmgmt.model.Student;
import edu.miu.cs425.studentmgmt.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;


@Controller
public class StudentController {

    @Autowired
    // allows to inject the attribute and methods of that service
    private StudentService studentService;


    // constructor
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // get method(get method with its url), model and view (data and  the extension for the file)
    @GetMapping(value = {"/mystudentmgmtwebapp/student/list","/student/list"})
    public ModelAndView listStudent() {
        ModelAndView modelAndView = new ModelAndView();
        List<Student> students = studentService.getAllStudent();
        modelAndView.addObject("students", students);
         modelAndView.addObject("searchlong","");
        modelAndView.addObject("studentCount","");
        modelAndView.setViewName("student/list");
        return modelAndView;
    }

    // get method and url(that used to add a new object(new student)
    @GetMapping(value = {"/mystudentmgmtwebapp/student/newadd", "/student/newadd"})
    public String DisplayNewStudentForm(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        return "student/newadd";

    }

    //posting method and its url(if the input is incorrect as requrienment it
    //  shows error on the page itself, if all are valid it post/ save / perisit  to the database

    @PostMapping(value = {"/mystudentmgmtwebapp/student/newadd", "/student/newadd"})
    // the input object dawn casting to specific type
    public String addNewStudent(@Valid @ModelAttribute("student") Student student, BindingResult bindingResult, Model model) {
        // check if error exist
        if (bindingResult.hasErrors()) {
            model.addAttribute("student", student);
            model.addAttribute("error", bindingResult.getAllErrors());
            return "student/newadd";
        }
          student= studentService.saveStudent(student);
        return "redirect:/mystudentmgmtwebapp/student/list";
  }


  // edit method

    @GetMapping(value = {"/mystudentmgmtwebapp/student/edit/{studentId}","/student/edit/{studentId}"})
    public String editStudent(@PathVariable long studentId, Model model) {
        Student student = studentService.getStudentById(studentId);
        if (student != null) {
            model.addAttribute("student", student);
            return "student/edit";
        }
        return "student/list";
    }
// after eedit and save method ( means update)
    @PostMapping(value = {"/mystudentmgmtwebapp/student/edit","/student/edit"})
    public String updateStudent(@Valid @ModelAttribute("student") Student student,
                             BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "student/edit";
        }
        student = studentService.saveStudent(student);
        return "redirect:/mystudentmgmtwebapp/student/list";
    }

    // delete method
    @GetMapping(value = {"/mystudentmgmtwebapp/student/delete/{studentId}","/student/delete/{studentId}"})
    public String deleteStudent(@PathVariable long studentId, Model model) {
        studentService.deleteStudentById(studentId);
        return "redirect:/mystudentmgmtwebapp/student/list";
    }

    // search method
    @GetMapping(value = {"/mystudentmgmtwebapp/student/search", "/student/search"})
    public ModelAndView searchStudents(@RequestParam String searchString) {
        ModelAndView modelAndView = new ModelAndView();
        List<Student> students = studentService.searchStudent(searchString);
        modelAndView.addObject("students", students);
        modelAndView.addObject("searchString", searchString);
        modelAndView.addObject("studentsCount", students.size());
        modelAndView.setViewName("student/list");
        return modelAndView;
    }

};



