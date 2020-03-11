package com.bandgeeks.utils;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.model.naming.ImplicitNamingStrategyJpaCompliantImpl;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
	private static HibernateUtil hu;
	private Logger log = Logger.getLogger(HibernateUtil.class);
	
	
	private SessionFactory sessionFactory;

	private HibernateUtil()
	{
		super();
	}
	
	public synchronized static HibernateUtil getInstance()
	{
		if(hu==null)
		{
			hu= new HibernateUtil();
		}
		return hu;
	}
	
	public synchronized SessionFactory getSessionFactory()
	{
		if(sessionFactory==null)
		{
			StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder().configure().build();
			Metadata meta = new MetadataSources(standardRegistry)
					.getMetadataBuilder()
					.applyImplicitNamingStrategy(ImplicitNamingStrategyJpaCompliantImpl.INSTANCE)
					.build();
			sessionFactory = meta.getSessionFactoryBuilder()
					.build();
		}
		log.trace(sessionFactory);
		return sessionFactory;
	}
	
	public Session getSession()
	{
		return this.getSessionFactory().openSession();
	}
}
