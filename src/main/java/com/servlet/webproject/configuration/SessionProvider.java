package com.servlet.webproject.configuration;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionProvider {

	public static Session getSession() {
		Session session = null;
		
		Configuration config = new Configuration();
		config.configure("/com/servlet/webproject/configuration/hibernate-configuration.xml");
		SessionFactory sessionFactory = config.buildSessionFactory();
		session = sessionFactory.openSession();
		
		return session;
	}
}
