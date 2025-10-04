package com.example.demo.service.teach;

import java.util.List;

import com.example.demo.model.Teach;
import com.example.demo.model.TeachId;

public interface TeachServiceImpl {
	List<Teach> getAllTeachs();

	Teach getTeachById(TeachId id);

	void saveTeach(Teach teach);

	void deleteTeach(TeachId id);
}
