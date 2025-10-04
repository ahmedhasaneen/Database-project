package com.example.demo.model;

import java.sql.Time;

public class ClassSchedule {

	private int class_id;
	
	private String location;
	
	private Time time;
	
	private String days;


	
	public ClassSchedule(String location, Time time, String days) {
		super();
		this.location = location;
		this.time = time;
		this.days = days;
	}

	public ClassSchedule() {
		// TODO Auto-generated constructor stub
	}

	public int getClass_id() {
		return class_id;
	}

	public void setClass_id(int class_id) {
		this.class_id = class_id;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public String getDays() {
		return days;
	}

	public void setDays(String days) {
		this.days = days;
	}
	
	
	
}
