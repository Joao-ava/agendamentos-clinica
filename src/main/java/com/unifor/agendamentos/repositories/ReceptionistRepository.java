package com.unifor.agendamentos.repositories;

import com.unifor.agendamentos.models.ReceptionistModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceptionistRepository extends JpaRepository<ReceptionistModel, Long> {
}
