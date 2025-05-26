package com.unifor.agendamentos.models;

public class ReceptionistModel {

    public void finishSchedule(ScheduleModel schedule) {
        schedule.setStatus(ScheduleModel.Status.FINALIZADO);
        System.out.println("Agendamento finalizado com sucesso.");
    }
}
