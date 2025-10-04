package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "class_room") // Optional: Specify the table name if needed
public class ClassRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generate the class_room_id
    private int class_room_id;

    private String building;

    private int floorNumber;

    private String path_no;

    private int capacity;

    private String available_equipment;

    private int class_id;

    // Constructor with all fields
    public ClassRoom(String building, int floorNumber, String path_no, int capacity, String available_equipment,
                     int class_id) {
        super();
        this.building = building;
        this.floorNumber = floorNumber;
        this.path_no = path_no;
        this.capacity = capacity;
        this.available_equipment = available_equipment;
        this.class_id = class_id;
    }

    // Default constructor
    public ClassRoom() {
    }

    // Getters and Setters
    public int getClass_room_id() {
        return class_room_id;
    }

    public void setClass_room_id(int class_room_id) {
        this.class_room_id = class_room_id;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public String getPath_no() {
        return path_no;
    }

    public void setPath_no(String path_no) {
        this.path_no = path_no;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getAvailable_equipment() {
        return available_equipment;
    }

    public void setAvailable_equipment(String available_equipment) {
        this.available_equipment = available_equipment;
    }

    public int getClass_id() {
        return class_id;
    }

    public void setClass_id(int class_id) {
        this.class_id = class_id;
    }
}
