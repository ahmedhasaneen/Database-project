package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.ClassRoom;

@Repository
public interface ClassRoomRepository extends JpaRepository<ClassRoom,Long> {

}
