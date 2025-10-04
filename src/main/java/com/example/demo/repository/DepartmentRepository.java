package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Department;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {

}
