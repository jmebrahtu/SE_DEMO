package edu.miu.cs425.studentmgmt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class LoginController {

    @GetMapping(value = {"/public/login","mystudentmgmtwebapp/public/login"})
    public String login() {
        return "public/login";
    }

}
