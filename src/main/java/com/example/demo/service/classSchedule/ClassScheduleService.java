package com.example.demo.service.classSchedule;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.ClassSchedule;
import com.example.demo.repository.ClassScheduleRepository;

@Service
public class ClassScheduleService  implements ClassScheduleServiceImpl{
	private  ClassScheduleRepository classScheduleRepository;
	
	@Autowired
	public ClassScheduleService(ClassScheduleRepository classScheduleRepository)
	{
		this.classScheduleRepository = classScheduleRepository;
	}
	@Override
	public List<ClassSchedule> getAllClassSchedules() {
		
		return classScheduleRepository.findAll();
	}
	@Override
	public ClassSchedule getClassScheduleById(Long ClassSchedule_id) {
		ClassSchedule classSchedule = classScheduleRepository.findById(ClassSchedule_id).orElse(null);
		return classSchedule;
	}
	
	public Optional<ClassSchedule> ClassScheduleById(Long Id){
		
		Optional<ClassSchedule> classSchedule = classScheduleRepository.findById(Id);
		return classSchedule;
	}
	@Override
	public void saveClassSchedule(ClassSchedule classSchedule) {
		 classScheduleRepository.save(classSchedule);
	}
	@Override
	public void deleteClassSchedule(Long ClassSchedule_id) {
		classScheduleRepository.deleteById(ClassSchedule_id);
	}

	
}









