package com.jose.curso.springboot.webapp.springboot_web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.jose.curso.springboot.webapp.springboot_web.controllers.models.Users;


@Controller
public class UserController {

    @GetMapping("/details")
    public String details(Model model) {
        Users user = new Users("Esteban", "Lopez");
        model.addAttribute("title", "Hola Mundo Spring Boot");
        model.addAttribute("user", user);
        return "details";
    }
}
