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

import com.example.demo.model.Course;
import com.example.demo.model.Teach;
import com.example.demo.model.TeachId;
import com.example.demo.service.course.CourseService;
import com.example.demo.service.teach.TeachService;

@Controller
@RequestMapping("/course")
public class CourseController {

	
	private  CourseService courseService;
	private TeachService teachService;
	
	
	@Autowired 
	public CourseController(CourseService courseService, TeachService teachService) {
		this.courseService =  courseService;
		this.teachService = teachService;
	}
	
	@GetMapping
	public String home() {
		return "course/mainCourse";
	}
	
	@GetMapping("/viewCourse")
	public String allCourse(Model model) {
		List<Course> courses = courseService.getAllCourses();
		
		model.addAttribute("courses", courses);
		return "course/viewCourse";
	}

	@GetMapping("/courseSearch")
	public String CourseById(@RequestParam("id") Long id, Model model) {
		Course course = courseService.getCourseById(id);
		
		if (List.of(course) != null ) {
			model.addAttribute("course", course);
		} else {
			model.addAttribute("course", course);
			model.addAttribute("errorMessage", "No Course found with ID: " + id);
		}
		return "course/courseSearch";		
	}

	@GetMapping("/addCourse")
	public String showAddCourse(Model model) {
		model.addAttribute("course", new Course());
		return "course/addCourse";

	}

	@PostMapping("/addCourse")
	public String addCourse(@ModelAttribute("course") Course course, RedirectAttributes redirectAttributes) {
		courseService.saveCourse(course);
		redirectAttributes.addAttribute("successMessage", "Course saved successfully!");
		return "redirect:/course/addCourse";
	}

	@GetMapping("/editCourse/{id}")
	public String showEditCourse(@PathVariable Long id, Model model) {
		Course course = courseService.getCourseById(id);
		model.addAttribute("course", course);
		return "course/editCourse";

	}

	@PostMapping("/editCourse/{id}")
	public String editCourse(@PathVariable Long id, @ModelAttribute("course") Course course) {
		courseService.saveCourse(course);
		return "redirect:/course";
	}

	@GetMapping("/deleteCourse/{id}")
	public String deleteCourse(@PathVariable Long id) {
		courseService.deleteCourse(id);
		return "redirect:/course/viewCourse";
	}
	
	
//now the teacher controller methods
//==================================
//==================================

	@GetMapping("/mainTeacher")
	public String homeTeach() {
		return"course/mainTeacher";
	}

	@GetMapping("/viewTeacher")
	public String allTeach(Model model) {
		List<Teach> teachs = teachService.getAllTeachs();

		model.addAttribute("teachs", teachs);
		return "course/viewTeacher";
	}

	@GetMapping("/teachSearch")
	public String TeachById(@RequestParam("professorId") Long professorId, @RequestParam("courseId") Long courseId,
			Model model) {
		TeachId teachId = new TeachId(professorId, courseId);
		Teach teach = teachService.getTeachById(teachId);

		if (List.of(teach) != null) {
			model.addAttribute("teach", teach);
		} else {
			model.addAttribute("teach", teach);
			model.addAttribute("errorMessage", "No Teach record found for given IDs.");
		}
		return "course/teachSearch";
	}

	@GetMapping("/addTeacher")
	public String showAddTeach(Model model) {
		model.addAttribute("teach", new Teach());
		return "course/addTeacher";

	}

	@PostMapping("/addTeacher")
	public String addTeach(@ModelAttribute("teach") Teach teach, RedirectAttributes redirectAttributes) {
		teachService.saveTeach(teach);
		redirectAttributes.addAttribute("successMessage", "Teach saved successfully!");
		return "redirect:/course/addTeacher";
	}

	@GetMapping("/editTeach/{id}")
	public String showEditTeach(@PathVariable TeachId id, Model model) {
		Teach teach = teachService.getTeachById(id);
		model.addAttribute("teach", teach);
		return "course/editTeacher";

	}

	@PostMapping("/editTeacher/{id}")
	public String editTeach(@PathVariable TeachId id, @ModelAttribute("teach") Teach teach) {
		teachService.saveTeach(teach);
		return "redirect:/course";
	}

	@GetMapping("/deleteTeacher/{id}")
	public String deleteTeach(@PathVariable TeachId id) {
		teachService.deleteTeach(id);
		return "redirect:/course/viewTeacher";
	}
	
	
}
