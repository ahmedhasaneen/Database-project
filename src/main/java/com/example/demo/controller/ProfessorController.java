package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Professor;
import com.example.demo.service.professor.ProfessorService;

@Controller
@RequestMapping("/professor")
public class ProfessorController {

	@Autowired
	private ProfessorService professorsService;

	@GetMapping
	public String home() {
		return "professor/mainProfessor";
	}

	@GetMapping("/viewProfessor")
	public String allProfessor(Model model) {
		List<Professor> professor = professorsService.getAllProfessors();
		model.addAttribute("professor", professor);
		return "professor/viewProfessor";
	}

	@GetMapping("/{professor_id}")
	public String ProfessorsById(@PathVariable Long id, Model model) {
		Professor professor = professorsService.getProfessorById(id);
		model.addAttribute("professor", professor);
		return "professor/professorSearch";
	}

	@GetMapping("/addProfessor")
	public String showAddProfessor(Model model) {
		model.addAttribute("professor", new Professor());
		return "professor/addProfessor";

	}

	@PostMapping("/addProfessor")
	public String addProfessor(@ModelAttribute("professor") Professor Professor) {
		professorsService.saveProfessor(Professor);
		return "redirect:/professor";
	}

	@GetMapping("/editProfessor/{professor_id}")
	public String showEditvProfessor(@PathVariable Long id, Model model) {
		Professor professor = professorsService.getProfessorById(id);
		model.addAttribute("Professor", professor);
		return "professor/editProfessor";

	}

	@PostMapping("/editProfessor/{professor_id}")
	public String editProfessor(@PathVariable Long id, @ModelAttribute("professor") Professor Professor) {
		professorsService.saveProfessor(Professor);
		return "redirect:/editProfessor";
	}

	@GetMapping("/deleteProfessor/{Professor_id}")
	public String deleteProfessor(@PathVariable Long id) {
		professorsService.deleteProfessor(id);
		return "redirect:/professor";
	}
}
