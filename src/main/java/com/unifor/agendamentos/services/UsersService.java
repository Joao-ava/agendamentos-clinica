package com.unifor.agendamentos.services;

import com.unifor.agendamentos.errors.UserNotFound;
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

    public UsersModel findById(Long id) throws UserNotFound {
        Optional<UsersModel> user = userRepository.findById(id);
        if (user.isEmpty()) throw new UserNotFound();
        return user.get();
    }

    public UsersModel update(Long id, UsersModel data) throws UserNotFound {
        UsersModel user = findById(id);
        boolean isSameEmail = user.getEmail().equals(data.getEmail());
        if (!isSameEmail && userRepository.findByEmail(data.getEmail()).isPresent()) {
            throw new UsersEmailAlreadyExist();
        }
        user.setName(data.getName());
        user.setEmail(data.getEmail());
        user.setPhone(data.getPhone());
        user.setRole(data.getRole());
        user.setPasswordHash(data.getPasswordHash());
        return userRepository.save(user);
    }
}
