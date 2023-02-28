package skypro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControllerNew {
    @GetMapping("/")
    public String showAllInfo(){
    return "allroom";
    }
    @GetMapping("/employee_room")
    public String showEmployeeRoom(){
        return "employeeroom";
    }
    @GetMapping("/it_room")
    public String showITRoom(){
        return "itroom";
    }
    @GetMapping("/security_room")
    public String showSecurityRoom(){
        return "securityroom";
    }
    @GetMapping("/director_room")
    public String showDirectorRoom(){
        return "directorroom";
    }
}
