package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {

}
