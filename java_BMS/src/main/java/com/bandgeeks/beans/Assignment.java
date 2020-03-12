package com.bandgeeks.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "assignment")
public class Assignment {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="assignment")
	@SequenceGenerator(name="assignment", sequenceName="assignment_seq", allocationSize=1)
	
	@Column(name = "student_id")
	private int id;
	
	@Column(name = "student_grade_level_id")
	private GradeLevel gradeLevel;
	
	@Column(name = "student_course_id")
	private Course course;
	
	
	
	

	

}
