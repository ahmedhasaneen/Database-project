package com.example.demo.service.department;

import java.util.List;

import com.example.demo.model.Department;

public interface DepartmentServiceImpl {
    List<Department> getAllDepartments();

    Department getDepartmentById(Long id);

    void saveDepartment(Department department);

    void deleteDepartment(Long id);
}
