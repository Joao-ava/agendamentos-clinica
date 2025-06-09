package com.unifor.agendamentos.repositories;

import com.unifor.agendamentos.models.ScheduleModel;
import com.unifor.agendamentos.models.UsersModel;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ScheduleRepository extends JpaRepository<ScheduleModel, Long> {
    List<ScheduleModel> findAllByPatient(UsersModel patient);
}
