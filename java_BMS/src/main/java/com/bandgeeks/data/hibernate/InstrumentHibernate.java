package com.bandgeeks.data.hibernate;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.bandgeeks.beans.Instrument;
import com.bandgeeks.beans.Student;
import com.bandgeeks.services.hibernate.RequestServiceHibernate;
import com.bandgeeks.utils.HibernateUtil;
import com.bandgeeks.utils.LogUtil;

@Repository
public class InstrumentHibernate implements InstrumentDAO {

	private HibernateUtil hu = HibernateUtil.getInstance();
	
	@Override
	public Integer createInstrument(Instrument instrument) {
		Session s = hu.getSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			s.save(instrument);
			tx.commit();
		} catch(Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			LogUtil.logException(e, InstrumentHibernate.class);
		} finally {
			s.close();
		}
		return instrument.getId();
		
	}

	@Override
	public Instrument getInstrument(Instrument instrument) {
		Session s = hu.getSession();
		instrument = s.get(Instrument.class, instrument.getId());
		s.close();
		return instrument;
	}

	@Override
	public Instrument getInstrumentById(Integer id) {
		Session s = hu.getSession();
		Instrument instrument = s.get(Instrument.class, id);
		s.close();
		return instrument;
	}

	@Override
	public Set<Instrument> getInstruments() {
		Session s = hu.getSession();
		String query = "FROM Instrument";
		Query<Instrument> q = s.createQuery(query, Instrument.class);
		List<Instrument> instrumentList = q.getResultList();
		Set<Instrument> instrumentSet = new HashSet<Instrument>();
		instrumentSet.addAll(instrumentList);
		s.close();
		return instrumentSet;
	}

	@Override
	public void updateInstrument(Instrument instrument) {
		Session s = hu.getSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			s.update(instrument);
			tx.commit();
		} catch(Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			LogUtil.logException(e, InstrumentHibernate.class);
		} finally {
			s.close();
		}
	}

	@Override
	public void deleteInstrument(Instrument instrument) {
		Session s = hu.getSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			s.delete(instrument);
			tx.commit();
		} catch(Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			LogUtil.logException(e, InstrumentHibernate.class);
		} finally {
			s.close();
		}
	}
	@Override
	public Instrument getInstrumentByName(String name) {
		// Get instrument by name
		Session s = hu.getSession();
		Query<Instrument> q = s.createQuery("FROM Instrument where instrumentName =:name", Instrument.class);
		q.setParameter("name", name);
		Instrument a = q.uniqueResult();
		s.close();
		return a;
	}

}
