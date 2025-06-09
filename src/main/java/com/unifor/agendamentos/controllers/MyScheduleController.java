package com.unifor.agendamentos.controllers;

import com.unifor.agendamentos.models.UsersModel;
import com.unifor.agendamentos.services.ScheduleService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class MyScheduleController {
    private ScheduleService scheduleService;

    public MyScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @GetMapping("/my-schedules")
    public String mySchedules(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UsersModel currentUser = (UsersModel) authentication.getPrincipal();
        model.addAttribute("schedules", scheduleService.findAllByPatient(currentUser));
        return "mySchedules";
    }
}
