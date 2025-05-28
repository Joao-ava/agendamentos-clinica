package com.unifor.agendamentos.models;

public class DoctorModel extends UsersModel {

    public void cancelSchedule(ScheduleModel schedule) {
        schedule.setStatus(ScheduleModel.Status.CANCELADO);
        System.out.println("Agendamento cancelado com sucesso.");
    }

    public void finishSchedule(ScheduleModel schedule) {
        schedule.setStatus(ScheduleModel.Status.FINALIZADO);
        System.out.println("Agendamento finalizado com sucesso.");
    }

}
