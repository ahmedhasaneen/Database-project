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

import com.example.demo.model.ClassSchedule;
import com.example.demo.service.classSchedule.ClassScheduleService;

@Controller
@RequestMapping("/classSchedule")
public class ClassScheduleController {

	
	private ClassScheduleService classScheduleService;
	@Autowired 
	public ClassScheduleController(ClassScheduleService classScheduleService) {
		this.classScheduleService =  classScheduleService;
	}
	
	
	@GetMapping
	public String home() {
		return "classSchedule/mainClassSchedule";
	}
	
	@GetMapping("/viewClassSchedule")
	public String allClassSchedule(Model model) {
		List<ClassSchedule> classSchedules = classScheduleService.getAllClassSchedules();
		
		model.addAttribute("classSchedules", classSchedules);
		return "classSchedule/viewClassSchedule";
	}

	@GetMapping("/classScheduleSearch")
	public String ClassScheduleById(@RequestParam("id") Long id, Model model) {
		ClassSchedule classSchedule = classScheduleService.getClassScheduleById(id);
		
		if (List.of(classSchedule) != null ) {
			model.addAttribute("classSchedule", classSchedule);
		} else {
			model.addAttribute("classSchedule", classSchedule);
			model.addAttribute("errorMessage", "No ClassSchedule found with ID: " + id);
		}
		return "classSchedule/classScheduleSearch";		
	}

	@GetMapping("/addClassSchedule")
	public String showAddClassSchedule(Model model) {
		model.addAttribute("classSchedule", new ClassSchedule());
		return "classSchedule/addClassSchedule";

	}

	@PostMapping("/addClassSchedule")
	public String addClassSchedule(@ModelAttribute("ClassSchedule") ClassSchedule classSchedule, RedirectAttributes redirectAttributes) {
		classScheduleService.saveClassSchedule(classSchedule);
		redirectAttributes.addAttribute("successMessage", "ClassSchedule saved successfully!");
		return "redirect:/classSchedule/addClassSchedule";
	}

	@GetMapping("/editClassSchedule/{id}")
	public String showEditClassSchedule(@PathVariable Long id, Model model) {
		ClassSchedule classSchedule = classScheduleService.getClassScheduleById(id);
		model.addAttribute("classSchedule", classSchedule);
		return "classSchedule/editClassSchedule";

	}

	@PostMapping("/editClassSchedule/{id}")
	public String editClassSchedule(@PathVariable Long id, @ModelAttribute("ClassSchedule") ClassSchedule classSchedule) {
		classScheduleService.saveClassSchedule(classSchedule);
		return "redirect:/classSchedule";
	}

	@GetMapping("/deleteClassSchedule/{id}")
	public String deleteClassSchedule(@PathVariable Long id) {
		classScheduleService.deleteClassSchedule(id);
		return "redirect:/classSchedule/viewClassSchedule";
	}
}
