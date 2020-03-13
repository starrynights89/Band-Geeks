package com.bandgeeks.data.hibernate;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.bandgeeks.beans.UniformType;
import com.bandgeeks.utils.HibernateUtil;

@Repository
public class UniformTypeHibernate implements UniformTypeDAO{

	private HibernateUtil hu = HibernateUtil.getInstance();
	
	@Override
	public UniformType getUniformType(UniformType uniformType) {
		Session s = hu.getSession();
		uniformType = s.get(UniformType .class, uniformType.getId());
		s.close();
		return uniformType;
		
	}

}
