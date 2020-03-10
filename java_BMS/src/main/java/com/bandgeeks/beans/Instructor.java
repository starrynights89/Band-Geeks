package com.bandgeeks.beans;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
	
	
	@Column (name = "instructor_id")
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="instructor_id")
	private int id;
	
	
	
	@Column (name = "instructor_course_id")
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="course_id")
	private int courseId;



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public int getCourseId() {
		return courseId;
	}



	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}



	@Override
	public String toString() {
		return "Instructor [id=" + id + ", courseId=" + courseId + "]";
	}



	
	
	

	
	
}
