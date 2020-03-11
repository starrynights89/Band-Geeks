package com.bandgeeks.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "inventory")
@Inheritance(strategy = InheritanceType.JOINED)

@Component
public class Inventory {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "inventory")
	@SequenceGenerator(name = "inventory", sequenceName = "inventory_seq", allocationSize = 1)
	@Column(name = "inventory_id")
	private Integer inventoryId;

	//constructos
	public Inventory() {
		super();
	}

	public Inventory(Integer inventoryId) {
		super();
		this.inventoryId = inventoryId;
	}

	//get/set
	public Integer getInventoryId() {
		return inventoryId;
	}

	public void setInventoryId(Integer inventoryId) {
		this.inventoryId = inventoryId;
	}

	//hashCode
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((inventoryId == null) ? 0 : inventoryId.hashCode());
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
		Inventory other = (Inventory) obj;
		if (inventoryId == null) {
			if (other.inventoryId != null)
				return false;
		} else if (!inventoryId.equals(other.inventoryId))
			return false;
		return true;
	}

	//toString
	@Override
	public String toString() {
		return "Inventory [inventoryId=" + inventoryId + "]";
	}
}
