package com.cognizant.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.cognizant.dao.ManagerDAO;
import com.cognizant.entity.Manager;
import com.cognizant.exception.ManagerNotFoundException;
import com.cognizant.model.ManagerModel;

@Service("ManagerServiceImpl")
public class ManagerServiceImpl  implements ManagerService {

	@Autowired
	@Qualifier("ManagerDAOImpl")
	private ManagerDAO managerDAO;
	
	private static final Logger logger = LoggerFactory.getLogger(ManagerServiceImpl.class);
	
	@Override
	public boolean managerRegister(ManagerModel managerModel){

		logger.info("----Register Manager in Manager Service----");
		Manager manager = new Manager();
		 
	//	 manager.setManagerId(managerModel.getManagerId());
		manager=managerModel.modelToEntity(managerModel);	
   	 	manager.setManagerStatus("Pending");
		return managerDAO.managerRegister(manager);
	}
	
	@Override
	public String getId() {
		logger.info("----Retriving Manager ID from Manager Service----");
		return managerDAO.getId();
	}

	@Override
	public ManagerModel getManagerInfo(String managerId) {	
		logger.info("----Retriving Manager Information using Manager ID from Manager Service----");		
		Manager manager=managerDAO.getManagerInfo(managerId);
		ManagerModel managerModel=new ManagerModel();		
		managerModel=managerModel.entityToModel(manager);
		return managerModel;
	}

	@Override
	public int checkEmailAndContactNo(ManagerModel managerModel) {
		logger.info("----Checking Email and Contact Number from Database in Manager Service----");		
		Manager manager=new Manager();		
		return managerDAO.checkEmailAndContactNo(manager);
	}

	@Override
	public int checkCredentilas(ManagerModel managerModel) {		
		logger.info("----Checking Manager Credentilas in Manager Service----");
		Manager manager = new Manager();
		
		manager=managerModel.modelToEntity(managerModel);			 
		manager.setManagerId(managerModel.getManagerId());
		
		
		Manager manager1=managerDAO.managerCredentials(manager);
		
		if(manager1!=null)
		{
		if(manager1.getManagerStatus().equals("Approved")){
			logger.info("----Manager Status Approved, You can Login now----");
			return 1;
		}
		
		if(manager1.getManagerStatus().equals("Pending")){
			logger.info("----Manager Status Pending, Please wait before Login----");
			return 2;
		}
		
		if(manager1.getManagerStatus().equals("Rejected")){
			logger.info("----Manager Status Rejected,Try After Sometime----");
			return 3;
		}			
		}
		
		throw new ManagerNotFoundException("Manager Not Found Exception");
	}

	@Override
	public List<String> getGender() {
		logger.info("----Retriving Gender for Drop Down in Manager Service----");
		return managerDAO.getGender();
	}
}
