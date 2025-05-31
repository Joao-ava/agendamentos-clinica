package com.unifor.agendamentos.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class UserNotFound extends ResponseStatusException {
    public UserNotFound() {
        super(HttpStatus.NOT_FOUND, "Usuário não encontrado");
    }
}
