package com.tp5.gfresnais.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WelcomeController {
    @GetMapping("/")
    public String greeting(Model model) {
        return "welcome";
    }
}
