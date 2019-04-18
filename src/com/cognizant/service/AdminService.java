package com.cognizant.service;

import java.util.List;

import com.cognizant.entity.Manager;
import com.cognizant.model.AdminModel;

public interface AdminService {
	
	public boolean registerAdmin(AdminModel adminModel);
	public int checkEmailAndContactNo(AdminModel adminModel); 
	public String getId(); 
	public AdminModel getAdminInfo(String adminId);
	public int checkAdminLogin(AdminModel adminModel);
	public List<String> getGender();

	public List<Manager> getAllPendingRequests();
	public boolean approveManagerRequest(String managerId);
	public boolean rejectManagerRequest(String managerId);
}
