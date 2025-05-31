package com.unifor.agendamentos.models;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "TB_EXAME")
public class Exam implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String type;
    private String result;

    @ManyToOne
    @JoinColumn(name = "schedule_id", nullable = false)
    private ScheduleModel schedule;

    public Exam() {}

    public Exam(String type, String result, ScheduleModel schedule) {
        this.type = type;
        this.result = result;
        this.schedule = schedule;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public ScheduleModel getSchedule() {
        return schedule;
    }

    public void setSchedule(ScheduleModel schedule) {
        this.schedule = schedule;
    }
}
