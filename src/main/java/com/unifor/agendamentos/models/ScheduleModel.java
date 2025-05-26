package com.unifor.agendamentos.models;

import jakarta.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "TB_SCHEDULE")
public class ScheduleModel implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;


    public enum Status {
        AGENDADO,
        FINALIZADO,
        CANCELADO
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private LocalDateTime scheduleDate;
    private String patient;
    private String doctor;

    @Enumerated(EnumType.STRING)
    private Status status;

    public ScheduleModel() {}

    public ScheduleModel(Long id, LocalDateTime scheduleDate, String patient, String doctor, Status status) {
        this.id = id;
        this.scheduleDate = scheduleDate;
        this.patient = patient;
        this.doctor = doctor;
        this.status = status;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getScheduleDate() {
        return scheduleDate;
    }

    public void setScheduleDate(LocalDateTime scheduleDate) {
        this.scheduleDate = scheduleDate;
    }

    public String getPatient() {
        return patient;
    }

    public void setPatient(String patient) {
        this.patient = patient;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

}
