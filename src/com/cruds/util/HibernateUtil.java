package com.cruds.util;

import org.hibernate.SessionFactory;
import org.hibernate.SessionFactoryObserver;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.boot.registry.internal.StandardServiceRegistryImpl;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


public class HibernateUtil {

	private static final SessionFactory sessionFactory = buildSessionFactory();
	
	private static SessionFactory buildSessionFactory() 
	{
		// configuration settings from hibernate.cfg.xml
	    Configuration configuration = new Configuration().configure(); 
	    
	    StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();
	    serviceRegistryBuilder.applySettings(configuration.getProperties());
	    ServiceRegistry serviceRegistry = serviceRegistryBuilder.build();
	    
	    configuration.setSessionFactoryObserver(new SessionFactoryObserver() {
			
			@Override
			public void sessionFactoryCreated(SessionFactory arg0) {}
			
			@Override
			public void sessionFactoryClosed(SessionFactory arg0) {
				((StandardServiceRegistryImpl) serviceRegistry).destroy();
			}
		});	    
	    
	    return configuration.buildSessionFactory(serviceRegistry);
	}
	
	public static SessionFactory getSessionFactory() {
	    return sessionFactory;
	}
	
	public static void shutdown() {
	    // Close caches and connection pools
	    getSessionFactory().close();
	}
}
