package com.bandgeeks.beans;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;



@Entity
@Table(name="instructors")
@PrimaryKeyJoinColumn(name="instructor_id")

public class Instructor extends User {
		
	
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)	
	@JoinColumn(name= "instructor_course_id")
	private Course course;



	






	public Instructor() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Instructor(int id) {
		super(id);
	}
	public Instructor(int id, String username, String password) {
		super(id, username, password);
	}


	public Course getCourse() {
		return course;
	}



	public void setCourseId(Course course) {
		this.course = course;
	}



	@Override
	public String toString() {
		return "Instructor [course=" + course + "]";
	}








	
	
	

	
	
}
