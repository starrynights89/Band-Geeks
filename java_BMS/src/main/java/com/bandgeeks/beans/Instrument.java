package com.bandgeeks.beans;

public class Instrument extends Inventory {
	private String instrumentName;
	private Integer instrumentId;

	//constructos
	public Instrument() {
		super();
		
	}
	public Instrument(Integer instrumentId) {
		super();
		this.instrumentId = instrumentId;
	}
	public Instrument(String instrumentName, Integer instrumentId) {
		super();
		this.instrumentName = instrumentName;
		this.instrumentId = instrumentId;
	}
	//get/set
	public String getInstrumentName() {
		return instrumentName;
	}
	public void setInstrumentName(String instrumentName) {
		this.instrumentName = instrumentName;
	}
	public Integer getInstrumentId() {
		return instrumentId;
	}
	public void setInstrumentId(Integer instrumentId) {
		this.instrumentId = instrumentId;
	}

	//hashCode
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((instrumentId == null) ? 0 : instrumentId.hashCode());
		result = prime * result + ((instrumentName == null) ? 0 : instrumentName.hashCode());
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
		Instrument other = (Instrument) obj;
		if (instrumentId == null) {
			if (other.instrumentId != null)
				return false;
		} else if (!instrumentId.equals(other.instrumentId))
			return false;
		if (instrumentName == null) {
			if (other.instrumentName != null)
				return false;
		} else if (!instrumentName.equals(other.instrumentName))
			return false;
		
		return true;
	}
	//toString
	@Override
	public String toString() {
		return "Instrument [instrumentName=" + instrumentName + ", instrumentId=" + instrumentId + ", inventoryId="
				 + "]";
	}
	
	
}

