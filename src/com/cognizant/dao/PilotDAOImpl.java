package com.cognizant.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cognizant.entity.Pilot;
import com.cognizant.helper.SessionHelper;

@Repository("PilotDAOImpl")
public class PilotDAOImpl implements PilotDAO
{

	@Autowired
	SessionHelper sessionHelper;
	
	public SessionHelper getSessionHelper() {
		return sessionHelper;
	}

	public void setSessionHelper(SessionHelper sessionHelper) {
		this.sessionHelper = sessionHelper;
	}

	private static final Logger logger = LoggerFactory.getLogger(PilotDAOImpl.class);

	@Override
	public List<Pilot> getAllPilots() {
		logger.info("----Retriving List of all Pilot in Pilot DAO----");
		Session session=sessionHelper.createSession();
		List<Pilot> pilotList=session.createQuery("from Pilot").list();
		return pilotList;
	}

	@Override
	public boolean insertPilot(Pilot pilot) {
		logger.info("----Register Pilot in Pilot DAO----");
		boolean result=false;
		Session session=sessionHelper.createSession();
		Transaction tx=session.beginTransaction();
		session.persist(pilot);
		result=true;
		tx.commit();
		return result;
	}

	@Override
	public Pilot getPilot(int pilot1) {
		logger.info("----Retriving One Pilot using Pilot Id in Pilot DAO----");
		Session session=sessionHelper.createSession();
		Query query=session.createQuery("from Pilot o where o.pilotId=:pilotId");
		query.setInteger("pilotId", pilot1);
		Pilot pilot=(Pilot)query.uniqueResult();		
		return pilot;
	}

	@Override
	public boolean updatePilot(Pilot pilot) {
		logger.info("----Updating Pilot in Pilot DAO----");
		boolean result=false;
		Session session=sessionHelper.createSession();
		Transaction tx=session.beginTransaction();
		session.merge(pilot);
		result=true;
		tx.commit();
		return result;
	}	
}