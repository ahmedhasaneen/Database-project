package com.example.demo.service.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Admin;
import com.example.demo.repository.AdminRepository;

@Service
public class AdminService  implements AdminServiceImpl{
	private  AdminRepository AdminRepository;
	
	@Autowired
	public AdminService(AdminRepository AdminRepository)
	{
		this.AdminRepository = AdminRepository;
	}
	@Override
	public List<Admin> getAllAdmins() {
		
		return AdminRepository.findAll();
	}
	@Override
	public Admin getAdminById(Long Admin_id) {
		Admin Admin = AdminRepository.findById(Admin_id).orElse(null);
		return Admin;
	}
	@Override
	public void saveAdmin(Admin Admin) {
		 AdminRepository.save(Admin);
	}
	@Override
	public void deleteAdmin(Long Admin_id) {
		AdminRepository.deleteById(Admin_id);
	}

	
}









