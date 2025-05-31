package com.unifor.agendamentos.services;

import com.unifor.agendamentos.errors.UsersEmailAlreadyExist;
import com.unifor.agendamentos.models.UsersModel;
import com.unifor.agendamentos.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersService {
    private final UserRepository userRepository;

    public UsersService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UsersModel> list() {
        return userRepository.findAll();
    }

    public UsersModel add(UsersModel user) throws UsersEmailAlreadyExist {
        Optional<UsersModel> emailExist = userRepository.findByEmail(user.getEmail());
        if (emailExist.isPresent()) {
            throw new UsersEmailAlreadyExist();
        }
        return userRepository.save(user);
    }
}
