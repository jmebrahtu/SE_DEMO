package edu.miu.cs425.studentmgmt.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
//
//@Controller
//public class HomePageController {
//
//
//   // get method ( populate the list of student from db)
//    @GetMapping(value ={ "/", "/home","/index","mystudentmgmtwebapp/home"})
//        public String  showHomepage() {
//       return  "home/index";
//
//
//    }
//
//    package edu.mum.cs.cs425.demos.elibrary_springsec_1.controller;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;

    @Controller
    public class HomePageController {

        @GetMapping(value = {"/","/mystudentmgmtwebapp/home","/public/home"})
        public String home0() {
            return "redirect:/mystudentmgmtwebapp/home/public/home";
        }

        @GetMapping(value = {"/public/home","/mystudentmgmtwebapp/public/home"})
        public String home1() {
            return "public/index";
        }

        @GetMapping(value = {"/public/about","/mystudentmgmtwebapp/public/about"})
        public String about() {
            return "public/about";
        }

        @GetMapping(value = {"/public/virtualtour","/mystudentmgmtwebapp/public/virtualtour"})
        public String virtualtour() {
            return "public/virtualtour";
        }

        @GetMapping(value = {"/secured/home","/mystudentmgmtwebapp/secured/home"})
        public String home2() {
            return "secured/index";
        }

    }


