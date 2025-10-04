package com.example.demo.service.student;

import java.util.List;

import com.example.demo.model.Student;

public interface StudentServiceImpl {
    List<Student> getAllStudents();

    Student getStudentById(Long id);

    void saveStudent(Student student);

    void deleteStudent(Long id);
}
