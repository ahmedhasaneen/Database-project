package com.example.demo.service.classRoom;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.ClassRoom;
import com.example.demo.repository.ClassRoomRepository;

@Service
public class ClassRoomService  implements ClassRoomServiceImpl{
	private  ClassRoomRepository classRoomRepository;
	
	@Autowired
	public ClassRoomService(ClassRoomRepository classRoomRepository)
	{
		this.classRoomRepository = classRoomRepository;
	}
	@Override
	public List<ClassRoom> getAllClassRooms() {
		
		return classRoomRepository.findAll();
	}
	@Override
	public ClassRoom getClassRoomById(Long ClassRoom_id) {
		ClassRoom classRoom = classRoomRepository.findById(ClassRoom_id).orElse(null);
		return classRoom;
	}
	
	public Optional<ClassRoom> ClassRoomById(Long Id){
		
		Optional<ClassRoom> classRoom = classRoomRepository.findById(Id);
		return classRoom;
	}
	@Override
	public void saveClassRoom(ClassRoom classRoom) {
		 classRoomRepository.save(classRoom);
	}
	@Override
	public void deleteClassRoom(Long ClassRoom_id) {
		classRoomRepository.deleteById(ClassRoom_id);
	}

	
}









