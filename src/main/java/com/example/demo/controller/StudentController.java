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

import com.example.demo.model.Student;
import com.example.demo.service.student.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {

	
	private StudentService studentService;

	public StudentController(StudentService studentService) {
		this.studentService =  studentService;
	}
	
	
	@GetMapping
	public String home() {
		return "student/mainStudent";
	}
	
	@GetMapping("/viewStudent")
	public String allStudent(Model model) {
		List<Student> students = studentService.getAllStudents();
		
		model.addAttribute("students", students);
		return "student/viewStudent";
	}

	@GetMapping("/{studentId}")
	public String studentById(@PathVariable Long id, Model model) {
		Student student = studentService.getStudentById(id);
		model.addAttribute("student", student);
		return "student/studentSearch";
	}

	@GetMapping("/addStudent")
	public String showAddStudent(Model model) {
		model.addAttribute("student", new Student());
		return "student/addStudent";

	}

	@PostMapping("/addStudent")
	public String addStudent(@ModelAttribute("student") Student student) {
		studentService.saveStudent(student);
		return "redirect:/student/addStudent";
	}

	@GetMapping("/editStudent/{id}")
	public String showEditStudent(@PathVariable Long id, Model model) {
		Student student = studentService.getStudentById(id);
		model.addAttribute("student", student);
		return "student/editStudent";

	}

	@PostMapping("/editStudent/{id}")
	public String editStudent(@PathVariable Long id, @ModelAttribute("student") Student student) {
		studentService.saveStudent(student);
		return "redirect:/student/viewStudent";
	}

	@GetMapping("/deleteStudent/{id}")
	public String deleteStudent(@PathVariable Long id) {
		studentService.deleteStudent(id);
		return "redirect:/student/viewStudent";
	}
}
