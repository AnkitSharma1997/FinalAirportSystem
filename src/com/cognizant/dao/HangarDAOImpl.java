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
import com.cognizant.entity.Hangar;
import com.cognizant.entity.HangarStatus;
import com.cognizant.helper.SessionHelper;

@Repository("HangarDAOImpl")
public class HangarDAOImpl implements HangarDAO
{

	@Autowired
	SessionHelper sessionHelper;
	
	public SessionHelper getSessionHelper() {
		return sessionHelper;
	}

	public void setSessionHelper(SessionHelper sessionHelper) {
		this.sessionHelper = sessionHelper;
	}

	private static final Logger logger = LoggerFactory.getLogger(HangarDAOImpl.class);

	@Override
	public List<Hangar> getAllHangars() {
		logger.info("----Retriving List of all Hangars in DAO----");
		Session session=sessionHelper.createSession();
		List<Hangar> hangarList=session.createQuery("from Hangar").list();
		return hangarList;
	}

	@Override
	public boolean insertHangar(Hangar hangar) {
		logger.info("----Register Hangar in DAO----");
		Session session=sessionHelper.createSession();
		Transaction tx=session.beginTransaction();
		session.persist(hangar);
		tx.commit();
		return true;
	}

	@Override
	public Hangar getHangar(int hangar1) {
		logger.info("----Retriving One Hangar using Hangar Id in DAO----");
		Session session=sessionHelper.createSession();
		Query query=session.createQuery("from Hangar o where o.hangarId=:hangarId");
		query.setInteger("hangarId", hangar1);
		Hangar hangar=(Hangar)query.uniqueResult();		
		return hangar;
	}

	@Override
	public boolean updateHangar(Hangar hangar) {
		logger.info("----Updating Hangars in DAO----");
		Session session=sessionHelper.createSession();
		Transaction tx=session.beginTransaction();
		session.merge(hangar);
		tx.commit();
		return true;
	}

	@Override
	public List<HangarStatus> getAllHangarStatus() {
		logger.info("----Retriving List of all Hangar Status in DAO----");
		Session session=sessionHelper.createSession();
		List<HangarStatus> hangarStatusList=session.createQuery("from HangarStatus").list();
		return hangarStatusList;
	}

	@Override
	public boolean allocatePlane(HangarStatus hangarStatus) {
		logger.info("----Allocating Plane to Hangar in DAO----");
		boolean result=false;
		Session session=sessionHelper.createSession();
		Transaction transaction = session.beginTransaction();
		session.merge(hangarStatus);		
		result=true;
		transaction.commit();
		return result;
	}

	@Override
	public HangarStatus getHangerIdManagerId() {
		// TODO Auto-generated method stub
		logger.info("----Retriving Hangar Id and Manager Id in DAO----");
		Number hangarId=0;
		String managerId="";
		
		int hangarId1=0;
		Session session=sessionHelper.createSession();
		SQLQuery query1 = session.createSQLQuery("select hangar_id from hangar");
		SQLQuery query2 = session.createSQLQuery("select manager_id from hangar");
		
		List<Number> hangarIdValue = query1.list();
		List<String> managerIdValue = query2.list();
		hangarId = hangarIdValue.get(hangarIdValue.size() - 1);
		managerId = managerIdValue.get(managerIdValue.size() -1);

		

		hangarId1=hangarId.intValue();
		HangarStatus hangarStatus = new  HangarStatus();
		
		hangarStatus.setHangarId(hangarId1);
		hangarStatus.setManagerId(managerId);
		
		return hangarStatus;
	}

	@Override
	public boolean persistHangarStatus(HangarStatus hangarStatus) {
		logger.info("----Register Hangar Status in DAO----");
		Session session=sessionHelper.createSession();
		Transaction tx=session.beginTransaction();
		session.persist(hangarStatus);
		tx.commit();
		return true;
	}
	
	@Override
	public HangarStatus getHangarStatus(int hangar1) {
		
		logger.info("----Retriving One Hangar Status using Hangar Id in DAO----");
		Session session=sessionHelper.createSession();
		Query query=session.createQuery("from HangarStatus o where o.hangarId=:hangarId");
		query.setInteger("hangarId", hangar1);

		HangarStatus hangarStatus=(HangarStatus)query.uniqueResult();
		
		return hangarStatus;

	}
	
	@Override
	public List<String> getStatus() {
		logger.info("----Retriving Status for Drop Down in DAO----");
		Session session=sessionHelper.createSession();
		Query query=session.createSQLQuery("select status_option from status");
		List<String> statusList=query.list();
			return statusList;
	}
	
	@Override
	public boolean updateHangarStatus(HangarStatus hangarStatus) {
		logger.info("----Updating Hangar Status in DAO----");
		boolean result=false;
		hangarStatus.setPlaneId(0);		
		Session session=sessionHelper.createSession();
		Transaction tx=session.beginTransaction();
		session.merge(hangarStatus);
		result=true;
		tx.commit();
		return result;
	}

	@Override
	public String getStatusConditionDAO(int hangarId) {
		logger.info("----Retriving Hangar Status From Database in DAO----");		
		Session session=sessionHelper.createSession();
		String status ="";
		Query query = session.createQuery("from HangarStatus o where o.hangarId=:hangarId");
		query.setInteger("hangarId", hangarId);
		HangarStatus hangarStatus=(HangarStatus)query.uniqueResult();
		status = hangarStatus.getStatus();
		return status;
	}
}
