package com.unifor.agendamentos.services;

import com.unifor.agendamentos.models.UsersModel;
import com.unifor.agendamentos.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {
    private final UserRepository userRepository;

    public UsersService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UsersModel> list() {
        return userRepository.findAll();
    }
}
