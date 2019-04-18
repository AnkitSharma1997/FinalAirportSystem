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
@Table(name="Manager")
	public class Manager implements Serializable {
		@Id 
	    @GenericGenerator(name = "MANAGERIDSEQ",strategy = "com.cognizant.dao.ManagerIDGenerator")
	    @GeneratedValue(generator = "MANAGERIDSEQ")
		@Column(name="Manager_id")
		private String managerId;

		@Size(max=50)
		@Column(name="Manager_first_name")
		private String managerFirstName;

		@Size(max=50)
		@Column(name="Manager_last_name")
		private String managerLastName;

		@NotNull 
		@Column(name="Manager_age")
		private int managerAge;

		@NotNull 
		@Column(name="Manager_gender")
		private String managerGender;

	    @DateTimeFormat(pattern="mm/dd/yyyy")
	    @NotNull @Past
		@Column(name="Manager_dob")
		private String managerDob;
	    
	    @NotNull
		@Column(name="Manager_contact_no")
		private long managerContactNo;
	
		@Column(name="Manager_alt_contact_no")
		private long managerAltContactNo;
		
		@NotEmpty @Email
		@Column(name="Manager_email_id")
		private String managerEmailId;
		
		@NotNull
		@Column(name="Manager_password")
		private String managerPassword;
		
		@Column(name="Manager_Status")
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
}
