package com.unifor.agendamentos.services;

import com.unifor.agendamentos.models.ScheduleModel;
import com.unifor.agendamentos.models.UsersModel;
import com.unifor.agendamentos.repositories.ScheduleRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;

    public ScheduleService(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    public List<ScheduleModel> list() {
        return scheduleRepository.findAll();
    }

    public ScheduleModel add(ScheduleModel schedule) {
        schedule.setStatus(ScheduleModel.Status.AGENDADO);
        return scheduleRepository.save(schedule);
    }

    public List<ScheduleModel> findAllByPatient(UsersModel patient) {
        return scheduleRepository.findAllByPatient(patient);
    }

    public ScheduleModel start(Long id) {
        Optional<ScheduleModel> optional = scheduleRepository.findById(id);
        if (optional.isPresent()) {
            ScheduleModel schedule = optional.get();
            schedule.setStatus(ScheduleModel.Status.INICIADO);
            return scheduleRepository.save(schedule);
        }
        throw new RuntimeException("Agendamento não encontrado.");
    }

    public ScheduleModel finalizeSchedule(Long id) {
        Optional<ScheduleModel> optional = scheduleRepository.findById(id);
        if (optional.isPresent()) {
            ScheduleModel schedule = optional.get();
            schedule.setStatus(ScheduleModel.Status.FINALIZADO);
            return scheduleRepository.save(schedule);
        }
        throw new RuntimeException("Agendamento não encontrado.");
    }

    public ScheduleModel updateDate(Long id, LocalDateTime newDate) {
        Optional<ScheduleModel> optional = scheduleRepository.findById(id);
        if (optional.isPresent()) {
            ScheduleModel schedule = optional.get();
            schedule.setScheduleDate(newDate);
            return scheduleRepository.save(schedule);
        }
        throw new RuntimeException("Agendamento não encontrado.");
    }

    public ScheduleModel findById(Long id) {
        return scheduleRepository.findById(id).orElseThrow(() -> new RuntimeException("Agendamento não encontrado."));
    }

    public Long delete(Long id) {
        scheduleRepository.deleteById(id);
        return id;
    }

    
}
