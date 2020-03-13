package com.bandgeeks.beans;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "assignment")
public class Assignment {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="assignment")
	@SequenceGenerator(name="assignment", sequenceName="assignment_seq", allocationSize=1)
	
	@Column(name = "assignment_id")
	private int id;
	
	@Column(name = "assignment_student_id")
	private int studentId;
	
	@Column(name = "assignment_instructor_id")
	private int instructorId;
	
	@Column(name = "assignment_type_id")
	private int assignmentTypeId;
	
	@Column(name = "assignment_instrument")
	private String instrument;
	
	
	@Column(name = "assignment_grade")
	private String grade;
	
	@Column(name = "date_assigned")
	private Date dateAssigned;
	
	@Column(name = "date_due")
	private Date dateDue;
	
	
	
	

	public Assignment() {
		super();
		// TODO Auto-generated constructor stub
	}





	public Assignment(int id, int studentId, int instructorId, int assignmentTypeId, String grade, Date dateAssigned,
			Date dateDue) {
		super();
		this.id = id;
		this.studentId = studentId;
		this.instructorId = instructorId;
		this.assignmentTypeId = assignmentTypeId;
		this.grade = grade;
		this.dateAssigned = dateAssigned;
		this.dateDue = dateDue;
	}





	public int getId() {
		return id;
	}





	public void setId(int id) {
		this.id = id;
	}





	public String getInstrument() {
		return instrument;
	}





	public void setInstrument(String instrument) {
		this.instrument = instrument;
	}





	public int getStudentId() {
		return studentId;
	}





	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}





	public int getInstructorId() {
		return instructorId;
	}





	public void setInstructorId(int instructorId) {
		this.instructorId = instructorId;
	}





	public int getAssignmentTypeId() {
		return assignmentTypeId;
	}





	public void setAssignmentTypeId(int assignmentTypeId) {
		this.assignmentTypeId = assignmentTypeId;
	}





	public String getGrade() {
		return grade;
	}





	public void setGrade(String grade) {
		this.grade = grade;
	}





	public Date getDateAssigned() {
		return dateAssigned;
	}





	public void setDateAssigned(Date dateAssigned) {
		this.dateAssigned = dateAssigned;
	}





	public Date getDateDue() {
		return dateDue;
	}





	public void setDateDue(Date dateDue) {
		this.dateDue = dateDue;
	}





	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + assignmentTypeId;
		result = prime * result + ((dateAssigned == null) ? 0 : dateAssigned.hashCode());
		result = prime * result + ((dateDue == null) ? 0 : dateDue.hashCode());
		result = prime * result + ((grade == null) ? 0 : grade.hashCode());
		result = prime * result + id;
		result = prime * result + instructorId;
		result = prime * result + studentId;
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
		Assignment other = (Assignment) obj;
		if (assignmentTypeId != other.assignmentTypeId)
			return false;
		if (dateAssigned == null) {
			if (other.dateAssigned != null)
				return false;
		} else if (!dateAssigned.equals(other.dateAssigned))
			return false;
		if (dateDue == null) {
			if (other.dateDue != null)
				return false;
		} else if (!dateDue.equals(other.dateDue))
			return false;
		if (grade == null) {
			if (other.grade != null)
				return false;
		} else if (!grade.equals(other.grade))
			return false;
		if (id != other.id)
			return false;
		if (instructorId != other.instructorId)
			return false;
		if (studentId != other.studentId)
			return false;
		return true;
	}





	@Override
	public String toString() {
		return "Assignment [id=" + id + ", studentId=" + studentId + ", instructorId=" + instructorId
				+ ", assignmentTypeId=" + assignmentTypeId + ", grade=" + grade + ", dateAssigned=" + dateAssigned
				+ ", dateDue=" + dateDue + "]";
	}


	
	
	
	

	

}
