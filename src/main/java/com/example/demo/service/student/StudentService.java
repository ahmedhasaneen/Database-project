package com.example.demo.service.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;

@Service
public class StudentService  implements StudentServiceImpl{
	private  StudentRepository studentRepository;
	
	@Autowired
	public StudentService(StudentRepository studentRepository)
	{
		this.studentRepository = studentRepository;
	}
	@Override
	public List<Student> getAllStudents() {
		
		return studentRepository.findAll();
	}
	@Override
	public Student getStudentById(Long student_id) {
		Student student = studentRepository.findById(student_id).orElseThrow(() -> new RuntimeException("Student not found"));
		return student;
	}
	@Override
	public void saveStudent(Student student) {
		 studentRepository.save(student);
	}
	@Override
	public void deleteStudent(Long student_id) {
		studentRepository.deleteById(student_id);
	}

	
}









