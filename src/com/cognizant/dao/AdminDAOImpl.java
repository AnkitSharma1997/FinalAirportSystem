package com.cognizant.dao;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.cognizant.entity.Admin;
import com.cognizant.entity.Manager;
import com.cognizant.helper.SessionHelper;

@Repository("AdminDAOImpl")
public class AdminDAOImpl implements AdminDAO{
	
	@Autowired
	SessionHelper sessionHelper;
	
	static String id;
	
	public SessionHelper getSessionHelper() {
		return sessionHelper;
	}

	public void setSessionHelper(SessionHelper sessionHelper) {
		this.sessionHelper = sessionHelper;
	}

	private static final Logger logger = LoggerFactory.getLogger(AdminDAOImpl.class);
	
	@Override
	public boolean registerAdmin(Admin admin) {

		logger.info("----Register Admin in Admin DAO----");
		Session session=sessionHelper.createSession();
		generateAdminId();
		Transaction tx=session.beginTransaction();
		tx.begin();
		session.persist(admin);
		tx.commit();
		id=admin.getAdminId();
	
		return true;
	}
	
	@Override
	public String getId(){
		logger.info("----Retriving Admin ID from Admin DAO----");
		return id;
	}

	@Override
	public Admin getAdminInfo(String adminId) {
		logger.info("----Retriving Admin Information using Admin ID from Admin DAO----");
		Session session=sessionHelper.createSession();
		Admin admin=(Admin)session.get(Admin.class,adminId);		
		return admin;
	}
	
	@Override
	public int checkEmailAndContactNo(Admin admin) {
		
		logger.info("----Checking Email and Contact Number from Database in Admin DAO----");
		Session session=sessionHelper.createSession();
		int dataExists = 0;
		
		Query query=session.createQuery("select o from Admin o where o.adminEmailId=:adminEmailId and o.adminContactNo=:adminContactNo");
		query.setParameter("adminEmailId", admin.getAdminEmailId());
		query.setParameter("adminContactNo", admin.getAdminContactNo());
		List<Admin> adminList=query.list();

		String str1 =" from Admin as o where o.adminEmailId=?";
		Query query1 = session.createQuery(str1);
		query1.setParameter(0,admin.getAdminEmailId());
		List list1 = query1.list();
		
		String str2 =" from Admin as o where o.adminContactNo=?";
		Query query2 = session.createQuery(str2);
		query2.setParameter(0,admin.getAdminContactNo());
		List list2 = query2.list();
		
		if ((adminList != null) && (adminList.size() > 0)) {
			logger.info("----Both Email Id and Contact Number already exist----");
			dataExists= 3;   //both exists
		}

		if (!(list1.isEmpty())) {
			logger.info("----Email Id already exist----");
			dataExists= 1; //email exists
		}

		if (!(list2.isEmpty())) {
			logger.info("----Contact Number already exist----");
			dataExists= 2; //contact no exists
		}
		
		return dataExists;              
   }


	@Override
	public int checkAdminLogin(Admin admin) {

		logger.info("----Checking Admin Login in Admin DAO----");
		Session session=sessionHelper.createSession();
		int adminInfo=3;

		Query query=session.createQuery("select o from Admin o where o.adminId=:adminId and o.adminPassword=:adminPassword");
		query.setParameter("adminId", admin.getAdminId());
		query.setParameter("adminPassword", admin.getAdminPassword());
		List<Admin> adminList=query.list();

		Query query1=session.createQuery("select o from Admin o where o.adminId=:adminId");
		query1.setParameter("adminId", admin.getAdminId());
		List<Admin> adminList1=query1.list();
		
		Query query2=session.createQuery("select o from Admin o where o.adminPassword=:adminPassword");
		query2.setParameter("adminPassword", admin.getAdminPassword());
		List<Admin> adminList2=query2.list();
		
		if ((adminList != null) && (adminList.size() > 0)) {
			logger.info("----Both Admin Id and Password exists----");
			adminInfo= 4;   //both exists
		}
		if ((adminList1.isEmpty())) {
			logger.info("----Admin Id does not exist----");
			adminInfo= 1;//id not exists
		}

		if ((adminList2.isEmpty())) {
			logger.info("----Password does not exist----");
			adminInfo= 2;//password doesnot exists
		}
		
		if ( ((adminList1.isEmpty()) && ( (adminList2.isEmpty())) )) {
			logger.info("----Both Admin Id and Password does not exist----");
			adminInfo= 3;//both doesnot exists
		}		
		
		return adminInfo;
	}
	@Override
	public void generateAdminId() {		
		logger.info("----Generating Admin Id using Sequence in Admin DAO----");
		Session session=sessionHelper.createSession();
		Query query=session.createSQLQuery("select ADMINIDSEQ.nextval FROM DUAL");
		Long key=((BigDecimal)query.uniqueResult()).longValue();
	
		AdminStoreId.addId(key.intValue());
	}

	@Override
	public List<String> getGender() 
	{
		logger.info("----Retriving Gender for Drop Down in Admin DAO----");
		Session session=sessionHelper.createSession();
		Query query=session.createSQLQuery("select gender_option from gender");
		List<String> genderList=query.list();			
		return genderList;
	}
	
	@Override
	public List<Manager> getAllPendingRequests() {
		// TODO Auto-generated method stub
		
		logger.info("----Get All Pending Manager Request in Admin DAO----");
		Session session=sessionHelper.createSession();
		
		
		
		Query query=session.createQuery("from Manager o where o.managerStatus='Pending'");
	
		
		List<Manager> managerRequests=query.list();
		return managerRequests;
	}
	
	@Override
	public boolean approveManagerRequest(String managerId) {
		// TODO Auto-generated method stub
		logger.info("----Approving Manager Request in Admin DAO----");
		Session session=sessionHelper.createSession();
		Transaction transaction=session.beginTransaction();
		transaction.begin();
		
		Query query =session.createQuery("update Manager o set o.managerStatus=:status"
				+ " where o.managerId=:managerId");
		
		
		
		query.setParameter("status", "Approved");
		query.setParameter("managerId", managerId);
		int approveStatus=query.executeUpdate();
		transaction.commit();
		
		Manager manager1=(Manager)session.get(Manager.class,managerId);

	
		if(approveStatus>0)
		{
			
			return true;
		}
		else
		{
			return false;	
		}
	}

	@Override
	public boolean rejectManagerRequest(String managerId) {
		// TODO Auto-generated method stub
		
		logger.info("----Rejecting Manager Request in Admin DAO----");
		Session session=sessionHelper.createSession();
		Transaction transaction=session.beginTransaction();
		transaction.begin();
		Query query =session.createQuery("update Manager a set a.managerStatus=:status"
				+ " where  a.managerId=:managerId");
		
	
		
		query.setParameter("status", "Rejected");
		
		query.setParameter("managerId", managerId);
		int rejectStatus=query.executeUpdate();
		transaction.commit();
		Manager manager1=(Manager)session.get(Manager.class,managerId);
		
		
		
		if(rejectStatus>0)
		{			
			
			return true;
		}
		else {return false;}
	}

}
