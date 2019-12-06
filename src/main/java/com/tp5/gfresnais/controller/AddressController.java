package com.tp5.gfresnais.controller;

import com.tp5.gfresnais.model.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AddressController {

    @GetMapping("/adresse")
    public String greeting(Model model) {
        return "address";
    }
}
