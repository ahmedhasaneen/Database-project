package com.example.demo.model;

public class Administrative_staff {

	private int employee_id;
	
	private String ename;
	
	private int department_id;
	
	private String position;

	private String phone;
	
	private String email;

	public Administrative_staff(String ename, int department_id, String position, String phone, String email) {
		super();
		this.ename = ename;
		this.department_id = department_id;
		this.position = position;
		this.phone = phone;
		this.email = email;
	}

	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public int getDepartment_id() {
		return department_id;
	}

	public void setDepartment_id(int department_id) {
		this.department_id = department_id;
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
