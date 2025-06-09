package com.unifor.agendamentos.controllers;

import com.unifor.agendamentos.models.UsersModel;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class HomeController {
    @GetMapping("/")
    public String home(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UsersModel user = (UsersModel) authentication.getPrincipal();
        model.addAttribute("currentUser", user);
        return "home";
    }
}
