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

import com.example.demo.model.Admin;
import com.example.demo.service.admin.AdminService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	
	private AdminService adminService;
	@Autowired 
	public AdminController(AdminService adminService) {
		this.adminService =  adminService;
	}

	@GetMapping
	public String home() {
		return "admin/mainAdmin";
	}
	
	@GetMapping("/viewAdmin")
	public String allAdmin(Model model) {
		List<Admin> Admins = adminService.getAllAdmins();
		
		model.addAttribute("admins", Admins);
		return "admin/viewAdmin";
	}

	@GetMapping("/adminSearch")
	public String AdminById(@RequestParam("id") Long id, Model model) {
		Admin admin = adminService.getAdminById(id);
		
		if (List.of(admin) != null ) {
			model.addAttribute("admin", admin);
		} else {
			model.addAttribute("admin", admin);
			model.addAttribute("errorMessage", "No Admin found with ID: " + id);
		}
		return "admin/adminSearch";		
	}

	@GetMapping("/addAdmin")
	public String showAddAdmin(Model model) {
		model.addAttribute("admin", new Admin());
		return "admin/addAdmin";

	}

	@PostMapping("/addAdmin")
	public String addAdmin(@ModelAttribute("admin") Admin admin, RedirectAttributes redirectAttributes) {
		adminService.saveAdmin(admin);
		redirectAttributes.addAttribute("successMessage", "Admin saved successfully!");
		return "redirect:/admin/addAdmin";
	}

	@GetMapping("/editAdmin/{id}")
	public String showEditAdmin(@PathVariable Long id, Model model) {
		Admin admin = adminService.getAdminById(id);
		model.addAttribute("admin", admin);
		return "admin/editAdmin";

	}

	@PostMapping("/editAdmin/{id}")
	public String editAdmin(@PathVariable Long id, @ModelAttribute("admin") Admin admin) {
		adminService.saveAdmin(admin);
		return "redirect:/admin";
	}

	@GetMapping("/deleteAdmin/{id}")
	public String deleteAdmin(@PathVariable Long id) {
		adminService.deleteAdmin(id);
		return "redirect:/admin/viewAdmin";
	}
}
