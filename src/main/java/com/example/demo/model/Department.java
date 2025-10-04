package com.example.demo.model;

import java.sql.Date;

public class Department {

	private int department_id;
	
	private String Dname;
	
	private String bu_location;
	
	private String presidnet;
	
	private Date per_start_data;
	
	
	
	

	public Department(String dname, String bu_location, String presidnet,
					  Date per_start_data) {
		
		this.Dname = dname;
		this.bu_location = bu_location;
		this.presidnet = presidnet;
		this.per_start_data = per_start_data;
	}

	public Department() {
		// TODO Auto-generated constructor stub
	}

	public int getDepartment_id() {
		return department_id;
	}

	public void setDepartment_id(int department_id) {
		this.department_id = department_id;
	}

	public String getDname() {
		return Dname;
	}

	public void setDname(String dname) {
		Dname = dname;
	}

	public String getBu_location() {
		return bu_location;
	}

	public void setBu_location(String bu_location) {
		this.bu_location = bu_location;
	}

	public String getPresidnet() {
		return presidnet;
	}

	public void setPresidnet(String presidnet) {
		this.presidnet = presidnet;
	}

	public Date getPer_start_data() {
		return per_start_data;
	}

	public void setPer_start_data(Date per_start_data) {
		this.per_start_data = per_start_data;
	}
	
	
}
