package edu.miu.cs425.studentregistrar.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageController {


    // get method ( populate the list of student from db)
    @GetMapping(value = {"/", "/home", "/index", "mystudentmgmtwebapp/home"})
    public String showHomepage() {
        return "home/index";


    }
}
