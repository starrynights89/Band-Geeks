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

@Component
public class Instructor extends User {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="instructors")
	@SequenceGenerator(name="instructors", sequenceName="instructors_seq", allocationSize=1)
	
	
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="user_id")
	private int id;
	
	
	
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)	
	@JoinColumn(name= "course_id")
	private Course courseId;



	





	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public Course getCourseId() {
		return courseId;
	}



	public void setCourseId(Course courseId) {
		this.courseId = courseId;
	}



	@Override
	public String toString() {
		return "Instructor [id=" + id + ", courseId=" + courseId + "]";
	}






	
	
	

	
	
}
