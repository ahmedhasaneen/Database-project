package com.example.demo.model;

import java.io.Serializable;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "teach")
public class Teach implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@EmbeddedId
	private TeachId teachId;
	

	public Teach() {
	    if (this.teachId == null) {
	        this.teachId = new TeachId();  // Initialize the TeachId
	    }
	}


	public Teach(TeachId teachId) {
		super();
		this.teachId = teachId;
	}


	public TeachId getTeachId() {
		return teachId;
	}


	public void setTeachId(TeachId teachId) {
	    if (teachId == null) {
	        this.teachId = new TeachId();  // Or handle it differently based on your design
	    } else {
	        this.teachId = teachId;
	    }
	}


	
    @Override
    public String toString() {
        return "Teach{" +
                "id=" + teachId +
                '}';
    }
    
    public Long getProfessorId() {
    	return teachId.getProfessorId();
    }
    
    public void setProfessorId(Long professorId) {
    	if (this.teachId == null) {
			this.teachId = new TeachId();
		}
    	this.teachId.setProfessorId(professorId);
    }
    
    public Long getCourseId() {
    	return teachId.getCourseId();
    }
    
    public void setCourseId(Long courseId) {
    	if (this.teachId == null) {
    		this.teachId = new TeachId();
    	}
    	this.teachId.setProfessorId(courseId);
    }
    
}
