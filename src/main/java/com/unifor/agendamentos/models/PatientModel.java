package com.unifor.agendamentos.models;

import java.time.LocalDateTime;

public class PatientModel extends UsersModel {

    public PatientModel() {
        super();
    }

    public boolean isOwnerSchedule(ScheduleModel schedule) {
        return this.getId().equals(schedule.getPatient().getId());
    }

    public void cancelSchedule(ScheduleModel schedule) {
        schedule.setStatus(ScheduleModel.Status.CANCELADO);
        System.out.println("Agendamento cancelado com sucesso.");
    }

}


