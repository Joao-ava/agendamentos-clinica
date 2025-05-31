package com.unifor.agendamentos.controllers;

import com.unifor.agendamentos.models.UsersModel;
import com.unifor.agendamentos.services.UsersService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        UsersModel user = this.usersService.findById(id);
        model.addAttribute("user", user);
        return "usersUpdate";
    }

    @PostMapping("/{id}/update")
    public String edit(@PathVariable Long id, @ModelAttribute UsersModel user) {
        usersService.update(id, user);
        return "redirect:/users";
    }
}
