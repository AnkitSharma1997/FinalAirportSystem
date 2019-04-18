package com.cognizant.dao;

import java.util.List;
import com.cognizant.entity.Admin;
import com.cognizant.entity.Manager;

public interface AdminDAO {
	
	boolean registerAdmin(Admin admin);
	public int checkEmailAndContactNo(Admin admin); 
	public String getId(); 
	public Admin getAdminInfo(String adminId);
	public int checkAdminLogin(Admin admin);
	public void generateAdminId();
	public List<String> getGender();

	public List<Manager> getAllPendingRequests();
	public boolean approveManagerRequest(String managerId);
	public boolean rejectManagerRequest(String managerId);
}
