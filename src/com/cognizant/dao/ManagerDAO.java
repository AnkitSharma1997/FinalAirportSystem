package com.cognizant.dao;

import java.util.List;
import com.cognizant.entity.Manager;

public interface ManagerDAO {

	public boolean managerRegister(Manager manager);	
	public int checkEmailAndContactNo(Manager manager); 
	public String getId(); 
	public Manager getManagerInfo(String managerId);

	public Manager managerCredentials(Manager manager);
	public void generateManagerId();
	public List<String> getGender();

}
