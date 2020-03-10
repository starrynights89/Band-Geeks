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
@Table(name="students")
@PrimaryKeyJoinColumn(name="student_id")

@Component
public class Student extends User {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="students")
	@SequenceGenerator(name="students", sequenceName="students_seq", allocationSize=1)
	
	
	@Column (name = "student_id")
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="user_id")
	private int id;
	
	@Column (name = "student_instrument_id")
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="instrument_id")
	private int instrumentId;
	
	@Column (name = "student_grade_level_id")
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="grade_level_id")
	private int gradeLevelId;
	
	
	@Column (name = "student_course_id")
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="course_id")
	private int courseId;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getInstrumentId() {
		return instrumentId;
	}


	public void setInstrumentId(int instrumentId) {
		this.instrumentId = instrumentId;
	}


	public int getGradeLevelId() {
		return gradeLevelId;
	}


	public void setGradeLevelId(int gradeLevelId) {
		this.gradeLevelId = gradeLevelId;
	}


	public int getCourseId() {
		return courseId;
	}


	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}


	@Override
	public String toString() {
		return "Student [id=" + id + ", instrumentId=" + instrumentId + ", gradeLevelId=" + gradeLevelId + ", courseId="
				+ courseId + "]";
	}
	
	
	

	
	
}
