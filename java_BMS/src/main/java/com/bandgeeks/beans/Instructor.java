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
@PrimaryKeyJoinColumn(name="user_id")

public class Instructor extends User {
		
	
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)	
	@JoinColumn(name= "course_id")
	private Course courseId;



	






	public Course getCourseId() {
		return courseId;
	}



	public void setCourseId(Course courseId) {
		this.courseId = courseId;
	}



	@Override
	public String toString() {
		return "Instructor [courseId=" + courseId + "]";
	}








	
	
	

	
	
}
