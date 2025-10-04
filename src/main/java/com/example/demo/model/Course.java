package com.example.demo.model;

public class Course {

	private int course_id;
	private String Cname;
	private int hours;
	private String text;
	private int department_id;
	
	

	
	public Course(String cname, int hours, String text,int department_id) {
		super();
		Cname = cname;
		this.hours = hours;
		this.text = text;
		this.department_id = department_id;
	}
	public Course() {
		// TODO Auto-generated constructor stub
	}
	public int getCourse_id() {
		return course_id;
	}
	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}
	public String getCname() {
		return Cname;
	}
	public void setCname(String cname) {
		Cname = cname;
	}
	public int getHours() {
		return hours;
	}
	public void setHours(int hours) {
		this.hours = hours;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public int getDepartment_id() {
		return department_id;
	}
	public void setDepartment_id(int department_id) {
		this.department_id = department_id;
	}
	
	
	
}
