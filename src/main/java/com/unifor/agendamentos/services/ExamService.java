package com.unifor.agendamentos.services;

import com.unifor.agendamentos.errors.ExamNotFound;
import com.unifor.agendamentos.models.Exam;
import com.unifor.agendamentos.repositories.ExamRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ExamService {
    private ExamRepository examRepository;

    public ExamService(ExamRepository examRepository) {
        this.examRepository = examRepository;
    }

    public Exam add(Exam exam) {
        return examRepository.save(exam);
    }

    public Exam findById(Long id) {
        Optional<Exam> exam = examRepository.findById(id);
        if (exam.isEmpty()) throw new ExamNotFound();
        return exam.get();
    }

    public void update(Exam exam) {
        examRepository.save(exam);
    }

    public void delete(Exam exam) {
        examRepository.delete(exam);
    }
}
