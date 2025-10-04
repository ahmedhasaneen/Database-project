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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.model.Department;
import com.example.demo.service.department.DepartmentService;

@Controller
@RequestMapping("/department")
public class DepartmentController {

	
	private DepartmentService departmentService;
	@Autowired 
	public DepartmentController(DepartmentService departmentService) {
		this.departmentService =  departmentService;
	}
	
	
	@GetMapping
	public String home() {
		return "department/mainDepartment";
	}
	
	@GetMapping("/viewDepartment")
	public String allDepartment(Model model) {
		List<Department> departments = departmentService.getAllDepartments();
		
		model.addAttribute("departments", departments);
		return "department/viewDepartment";
	}

	@GetMapping("/departmentSearch")
	public String departmentById(@RequestParam("id") Long id, Model model) {
		Department department = departmentService.getDepartmentById(id);
		
		if (List.of(department) != null ) {
			model.addAttribute("department", department);
		} else {
			model.addAttribute("department", department);
			model.addAttribute("errorMessage", "No Department found with ID: " + id);
		}
		return "department/departmentSearch";		
	}

	@GetMapping("/addDepartment")
	public String showAddDepartment(Model model) {
		model.addAttribute("department", new Department());
		return "department/addDepartment";

	}

	@PostMapping("/addDepartment")
	public String addDepartment(@ModelAttribute("department") Department department, RedirectAttributes redirectAttributes) {
		departmentService.saveDepartment(department);
		redirectAttributes.addAttribute("successMessage", "Department saved successfully!");
		return "redirect:/department/addDepartment";
	}

	@GetMapping("/editDepartment/{id}")
	public String showEditDepartment(@PathVariable Long id, Model model) {
		Department department = departmentService.getDepartmentById(id);
		model.addAttribute("department", department);
		return "department/editDepartment";

	}

	@PostMapping("/editDepartment/{id}")
	public String editDepartment(@PathVariable Long id, @ModelAttribute("department") Department department) {
		departmentService.saveDepartment(department);
		return "redirect:/department";
	}

	@GetMapping("/deleteDepartment/{id}")
	public String deleteDepartment(@PathVariable Long id) {
		departmentService.deleteDepartment(id);
		return "redirect:/department/viewDepartment";
	}
}
