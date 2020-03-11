package com.bandgeeks.beans;

public class Uniform extends Inventory{

	private Integer uniformId;
	private String uniformName;
	
	//constructores
	public Uniform() {
		super();
	
	}
	public Uniform(Integer uniformId) {
		super();
		this.uniformId = uniformId;
	}
	public Uniform(Integer uniformId, String uniformName) {
		super();
		this.uniformId = uniformId;
		this.uniformName = uniformName;
	}
	//get/set
	public Integer getUniformId() {
		return uniformId;
	}
	public void setUniformId(Integer uniformId) {
		this.uniformId = uniformId;
	}
	//hashCode
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((uniformId == null) ? 0 : uniformId.hashCode());
		result = prime * result + ((uniformName == null) ? 0 : uniformName.hashCode());
		return result;
	}
	//equals
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Uniform other = (Uniform) obj;
		if (uniformId == null) {
			if (other.uniformId != null)
				return false;
		} else if (!uniformId.equals(other.uniformId))
			return false;
		if (uniformName == null) {
			if (other.uniformName != null)
				return false;
		} else if (!uniformName.equals(other.uniformName))
			return false;
		return true;
	}
	//toString
	@Override
	public String toString() {
		return "Uniform [uniformId=" + uniformId + ", uniformName=" + uniformName + "]";
	}
}
