package com.cognizant.dao;

import java.math.BigDecimal;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.cognizant.entity.Manager;
import com.cognizant.exception.ManagerNotFoundException;
import com.cognizant.helper.SessionHelper;

@Repository("ManagerDAOImpl")
public class ManagerDAOImpl implements ManagerDAO {

	@Autowired
	SessionHelper sessionHelper;
	
	static String id;

	public SessionHelper getSessionHelper() {
		return sessionHelper;
	}

	public void setSessionHelper(SessionHelper sessionHelper) {
		this.sessionHelper = sessionHelper;
	}

	private static final Logger logger = LoggerFactory.getLogger(ManagerDAOImpl.class);

	@Override
	public boolean managerRegister(Manager manager){		
		logger.info("----Register Manager in Manager DAO----");
		Session session=sessionHelper.createSession();
		generateManagerId();
		Transaction tx = session.beginTransaction();	
		tx.begin();
		session.persist(manager);
		tx.commit();
		id=manager.getManagerId();
		System.out.println("#############"+id);
		return true;
	}

	@Override
	public String getId(){
		logger.info("----Retriving Manager ID from Manager DAO----");
		return id;
	}

	@Override
	public Manager getManagerInfo(String managerId) {
		logger.info("----Retriving Manager Information using Manager ID from Manager DAO----");
		Session session=sessionHelper.createSession();
		Manager manager=(Manager)session.get(Manager.class,managerId);		
		return manager;
	}
	
	@Override
	public int checkEmailAndContactNo(Manager manager) {
		logger.info("----Checking Email and Contact Number from Database in Manager DAO----");
		Session session=sessionHelper.createSession();
		int dataExists = 0;
		
		Query query=session.createQuery("select o from Manager o where o.managerEmailId=:managerEmailId and o.managerContactNo=:managerContactNo");
		query.setParameter("managerEmailId", manager.getManagerEmailId());
		query.setParameter("managerContactNo", manager.getManagerContactNo());
		List<Manager> managerList=query.list();

		String str1 =" from Manager as o where o.managerEmailId=?";
		Query query1 = session.createQuery(str1);
		query1.setParameter(0,manager.getManagerEmailId());
		List list1 = query1.list();
		
		String str2 =" from Manager as o where o.managerContactNo=?";
		Query query2 = session.createQuery(str2);
		query2.setParameter(0,manager.getManagerContactNo());
		List list2 = query2.list();
		
		if ((managerList != null) && (managerList.size() > 0)) {
			logger.info("----Both Email Id and Contact Number already exist----");
			dataExists= 3;   //both exists
		}

		if (!(list1.isEmpty())) {
			logger.info("----Email Id already exist----");
			dataExists= 1;//email exists
		}

		if (!(list2.isEmpty())) {
			logger.info("----Contact Number already exist----");
			dataExists= 2;//contact no exists
		}
		
		return dataExists;              
   }

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public Manager managerCredentials(Manager manager) {
		logger.info("----Checking Manager Login in Manager DAO----");
		Session session=sessionFactory.openSession();
		Manager manager1=(Manager)session.get(Manager.class,manager.getManagerId());
		
		
		
		if(manager1 != null)
		{
			if(manager1.getManagerPassword().equals(manager.getManagerPassword()))
			{
				logger.info("----Both Manager Id and Password exists----");
				return manager1;
			}
			else{logger.info("----Manager Password not Found in Manager DAO----");
			
			}
		}
		
		else{
			throw new ManagerNotFoundException("Manager Not Found Exception");
			//logger.info("----Manager Id not Found in Manager DAO----");
		
		}
		
		
		session.close();
		return null;
	}
	
	@Override
	public void generateManagerId() {
		logger.info("----Generating Manager Id using Sequence in Manager DAO----");
		Session session=sessionHelper.createSession();
		Query query=session.createSQLQuery("select MANAGERIDSEQ.nextval FROM DUAL");
		Long key=((BigDecimal)query.uniqueResult()).longValue();
		System.out.println("Id generated:"+key);
		ManagerStoreId.addId(key.intValue());
	}
	
	@Override
	public List<String> getGender() 
	{
		logger.info("----Retriving Gender for Drop Down in Manager DAO----");
		Session session=sessionHelper.createSession();
		Query query=session.createSQLQuery("select gender_option from gender");
		List<String> genderList=query.list();			
			return genderList;
	}
}
