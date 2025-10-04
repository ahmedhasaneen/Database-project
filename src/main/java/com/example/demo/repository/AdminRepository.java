package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import java.lang.Long;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {

	
}
