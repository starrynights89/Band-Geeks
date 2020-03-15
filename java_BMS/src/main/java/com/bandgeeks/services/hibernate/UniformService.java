package com.bandgeeks.services.hibernate;

import java.util.Set;

import com.bandgeeks.beans.Uniform;

public interface UniformService {
	
	public Integer createUniform(Uniform uniform);
	public Uniform getUniform(Uniform uniform);
	public Uniform getUniformById(Integer id);
	public Set<Uniform> getUniforms();
	public void updateUniform(Uniform uniform);
	public void deleteUniform(Uniform uniform);
	

}
