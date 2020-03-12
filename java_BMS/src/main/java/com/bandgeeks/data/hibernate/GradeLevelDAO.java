package com.bandgeeks.data.hibernate;

import java.util.Set;

import com.bandgeeks.beans.GradeLevel;

public interface GradeLevelDAO { 
	
	public Integer createGradeLevel(GradeLevel gradeLevel);
	public GradeLevel getGradeLevel(GradeLevel gradeLevel);
	public GradeLevel getGradeLevelById(Integer id);
	public Set<GradeLevel> getGradeLevels();
	public void updateGradeLevel(GradeLevel gradeLevel);
	public void deleteGradeLevel(GradeLevel gradeLevel);
	

}
