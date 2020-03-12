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

public class Student extends User {
	
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="student_instrument_type_id")
	private InstrumentType instrumentTypeId;
	
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="student_grade_level_id")
	private GradeLevel gradeLevelId;
	
	
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="student_course_id")
	private Course courseId;
	
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="student_uniform_type_id")
	private UniformType uniformTypeId;





	public InstrumentType getInstrumentTypeId() {
		return instrumentTypeId;
	}


	public void setInstrumentTypeId(InstrumentType instrumentTypeId) {
		this.instrumentTypeId = instrumentTypeId;
	}


	public GradeLevel getGradeLevelId() {
		return gradeLevelId;
	}


	public void setGradeLevelId(GradeLevel gradeLevelId) {
		this.gradeLevelId = gradeLevelId;
	}


	public Course getCourseId() {
		return courseId;
	}


	public void setCourseId(Course courseId) {
		this.courseId = courseId;
	}


	
	public UniformType getUniformTypeId() {
		return uniformTypeId;
	}


	public void setUniformTypeId(UniformType uniformTypeId) {
		this.uniformTypeId = uniformTypeId;
	}


	@Override
	public String toString() {
		return "Student [instrumentTypeId=" + instrumentTypeId + ", gradeLevelId=" + gradeLevelId + ", courseId="
				+ courseId + ", uniformTypeId=" + uniformTypeId + "]";
	}



	
	
	

	
	
}
