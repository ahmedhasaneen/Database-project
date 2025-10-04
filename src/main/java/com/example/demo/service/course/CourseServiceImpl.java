package com.example.demo.service.course;

import java.util.List;

import com.example.demo.model.Course;

public interface CourseServiceImpl {
    List<Course> getAllCourses();

    Course getCourseById(Long id);

    void saveCourse(Course course);

    void deleteCourse(Long id);
}
