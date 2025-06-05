package com.unifor.agendamentos.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class AppointmentModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime appointmentDate;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private PatientModel patient;

    @ManyToOne
    @JoinColumn(name = "receptionist_id")
    private ReceptionistModel receptionist;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public LocalDateTime getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDateTime appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public PatientModel getPatient() {
        return patient;
    }

    public void setPatient(PatientModel patient) {
        this.patient = patient;
    }

    public ReceptionistModel getReceptionist() {
        return receptionist;
    }

    public void setReceptionist(ReceptionistModel receptionist) {
        this.receptionist = receptionist;
    }
}
