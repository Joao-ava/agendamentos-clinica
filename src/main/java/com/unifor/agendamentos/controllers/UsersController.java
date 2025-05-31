package com.unifor.agendamentos.controllers;

import com.unifor.agendamentos.models.UsersModel;
import com.unifor.agendamentos.services.UsersService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/users")
class UsersController {
    private final UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping("")
    public String list(Model model) {
        List<UsersModel> users = this.usersService.list();
        model.addAttribute("users", users);
        return "usersList";
    }

    @GetMapping("/add")
    public String saveForm(Model model) {
        model.addAttribute("user", new UsersModel());
        return "usersAdd";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute UsersModel user) {
        usersService.add(user);
        return "redirect:/users";
    }
}
