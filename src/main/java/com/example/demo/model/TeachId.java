package com.example.demo.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class TeachId implements Serializable {

	private static final long serialVersionUID = 1L;


	@Column(name = "professor_id")
	private Long professorId;
	
	
	@Column(name = "course_id")
	private Long courseId;

	public TeachId() {
		super();
	}

	public TeachId(Long professor, Long course) {
		super();
		this.professorId = professor;
		this.courseId = course;
	}

	public Long getProfessorId() {
		return professorId;
	}

	public void setProfessorId(Long professor) {
		this.professorId = professor;
	}

	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long course) {
		this.courseId = course;
	}
	
	   @Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (o == null || getClass() != o.getClass()) return false;
	        TeachId teachId = (TeachId) o;
	        return professorId == teachId.professorId && courseId == teachId.courseId;
	    }

	    @Override
	    public int hashCode() {
	        return Objects.hash(professorId, courseId);
	    }
}
