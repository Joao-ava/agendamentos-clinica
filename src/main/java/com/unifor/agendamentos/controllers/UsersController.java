package com.unifor.agendamentos.controllers;

import com.unifor.agendamentos.models.UsersModel;
import com.unifor.agendamentos.services.UsersService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
class UsersController {
    private final UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping("/users")
    public String list(Model model) {
        List<UsersModel> users = this.usersService.list();
        model.addAttribute("users", users);
        return "usersList";
    }
}
