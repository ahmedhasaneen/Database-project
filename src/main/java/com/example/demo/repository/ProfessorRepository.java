package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import java.lang.Long;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {

	
}
