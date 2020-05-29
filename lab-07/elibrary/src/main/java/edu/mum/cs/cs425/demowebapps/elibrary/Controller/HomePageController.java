package edu.mum.cs.cs425.demowebapps.elibrary.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageController {

    @GetMapping(value = {"/","/elibrary","/elibrary/home"})
    public String displayHomePage(){
        return"index";
    }
}