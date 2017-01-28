package com.utility;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UtilityClass {

	public static SessionFactory getSessionFactory()
	{
		SessionFactory factory=new Configuration().configure().buildSessionFactory();				
		return factory;
		
	}
	
	
}
