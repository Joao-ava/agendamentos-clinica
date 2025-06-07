package com.unifor.agendamentos.repositories;

import com.unifor.agendamentos.models.Exam;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExamRepository extends JpaRepository<Exam, Long> {
}
