package com.cognizant.dao;

import java.io.Serializable;
import org.hibernate.HibernateException;
import org.hibernate.engine.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AdminIDGenerator implements IdentifierGenerator {

	private static final Logger logger = LoggerFactory.getLogger(AdminIDGenerator.class);
	
	@Override
	public Serializable generate(SessionImplementor arg0, Object arg1)
			throws HibernateException {		
			logger.info("----Unique Id Generation Complete in AdminIDGenerator----");
			return "ADMIN"+AdminStoreId.getId();
	}

}
