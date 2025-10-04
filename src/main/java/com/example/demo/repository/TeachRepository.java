package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Teach;
import com.example.demo.model.TeachId;

@Repository
public interface TeachRepository extends JpaRepository<Teach,TeachId> {

}
