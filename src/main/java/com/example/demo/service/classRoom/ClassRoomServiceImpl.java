package com.example.demo.service.classRoom;

import java.util.List;

import com.example.demo.model.ClassRoom;

public interface ClassRoomServiceImpl {
    List<ClassRoom> getAllClassRooms();

    ClassRoom getClassRoomById(Long id);

    void saveClassRoom(ClassRoom classRoom);

    void deleteClassRoom(Long id);
}
