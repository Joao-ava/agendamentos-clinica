package com.unifor.agendamentos.models;

import jakarta.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TB_SCHEDULE")
public class ScheduleModel implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;


    public enum Status {
        AGENDADO,
        INICIADO,
        FINALIZADO,
        CANCELADO
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private LocalDateTime scheduleDate;

    @ManyToOne
    @JoinColumn(name="patient_id", nullable=false)
    private UsersModel patient;

    @ManyToOne
    @JoinColumn(name="doctor_id")
    private UsersModel doctor;

    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToMany(mappedBy = "schedule", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Exam> exams = new ArrayList<>();

    public ScheduleModel() {}

    public ScheduleModel(Long id, LocalDateTime scheduleDate, UsersModel patient, UsersModel doctor, Status status) {
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

    public UsersModel getPatient() {
        return patient;
    }

    public void setPatient(UsersModel patient) {
        this.patient = patient;
    }

    public UsersModel getDoctor() {
        return doctor;
    }

    public void setDoctor(UsersModel doctor) {
        this.doctor = doctor;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<Exam> getExams() {
        return exams;
    }

    public void setExams(List<Exam> exams) {
        this.exams = exams;
    }

    public void addExam(Exam exam) {
        exams.add(exam);
    }
}
