package com.unifor.agendamentos.models;

import com.unifor.agendamentos.enums.Role;

import java.time.LocalDateTime;

public class PatientModel extends UsersModel {

    public PatientModel() {
        super();
    }

    public PatientModel(UsersModel usersModel) {
        this.setId(usersModel.getId());
        this.setName(usersModel.getName());
        this.setEmail(usersModel.getEmail());
        this.setRole(usersModel.getRole());
        this.setPhone(usersModel.getPhone());
    }

    public boolean isOwnerSchedule(ScheduleModel schedule) {
        return this.getId().equals(schedule.getPatient().getId());
    }

    public void cancelSchedule(ScheduleModel schedule) {
        schedule.setStatus(ScheduleModel.Status.CANCELADO);
        System.out.println("Agendamento cancelado com sucesso.");
    }

}


