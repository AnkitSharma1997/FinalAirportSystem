package com.cognizant.dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.cognizant.entity.Plane;
import com.cognizant.helper.SessionHelper;

@Repository("PlaneDAOImpl")
public class PlaneDAOImpl implements PlaneDAO
{

	@Autowired
	SessionHelper sessionHelper;
	
	public SessionHelper getSessionHelper() {
		return sessionHelper;
	}

	public void setSessionHelper(SessionHelper sessionHelper) {
		this.sessionHelper = sessionHelper;
	}

	private static final Logger logger = LoggerFactory.getLogger(PlaneDAOImpl.class);

	@Override
	public List<Plane> getAllPlanes() {
		logger.info("----Retriving List of all Plane in Plane DAO----");
		Session session=sessionHelper.createSession();
		List<Plane> planeList=session.createQuery("from Plane").list();
		return planeList;
	}

	@Override
	public boolean insertPlane(Plane plane) {
		logger.info("----Register Plane in Plane DAO----");
	
		Session session=sessionHelper.createSession();
		Transaction tx=session.beginTransaction(); 
		session.persist(plane);
		tx.commit();
		return true;
	}

	@Override
	public Plane getPlane(int plane1) {		
		logger.info("----Retriving One Plane using Plane Id in Plane DAO----");
		Session session=sessionHelper.createSession();
		Query query=session.createQuery("from Plane o where o.planeId=:planeId");
		query.setInteger("planeId", plane1);
		Plane plane=(Plane)query.uniqueResult();
		return plane;
	}

	@Override
	public boolean updatePlane(Plane plane) {
		logger.info("----Updating Plane in Plane DAO----");
		Session session=sessionHelper.createSession();
		Transaction tx=session.beginTransaction();
		session.merge(plane);
		tx.commit();
		return true;
	}

	@Override
	public List<Number> getAllPlaneId()
	{		
		logger.info("----Retriving List of all Plane Id in Plane DAO----");
		Session session=sessionHelper.createSession();
	    SQLQuery query = session.createSQLQuery("SELECT distinct p.plane_id FROM planes p WHERE p.plane_id Not IN (SELECT hs.plane_id FROM HANGAR_STATUS hs)");
		List<Number> planeIdList = query.list();
		
	
		
		return planeIdList;
	}

}
