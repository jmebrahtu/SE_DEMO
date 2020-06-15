package edu.miu.cs425.studentmgmt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class StudentServiceController {

    @GetMapping(value = {"/secured/services","/mystudentmgmtwebapp/secured/services"})
    public String services() {
        return "secured/services";
    }

    @GetMapping(value = {"/secured/services/admin/usrmgmt/list","/mystudentmgmtwebapp/secured/services/admin/usrmgmt/list"})
    public String usrmgmtList() {
        return "secured/services/admin/usrmgmt/list";
    }

}
