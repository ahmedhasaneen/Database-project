package com.example.demo.service.department;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Department;
import com.example.demo.repository.DepartmentRepository;

@Service
public class DepartmentService  implements DepartmentServiceImpl{
	private  DepartmentRepository DepartmentRepository;
	
	@Autowired
	public DepartmentService(DepartmentRepository DepartmentRepository)
	{
		this.DepartmentRepository = DepartmentRepository;
	}
	@Override
	public List<Department> getAllDepartments() {
		
		return DepartmentRepository.findAll();
	}
	@Override
	public Department getDepartmentById(Long Department_id) {
		Department Department = DepartmentRepository.findById(Department_id).orElse(null);
		return Department;
	}
	
	public Optional<Department> DepartmentById(Long Id){
		
		Optional<Department> Department = DepartmentRepository.findById(Id);
		return Department;
	}
	@Override
	public void saveDepartment(Department Department) {
		 DepartmentRepository.save(Department);
	}
	@Override
	public void deleteDepartment(Long Department_id) {
		DepartmentRepository.deleteById(Department_id);
	}

	
}









