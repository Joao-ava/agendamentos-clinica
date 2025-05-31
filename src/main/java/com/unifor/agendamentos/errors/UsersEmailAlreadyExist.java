package com.unifor.agendamentos.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class UsersEmailAlreadyExist extends ResponseStatusException {
    public UsersEmailAlreadyExist() {
        super(HttpStatus.BAD_REQUEST, "Usuário já existe");
    }
}
