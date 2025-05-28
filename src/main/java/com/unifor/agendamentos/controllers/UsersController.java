package com.unifor.agendamentos.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class UsersController {
    @GetMapping("/users")
    public String list(Model model) {
        return "usersList";
    }
}
