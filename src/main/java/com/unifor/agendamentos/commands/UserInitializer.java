package com.unifor.agendamentos.commands;

import com.unifor.agendamentos.enums.Role;
import com.unifor.agendamentos.models.UsersModel;
import com.unifor.agendamentos.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UserInitializer implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        if (userRepository.findByEmail("admin@email.com").isEmpty()) {
            UsersModel user = new UsersModel();
            user.setName("admin");
            user.setEmail("admin@email.com");
            user.setPhone("123456789");
            user.setPasswordHash("123456");
            user.setRole(Role.DOCTOR);
            userRepository.save(user);
            System.out.println("Usuário admin criado!");
        }
    }
}

