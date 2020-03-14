package com.bandgeeks.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="uniforms")
@PrimaryKeyJoinColumn(name="uniforms_inventory_id")



public class Uniform extends Inventory implements IDisplayInv{

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
	//get/set
	public String getUniformName() {
		return this.uniformName;
	}
	public void setUniformName(String value) {
		this.uniformName = value;
	}
	@Override
	public String toString() {
		return "Uniform [uniformName=" + uniformName + "]";
	}
	@Override
	public int getProductId() {
		return getId();
	}
	@Override
	public String getProductName() {
		return uniformName;
	}


}
