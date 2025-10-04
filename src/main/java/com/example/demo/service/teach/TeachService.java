package com.example.demo.service.teach;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Teach;
import com.example.demo.model.TeachId;
import com.example.demo.repository.TeachRepository;

@Service
public class TeachService  implements TeachServiceImpl{
	private  TeachRepository teachRepository;
	
	@Autowired
	public TeachService(TeachRepository teachRepository)
	{
		this.teachRepository = teachRepository;
	}
	@Override
	public List<Teach> getAllTeachs() {
		
		return teachRepository.findAll();
	}
	@Override
	public Teach getTeachById(TeachId Teach_id) {
		Teach teach = teachRepository.findById(Teach_id).orElse(null);
		return teach;
	}
	
	public Optional<Teach> TeachById(TeachId Id){
		
		Optional<Teach> teach = teachRepository.findById(Id);
		return teach;
	}
	@Override
	public void saveTeach(Teach Teach) {
		teachRepository.save(Teach);
	}
	@Override
	public void deleteTeach(TeachId id) {
		teachRepository.deleteById(id);
	}

	
}









