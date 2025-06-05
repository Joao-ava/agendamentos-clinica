package com.unifor.agendamentos.services;

import com.unifor.agendamentos.models.AppointmentModel;
import com.unifor.agendamentos.repositories.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    public AppointmentModel createAppointment(AppointmentModel appointment) {
        return appointmentRepository.save(appointment);
    }

    public List<AppointmentModel> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    public Optional<AppointmentModel> getAppointmentById(Long id) {
        return appointmentRepository.findById(id);
    }

    public void deleteAppointment(Long id) {
        appointmentRepository.deleteById(id);
    }
}
