package com.unifor.agendamentos.repositories;

import com.unifor.agendamentos.enums.Role;
import com.unifor.agendamentos.models.UsersModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UsersModel, Long> {
    Optional<UsersModel> findByEmail(String email);
    List<UsersModel> findAllByRole(Role role);
}
