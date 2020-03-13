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
	
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)	
	@JoinColumn(name = "assignment_student_id")
	private Student studentId;
	
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)	
	@JoinColumn(name = "assignment_instructor_id")
	private Instructor instructor;
	
	@Column(name = "assignment_type_id")
	private int assignmentTypeId;
	
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)	
	@JoinColumn(name = "assignment_instrument")
	private Instrument instrument;
	
	
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









	public Assignment(int id, Student studentId, Instructor instructorId, int assignmentTypeId, Instrument instrument,
			String grade, Date dateAssigned, Date dateDue) {
		super();
		this.id = id;
		this.studentId = studentId;
		this.instructor = instructor;
		this.assignmentTypeId = assignmentTypeId;
		this.instrument = instrument;
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









	public Student getStudentId() {
		return studentId;
	}









	public void setStudentId(Student studentId) {
		this.studentId = studentId;
	}
















	public Instructor getInstructor() {
		return instructor;
	}









	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}









	public Instrument getInstrument() {
		return instrument;
	}









	public void setInstrument(Instrument instrument) {
		this.instrument = instrument;
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
		result = prime * result + ((instructor == null) ? 0 : instructor.hashCode());
		result = prime * result + ((instrument == null) ? 0 : instrument.hashCode());
		result = prime * result + ((studentId == null) ? 0 : studentId.hashCode());
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
		if (instructor == null) {
			if (other.instructor != null)
				return false;
		} else if (!instructor.equals(other.instructor))
			return false;
		if (instrument == null) {
			if (other.instrument != null)
				return false;
		} else if (!instrument.equals(other.instrument))
			return false;
		if (studentId == null) {
			if (other.studentId != null)
				return false;
		} else if (!studentId.equals(other.studentId))
			return false;
		return true;
	}









	@Override
	public String toString() {
		return "Assignment [id=" + id + ", studentId=" + studentId + ", instructor=" + instructor
				+ ", assignmentTypeId=" + assignmentTypeId + ", instrument=" + instrument + ", grade=" + grade
				+ ", dateAssigned=" + dateAssigned + ", dateDue=" + dateDue + "]";
	}












	
	
	

	

}
