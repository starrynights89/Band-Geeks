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


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((courseId == null) ? 0 : courseId.hashCode());
		result = prime * result + ((gradeLevelId == null) ? 0 : gradeLevelId.hashCode());
		result = prime * result + ((instrumentTypeId == null) ? 0 : instrumentTypeId.hashCode());
		result = prime * result + ((uniformTypeId == null) ? 0 : uniformTypeId.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (courseId == null) {
			if (other.courseId != null)
				return false;
		} else if (!courseId.equals(other.courseId))
			return false;
		if (gradeLevelId == null) {
			if (other.gradeLevelId != null)
				return false;
		} else if (!gradeLevelId.equals(other.gradeLevelId))
			return false;
		if (instrumentTypeId == null) {
			if (other.instrumentTypeId != null)
				return false;
		} else if (!instrumentTypeId.equals(other.instrumentTypeId))
			return false;
		if (uniformTypeId == null) {
			if (other.uniformTypeId != null)
				return false;
		} else if (!uniformTypeId.equals(other.uniformTypeId))
			return false;
		return true;
	}



	
	
	

	
	
}
