package com.cognizant.service;

import java.util.List;
import com.cognizant.model.ManagerModel;

public interface ManagerService 
{
	public boolean managerRegister(ManagerModel managerModel);
	public int checkEmailAndContactNo(ManagerModel managerModel); 
	public ManagerModel getManagerInfo(String managerId);
	
	public String getId(); 
	public int checkCredentilas(ManagerModel managerModel);	
	public List<String> getGender();
}