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

import com.example.demo.model.ClassRoom;
import com.example.demo.service.classRoom.ClassRoomService;

@Controller
@RequestMapping("/classRoom")
public class ClassRoomController {

	
	private final ClassRoomService classRoomService;
	
	public ClassRoomController(ClassRoomService classRoomService) {
		this.classRoomService = classRoomService;
	}
	
	
	@GetMapping
	public String home() {
		return "classRoom/mainClassRoom";
	}
	
	@GetMapping("/viewClassRoom")
	public String allClassRoom(Model model) {
		List<ClassRoom> classRooms = classRoomService.getAllClassRooms();
		
		model.addAttribute("classRooms", classRooms);
		return "classRoom/viewClassRoom";
	}

	@GetMapping("/classRoomSearch")
	public String ClassRoomById(@RequestParam("id") Long id, Model model) {
		ClassRoom classRoom = classRoomService.getClassRoomById(id);
		
		if (List.of(classRoom) != null ) {
			model.addAttribute("classRoom", classRoom);
		} else {
			model.addAttribute("classRoom", classRoom);
			model.addAttribute("errorMessage", "No ClassRoom found with ID: " + id);
		}
		return "classRoom/ClassRoomSearch";		
	}

	@GetMapping("/addClassRoom")
	public String showAddClassRoom(Model model) {
		model.addAttribute("classRoom", new ClassRoom());
		return "classRoom/addClassRoom";

	}

	@PostMapping("/addClassRoom")
	public String addClassRoom(@ModelAttribute("classRoom") ClassRoom classRoom, RedirectAttributes redirectAttributes) {
		classRoomService.saveClassRoom(classRoom);
		redirectAttributes.addAttribute("successMessage", "ClassRoom saved successfully!");
		return "redirect:/classRoom/addClassRoom";
	}

	@GetMapping("/editClassRoom/{id}")
	public String showEditClassRoom(@PathVariable Long id, Model model) {
		ClassRoom classRoom = classRoomService.getClassRoomById(id);
		model.addAttribute("classRoom", classRoom);
		return "classRoom/editClassRoom";

	}

	@PostMapping("/editClassRoom/{id}")
	public String editClassRoom(@PathVariable Long id, @ModelAttribute("classRoom") ClassRoom classRoom) {
		classRoomService.saveClassRoom(classRoom);
		return "redirect:/classRoom";
	}

	@GetMapping("/deleteClassRoom/{id}")
	public String deleteClassRoom(@PathVariable Long id) {
		classRoomService.deleteClassRoom(id);
		return "redirect:/classRoom/viewClassRoom";
	}
}
