package com.cognizant.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.cognizant.dao.AdminDAO;
import com.cognizant.entity.Admin;
import com.cognizant.entity.Manager;
import com.cognizant.exception.AdminNotFoundException;
import com.cognizant.model.AdminModel;

@Service("AdminServiceImpl")
public class AdminServiceImpl implements AdminService {

	@Autowired
	@Qualifier("AdminDAOImpl")
	private AdminDAO adminDAO;
	
	private static final Logger logger = LoggerFactory.getLogger(AdminServiceImpl.class);
	
	@Override
	public boolean registerAdmin(AdminModel adminModel) {

		logger.info("----Register Admin in Admin Service----");
		Admin admin=new Admin();
		

		
		admin=adminModel.modelToEntity(adminModel);		
		return adminDAO.registerAdmin(admin);
	}

	@Override
	public String getId() {
		logger.info("----Retriving Admin ID from Admin Service----");
		return adminDAO.getId();
	}

	@Override
	public AdminModel getAdminInfo(String adminId) {
		logger.info("----Retriving Admin Information using Admin ID from Admin Service----");		
		Admin admin=adminDAO.getAdminInfo(adminId);
		AdminModel adminModel=new AdminModel();
		
		adminModel=adminModel.entityToModel(admin);
		return adminModel;
	}

	@Override
	public int checkEmailAndContactNo(AdminModel adminModel) {
		logger.info("----Checking Email and Contact Number from Database in Admin Service----");		
		Admin admin=new Admin();
		admin=adminModel.modelToEntity(adminModel);				
		return adminDAO.checkEmailAndContactNo(admin);
	}

	@Override
	public int checkAdminLogin(AdminModel adminModel)
	{
		logger.info("----Checking Admin Login in Admin Service----");
		Admin admin=new Admin();
		admin=adminModel.modelToEntity(adminModel);	
		admin.setAdminId(adminModel.getAdminId());
		int adminExist= adminDAO.checkAdminLogin(admin);
		if(adminExist==3)
		throw new AdminNotFoundException("Admin Not Found Exception");
		else
			return adminDAO.checkAdminLogin(admin);
	}

	@Override
	public List<String> getGender() {
		logger.info("----Retriving Gender for Drop Down in Admin Service----");
		return adminDAO.getGender();
	}
	
	@Override
	public List<Manager> getAllPendingRequests() {
		// TODO Auto-generated method stub
		
		
		logger.info("----Get All Pending Manager Request in Admin Service----");
		return adminDAO.getAllPendingRequests();
	}
	
	@Override
	public boolean approveManagerRequest(String managerId) {
		logger.info("----Approving Manager Request in Admin Service----");
		return adminDAO.approveManagerRequest( managerId);		
	}

	@Override
	public boolean rejectManagerRequest(String managerId) {
		logger.info("----Rejecting Manager Request in Admin Service----");
		return adminDAO.rejectManagerRequest( managerId);
	}

}