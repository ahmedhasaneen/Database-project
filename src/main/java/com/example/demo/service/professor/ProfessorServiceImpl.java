package com.example.demo.service.professor;

import java.util.List;

import com.example.demo.model.Professor;

public interface ProfessorServiceImpl {
    List<Professor> getAllProfessors();

    Professor getProfessorById(Long id);

    void saveProfessor(Professor professor);

    void deleteProfessor(Long id);
}
