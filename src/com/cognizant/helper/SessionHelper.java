package com.cognizant.helper;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SessionHelper {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private static Session session=null;
	
	@PostConstruct
	public Session createSession(){
		if(session==null)
		{
		session=sessionFactory.openSession();
		}
		return session;
	}
	
	@PreDestroy
	public void closeSession(){
		session.close();
	}	
}
