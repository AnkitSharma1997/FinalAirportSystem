package com.cognizant.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;
import org.springmodules.validation.bean.conf.loader.annotation.handler.Email;
import org.springmodules.validation.bean.conf.loader.annotation.handler.NotEmpty;

@Entity
@Table(name="Admin")
	public class Admin implements Serializable{
		@Id 
	    @GenericGenerator(name = "ADMINIDSEQ",strategy = "com.cognizant.dao.AdminIDGenerator")
	    @GeneratedValue(generator = "ADMINIDSEQ")
		@Column(name="Admin_id")
		private String adminId;

		@Size(max=50)
		@Column(name="Admin_first_name")
		private String adminFirstName;

		@Size(max=50)
		@Column(name="Admin_last_name")
		private String adminLastName;

		@NotNull 
		@Column(name="Admin_age")
		private int adminAge;

		@NotNull 
		@Column(name="Admin_gender")
		private String adminGender;

	    @DateTimeFormat(pattern="mm/dd/yyyy")
	    @NotNull @Past
		@Column(name="Admin_dob")
		private String adminDob;
	    
	    @NotNull
		@Column(name="Admin_contact_no")
		private long adminContactNo;
	
		@Column(name="Admin_alt_contact_no")
		private long adminAltContactNo;
		
		@NotEmpty @Email
		@Column(name="Admin_email_id")
		private String adminEmailId;
		
		@NotNull
		@Column(name="Admin_password")
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
		
}
