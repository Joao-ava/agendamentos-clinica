package com.unifor.agendamentos.controllers;

import com.unifor.agendamentos.models.Exam;
import com.unifor.agendamentos.models.ScheduleModel;
import com.unifor.agendamentos.services.ExamService;
import com.unifor.agendamentos.services.ScheduleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
class ExamController {
    private ScheduleService scheduleService;
    private ExamService examService;

    public ExamController(ScheduleService scheduleService, ExamService examService) {
        this.scheduleService = scheduleService;
        this.examService = examService;
    }

    @GetMapping("/schedules/{id}/attach-exam")
    public String attachExamForm(@PathVariable Long id, Model model) {
        ScheduleModel schedule = scheduleService.findById(id);
        Exam exam = new Exam();
        exam.setSchedule(schedule);
        model.addAttribute("exam", exam);
        return "attachExam";
    }

    @PostMapping("/exam/attach-exam")
    public String attachExam(Exam exam) {
        examService.add(exam);
        return "redirect:/schedules/" + exam.getSchedule().getId() + "/details";
    }

    @GetMapping("/exam/{id}/delete")
    public String deleteExam(@PathVariable Long id) {
        Exam exam = examService.findById(id);
        Long scheduleId = exam.getSchedule().getId();
        examService.delete(exam);
        return "redirect:/schedules/" + scheduleId + "/details";
    }

    @GetMapping("/exam/{id}/edit")
    public String editExamForm(@PathVariable Long id, Model model) {
        Exam exam = examService.findById(id);
        model.addAttribute("exam", exam);
        return "examEdit";
    }

    @PostMapping("/exam/{id}/edit")
    public String editExam(@PathVariable Long id, Exam data) {
        Exam exam = examService.update(id, data);
        return "redirect:/schedules/" + exam.getSchedule().getId() + "/details";
    }
}
