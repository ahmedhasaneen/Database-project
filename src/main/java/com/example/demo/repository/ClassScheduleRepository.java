package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.ClassSchedule;

@Repository
public interface ClassScheduleRepository extends JpaRepository<ClassSchedule,Long> {

}
