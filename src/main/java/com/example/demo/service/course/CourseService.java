package com.example.demo.service.course;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Course;
import com.example.demo.repository.CourseRepository;

@Service
public class CourseService  implements CourseServiceImpl{
	private  CourseRepository courseRepository;
	
	@Autowired
	public CourseService(CourseRepository courseRepository)
	{
		this.courseRepository = courseRepository;
	}
	@Override
	public List<Course> getAllCourses() {
		
		return courseRepository.findAll();
	}
	@Override
	public Course getCourseById(Long Course_id) {
		Course Course = courseRepository.findById(Course_id).orElse(null);
		return Course;
	}
	
	public Optional<Course> CourseById(Long Id){
		
		Optional<Course> course = courseRepository.findById(Id);
		return course;
	}
	@Override
	public void saveCourse(Course course) {
		 courseRepository.save(course);
	}
	@Override
	public void deleteCourse(Long Course_id) {
		courseRepository.deleteById(Course_id);
	}

	
}









