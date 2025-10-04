package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "administrative_staff")
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "employee_id")
	private Long employeeId;
	
	@Column(name = "admin_name")
	private String ename;
	
	@Column(name = "admin_position")
	private String position;

	@Column(name = "phone")
	private String phone;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "department_id")
	private int departmentId;

	public Admin(String ename, int departmentid, String position, String phone, String email) {
		super();
		this.ename = ename;
		this.departmentId = departmentid;
		this.position = position;
		this.phone = phone;
		this.email = email;
	}
	public Admin() {
		super();
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employee_id) {
		this.employeeId = employee_id;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentid) {
		this.departmentId = departmentid;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
