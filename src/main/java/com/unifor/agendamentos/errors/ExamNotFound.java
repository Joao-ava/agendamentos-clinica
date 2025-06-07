package com.unifor.agendamentos.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class ExamNotFound extends ResponseStatusException {
    public ExamNotFound() {
        super(HttpStatus.NOT_FOUND, "Exame não encontrado");
    }
}
