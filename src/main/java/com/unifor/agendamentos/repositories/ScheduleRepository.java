package com.unifor.agendamentos.repositories;

import com.unifor.agendamentos.models.ScheduleModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<ScheduleModel, Long> {
}
