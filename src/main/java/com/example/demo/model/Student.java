package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "student")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "student_id")
	private Long studentId;
	
	@Column(name = "sname")
	private String name;
	
	@Column(name = "birth_date")
	private String birthData;
	
	@Column(name = "sex")
	private char sex;
	
	@Column(name = "major")
	private String major;
	
	@Column(name = "gpa")
	private double GPA;
	
	@Column(name = "enrollment_year")
	private int enrollment_year;

	
	
	public Student( String name, String birthData, char sex, String major, double gpa, int enrollment_year) {
		super();
		this.name = name;
		this.birthData = birthData;
		this.sex = sex;
		this.major = major;
		GPA = gpa;
		this.enrollment_year = enrollment_year;
	}
	
	public Student() {

		
	}

	public Long getId() {
		return studentId;
	}
	public void setId(Long id) {
		this.studentId = id;
	}
	public String getBirthData() {
		return birthData;
	}
	public void setBirthData(String birthData) {
		this.birthData = birthData;
	}
	public char getSex() {
		return sex;
	}
	public void setSex(char sex) {
		this.sex = sex;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public double getGPA() {
		return GPA;
	}
	public void setGPA(double gPA) {
		GPA = gPA;
	}
	public int getEnrollment_year() {
		return enrollment_year;
	}
	public void setEnrollment_year(int enrollment_year) {
		this.enrollment_year = enrollment_year;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", name=" + name + ", birthData=" + birthData + ", sex=" + sex
				+ ", major=" + major + ", GPA=" + GPA + ", enrollment_year=" + enrollment_year + "]";
	}
	
	
	
}
