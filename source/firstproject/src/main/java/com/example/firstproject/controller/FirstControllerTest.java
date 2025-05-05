package com.example.firstproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirstControllerTest {

    @GetMapping("/hi")
    public String welcome(Model model){
        model.addAttribute("username", "jojo");
        return "greetings";
    }

    @GetMapping("/goodbye")
    public String bye(Model model) {
        model.addAttribute("username", "soso");
        return "goodbye";
    }
}
