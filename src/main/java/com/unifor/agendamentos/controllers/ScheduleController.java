package com.unifor.agendamentos.controllers;

import com.unifor.agendamentos.models.ScheduleModel;
import com.unifor.agendamentos.services.ScheduleService;
import com.unifor.agendamentos.services.UsersService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
@RequestMapping("/schedules")
public class ScheduleController {

    private final ScheduleService scheduleService;
    private final UsersService usersService;

    public ScheduleController(ScheduleService scheduleService, UsersService usersService) {
        this.scheduleService = scheduleService;
        this.usersService = usersService;
    }

    @GetMapping("")
    public String list(Model model) {
        List<ScheduleModel> schedules = scheduleService.list();
        model.addAttribute("schedules", schedules);
        return "schedulesList";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("schedule", new ScheduleModel());
        model.addAttribute("users", usersService.list());
        model.addAttribute("doctors", usersService.listDoctors());
        model.addAttribute("patients", usersService.listPatients());
        return "schedulesAdd";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute ScheduleModel schedule) {
        scheduleService.add(schedule);
        return "redirect:/schedules";
    }

    @GetMapping("/{id}/details")
    public String details(@PathVariable Long id, Model model) {
        ScheduleModel scheduleDetails = scheduleService.findById(id);
        model.addAttribute("schedule", scheduleDetails);
        return "scheduleDetails";
    }

    @GetMapping("/{id}/start")
    public String start(@PathVariable Long id) {
        scheduleService.start(id);
        return "redirect:/schedules";
    }

    @GetMapping("/{id}/finalize")
    public String finalizeSchedule(@PathVariable Long id) {
        scheduleService.finalizeSchedule(id);
        return "redirect:/schedules";
    }

    @GetMapping("/{id}/edit-date")
    public String editDateForm(@PathVariable Long id, Model model) {
        ScheduleModel schedule = scheduleService.findById(id);
        model.addAttribute("schedule", schedule);
        model.addAttribute("users", usersService.list());
        model.addAttribute("doctors", usersService.listDoctors());
        model.addAttribute("patients", usersService.listPatients());
        return "schedulesUpdate";
    }

    @ModelAttribute("scheduleDateFormatted")
    public String formatDateTime(ScheduleModel schedule) {
        return schedule.getScheduleDate() != null
                ? schedule.getScheduleDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm"))
                : "";
    }

    @PostMapping("/{id}/update-date")
    public String updateDate(@PathVariable Long id,
                             @RequestParam("scheduleDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime scheduleDate) {
        scheduleService.updateDate(id, scheduleDate);
        return "redirect:/schedules";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        scheduleService.delete(id);
        return "redirect:/schedules";
    }
}
