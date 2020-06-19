package edu.miu.cs.cs425.finalexam.hawkeyesupermart.customer_relationship_management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/home")
    public String displayHome(Model model){
        model.addAttribute(model);
        return "index";

    }
}
