package com.example.demo.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "professor")
public class Professor {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long professor_id;

	@Column(name = "professor_name")
	private String name;

	@Column(name = "pbirth_date")
	private Date birthData;

	@Column(name = "phone_no")
	private String phone_no;

	@Column(name = "specialization")
	private String specialization;

	@Column(name = "email")
	private String email;

	@Column(name = "office_location")
	private String office_location;

	@Column(name = "class_id")
	private int class_id;

	@Column(name = "department_id")
	private int department_id;

	public Professor() {
		super();

	}

	public Professor(String name, Date birthData, String phone_no, String email, String specialization,
			String office_location, int class_id, int department_id) {
		super();
		this.name = name;
		this.birthData = birthData;
		this.phone_no = phone_no;
		this.email = email;
		this.specialization = specialization;
		this.office_location = office_location;
		this.class_id = class_id;
		this.department_id = department_id;
	}

	public Long getProfessor_id() {
		return professor_id;
	}

	public void setProfessor_id(Long professor_id) {
		this.professor_id = professor_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthData() {
		return birthData;
	}

	public void setBirthData(Date birthData) {
		this.birthData = birthData;
	}

	public String getPhone_no() {
		return phone_no;
	}

	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public String getOffice_location() {
		return office_location;
	}

	public void setOffice_location(String office_location) {
		this.office_location = office_location;
	}

	public int getClass_id() {
		return class_id;
	}

	public void setClass_id(int class_id) {
		this.class_id = class_id;
	}

	public int getDepartment_id() {
		return department_id;
	}

	public void setDepartment_id(int department_id) {
		this.department_id = department_id;
	}

	
}
