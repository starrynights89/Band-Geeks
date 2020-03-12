package com.bandgeeks.data.hibernate;

import java.util.Set;

import com.bandgeeks.beans.Course;

public interface CourseDAO {
	
	public Integer createCourse(Course course);
	public Course getCourse(Course course);
	public Course getCourseById(Integer id);
	public Set<Course> getCourses();
	public void updateCourse(Course course);
	public void deleteCourse(Course course);
	

}
