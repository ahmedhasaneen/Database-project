package com.example.demo.service.professor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Professor;
import com.example.demo.repository.ProfessorRepository;

@Service
public class ProfessorService  implements ProfessorServiceImpl{
	private  ProfessorRepository professorRepository;
	
	@Autowired
	public ProfessorService(ProfessorRepository professorRepository)
	{
		this.professorRepository = professorRepository;
	}
	@Override
	public List<Professor> getAllProfessors() {
		
		return professorRepository.findAll();
	}
	@Override
	public Professor getProfessorById(Long professor_id) {
		Professor professor = professorRepository.findById(professor_id).orElse(null);
		return professor;
	}
	@Override
	public void saveProfessor(Professor professor) {
		 professorRepository.save(professor);
	}
	@Override
	public void deleteProfessor(Long professor_id) {
		professorRepository.deleteById(professor_id);
	}

	
}









