package com.bandgeeks.data.hibernate;

import java.util.Set;

import com.bandgeeks.beans.Instrument;

public interface InstrumentDAO {

	public Integer createInstrument(Instrument instrument);
	public Instrument getInstrument(Instrument instrument);
	public Instrument getInstrumentById(Integer id);
	public Set<Instrument> getInstruments();
	public void updateInstrument(Instrument instrument);
	public void deleteInstrument(Instrument instrument);
}