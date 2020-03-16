package com.bandgeeks.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="uniforms")
@PrimaryKeyJoinColumn(name="uniforms_inventory_id")



public class Uniform extends Inventory{

	@Column(name = "uniforms_name")
	private String uniformName;
	
	//constructores
	public Uniform() {
		super();
	
	}
	public Uniform(int id) {
		super(id);
	}
	public Uniform(int id, String uniformName) {
		super(id);
		this.uniformName = uniformName;
	}
	@Override
	public String toString() {
		return "Uniform [uniformName=" + uniformName + "]";
	}
	/**
	 * @return the uniformName
	 */
	public String getUniformName() {
		return uniformName;
	}
	/**
	 * @param uniformName the uniformName to set
	 */
	public void setUniformName(String uniformName) {
		this.uniformName = uniformName;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((uniformName == null) ? 0 : uniformName.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Uniform other = (Uniform) obj;
		if (uniformName == null) {
			if (other.uniformName != null)
				return false;
		} else if (!uniformName.equals(other.uniformName))
			return false;
		return true;
	}


}
