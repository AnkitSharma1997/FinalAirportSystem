package com.cognizant.model;

import org.springframework.stereotype.Component;

import com.cognizant.entity.Admin;

public class AdminModel {

	    private String adminId;
		
	    private String adminFirstName;
		
	    private String adminLastName;
		
	    private int adminAge;
		
	    private String adminGender;
		
	    private String adminDob;
		
	    private long adminContactNo;
		
	    private long adminAltContactNo;
		
	    private String adminEmailId;
		
	    private String adminPassword;
	    		
	    public String getAdminId() {
			return adminId;
		}
		public void setAdminId(String adminId) {
			this.adminId = adminId;
		}
		public String getAdminFirstName() {
			return adminFirstName;
		}
		public void setAdminFirstName(String adminFirstName) {
			this.adminFirstName = adminFirstName;
		}
		public String getAdminLastName() {
			return adminLastName;
		}
		public void setAdminLastName(String adminLastName) {
			this.adminLastName = adminLastName;
		}
		public int getAdminAge() {
			return adminAge;
		}
		public void setAdminAge(int adminAge) {
			this.adminAge = adminAge;
		}
		public String getAdminGender() {
			return adminGender;
		}
		public void setAdminGender(String adminGender) {
			this.adminGender = adminGender;
		}
		public String getAdminDob() {
			return adminDob;
		}
		public void setAdminDob(String adminDob) {
			this.adminDob = adminDob;
		}
		public long getAdminContactNo() {
			return adminContactNo;
		}
		public void setAdminContactNo(long adminContactNo) {
			this.adminContactNo = adminContactNo;
		}
		public long getAdminAltContactNo() {
			return adminAltContactNo;
		}
		public void setAdminAltContactNo(long adminAltContactNo) {
			this.adminAltContactNo = adminAltContactNo;
		}
		public String getAdminEmailId() {
			return adminEmailId;
		}
		public void setAdminEmailId(String adminEmailId) {
			this.adminEmailId = adminEmailId;
		}
		public String getAdminPassword() {
			return adminPassword;
		}
		public void setAdminPassword(String adminPassword) {
			this.adminPassword = adminPassword;
		}
		@Override
		public String toString() {
			return "AdminModel [adminId=" + adminId + ", adminFirstName=" + adminFirstName + ", adminLastName="
					+ adminLastName + ", adminAge=" + adminAge + ", adminGender=" + adminGender + ", adminDob="
					+ adminDob + ", adminContactNo=" + adminContactNo + ", adminAltContactNo=" + adminAltContactNo
					+ ", adminEmailId=" + adminEmailId + ", adminPassword=" + adminPassword + "]";
		}
		
	    public Admin modelToEntity(AdminModel adminModel){
	    	
	    	Admin admin=new Admin();
	    	
			admin.setAdminFirstName(adminModel.getAdminFirstName());
			admin.setAdminLastName(adminModel.getAdminLastName());
			admin.setAdminAge(adminModel.getAdminAge());
			admin.setAdminGender(adminModel.getAdminGender());
			admin.setAdminDob(adminModel.getAdminDob());
			admin.setAdminContactNo(adminModel.getAdminContactNo());
			admin.setAdminAltContactNo(adminModel.getAdminAltContactNo());
			admin.setAdminEmailId(adminModel.getAdminEmailId());
			admin.setAdminPassword(adminModel.getAdminPassword());	    	
			
			return admin;
	    }

	    public AdminModel entityToModel(Admin admin){
	    	
	    	AdminModel adminModel=new AdminModel();
	    	
	    	adminModel.setAdminId(admin.getAdminId());
	    	adminModel.setAdminFirstName(admin.getAdminFirstName());
	    	adminModel.setAdminLastName(admin.getAdminLastName());
	    	adminModel.setAdminAge(admin.getAdminAge());
	    	adminModel.setAdminGender(admin.getAdminGender());
	    	adminModel.setAdminDob(admin.getAdminDob());
	    	adminModel.setAdminContactNo(admin.getAdminContactNo());
	    	adminModel.setAdminAltContactNo(admin.getAdminAltContactNo());
	    	adminModel.setAdminEmailId(admin.getAdminEmailId());
	    	adminModel.setAdminPassword(admin.getAdminPassword());	    	
			
			return adminModel;
	    }
}
