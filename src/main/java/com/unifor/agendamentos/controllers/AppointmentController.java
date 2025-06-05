package com.unifor.agendamentos.controllers;

// Segundo o GPT para corrigir este erro é necessário compilar o AppointmenDTO
import com.unifor.agendamentos.dtos.AppointmentDTO;
import com.unifor.agendamentos.models.AppointmentModel;
import com.unifor.agendamentos.models.PatientModel;
import com.unifor.agendamentos.models.ReceptionistModel;
import com.unifor.agendamentos.repositories.PatientRepository;
import com.unifor.agendamentos.repositories.ReceptionistRepository;
import com.unifor.agendamentos.services.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private ReceptionistRepository receptionistRepository;

    @PostMapping
    public AppointmentModel createAppointment(@RequestBody AppointmentDTO appointmentDTO) {
        Optional<PatientModel> patient = patientRepository.findById(appointmentDTO.getPatientId());
        Optional<ReceptionistModel> receptionist = receptionistRepository.findById(appointmentDTO.getReceptionistId());

        if (patient.isPresent() && receptionist.isPresent()) {
            AppointmentModel appointment = new AppointmentModel();
            appointment.setAppointmentDate(appointmentDTO.getAppointmentDate());
            appointment.setPatient(patient.get());
            appointment.setReceptionist(receptionist.get());
            return appointmentService.createAppointment(appointment);
        } else {
            throw new RuntimeException("Paciente ou recepcionista não encontrado.");
        }
    }

    @GetMapping
    public List<AppointmentModel> getAllAppointments() {
        return appointmentService.getAllAppointments();
    }

    @DeleteMapping("/{id}")
    public void deleteAppointment(@PathVariable Long id) {
        appointmentService.deleteAppointment(id);
    }
}
