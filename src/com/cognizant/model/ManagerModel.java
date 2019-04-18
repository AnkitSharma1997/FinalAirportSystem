package com.cognizant.model;

import com.cognizant.entity.Manager;

public class ManagerModel {

	private String managerId;
	
	private String managerFirstName;

	private String managerLastName;
	
	private int managerAge;
	
	private String managerGender;
	
	private String managerDob;
	
	private long managerContactNo;

	private long managerAltContactNo;
	
	private String managerEmailId;
	
	private String managerPassword;
	
	private String managerStatus;

	public String getManagerId() {
		return managerId;
	}

	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}

	public String getManagerFirstName() {
		return managerFirstName;
	}

	public void setManagerFirstName(String managerFirstName) {
		this.managerFirstName = managerFirstName;
	}

	public String getManagerLastName() {
		return managerLastName;
	}

	public void setManagerLastName(String managerLastName) {
		this.managerLastName = managerLastName;
	}

	public int getManagerAge() {
		return managerAge;
	}

	public void setManagerAge(int managerAge) {
		this.managerAge = managerAge;
	}

	public String getManagerGender() {
		return managerGender;
	}

	public void setManagerGender(String managerGender) {
		this.managerGender = managerGender;
	}

	public String getManagerDob() {
		return managerDob;
	}

	public void setManagerDob(String managerDob) {
		this.managerDob = managerDob;
	}

	public long getManagerContactNo() {
		return managerContactNo;
	}

	public void setManagerContactNo(long managerContactNo) {
		this.managerContactNo = managerContactNo;
	}

	public long getManagerAltContactNo() {
		return managerAltContactNo;
	}

	public void setManagerAltContactNo(long managerAltContactNo) {
		this.managerAltContactNo = managerAltContactNo;
	}

	public String getManagerEmailId() {
		return managerEmailId;
	}

	public void setManagerEmailId(String managerEmailId) {
		this.managerEmailId = managerEmailId;
	}

	public String getManagerPassword() {
		return managerPassword;
	}

	public void setManagerPassword(String managerPassword) {
		this.managerPassword = managerPassword;
	}

	public String getManagerStatus() {
		return managerStatus;
	}

	public void setManagerStatus(String managerStatus) {
		this.managerStatus = managerStatus;
	}

	@Override
	public String toString() {
		return "Manager [managerId=" + managerId + ", managerFirstName=" + managerFirstName + ", managerLastName="
				+ managerLastName + ", managerAge=" + managerAge + ", managerGender=" + managerGender + ", managerDob="
				+ managerDob + ", managerContactNo=" + managerContactNo + ", managerAltContactNo=" + managerAltContactNo
				+ ", managerEmailId=" + managerEmailId + ", managerPassword=" + managerPassword + ", managerStatus="
				+ managerStatus + "]";
	}

    public Manager modelToEntity(ManagerModel managerModel){
    	
    	Manager manager=new Manager();
    	
    	manager.setManagerFirstName(managerModel.getManagerFirstName());
   	 	manager.setManagerLastName(managerModel.getManagerLastName());
   	 	manager.setManagerAge(managerModel.getManagerAge());
   	 	manager.setManagerGender(managerModel.getManagerGender());
   	 	manager.setManagerContactNo(managerModel.getManagerContactNo());
   	 	manager.setManagerAltContactNo(managerModel.getManagerAltContactNo());
   	 	manager.setManagerDob(managerModel.getManagerDob());
   	 	manager.setManagerEmailId(managerModel.getManagerEmailId());
   	 	manager.setManagerPassword(managerModel.getManagerPassword());
   	 	
   	 	return manager;
    }
    
    public ManagerModel entityToModel(Manager manager){
    	
    	ManagerModel managerModel=new ManagerModel();
    	
    	managerModel.setManagerId(manager.getManagerId());
    	managerModel.setManagerFirstName(manager.getManagerFirstName());
    	managerModel.setManagerLastName(manager.getManagerLastName());
    	managerModel.setManagerAge(manager.getManagerAge());
    	managerModel.setManagerGender(manager.getManagerGender());
    	managerModel.setManagerDob(manager.getManagerDob());
    	managerModel.setManagerContactNo(manager.getManagerContactNo());
    	managerModel.setManagerAltContactNo(manager.getManagerAltContactNo());
    	managerModel.setManagerEmailId(manager.getManagerEmailId());
    	managerModel.setManagerPassword(manager.getManagerPassword());	    	
		
		return managerModel;
    }
	 
}
