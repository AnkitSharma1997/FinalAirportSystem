package com.cognizant.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="Hangar")

public class Hangar 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="HANGAR_ID")
	private int hangarId;
	
    @NotNull
	@Column(name="MANAGER_ID")
	private String managerId;
	
    @Size(max=100)
	@Column(name="MANAGER_ADDRESS_LINE_1")
	private String managerAddressLine1;

	@Column(name="MANAGER_ADDRESS_LINE_2")
	private String managerAddressLine2;
	
    @Size(max=50)
	@Column(name="HANGAR_CITY")
	private String hangarCity;
	
    @Size(max=50)
	@Column(name="HANGAR_STATE")
	private String hangarState;
	
	@NotNull
	@Column(name="HANGAR_ZIP_CODE")
	private long hangarZipCode;

	public int getHangarId() {
		return hangarId;
	}

	public void setHangarId(int hangarId) {
		this.hangarId = hangarId;
	}

	public String getManagerId() {
		return managerId;
	}

	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}

	public String getManagerAddressLine1() {
		return managerAddressLine1;
	}

	public void setManagerAddressLine1(String managerAddressLine1) {
		this.managerAddressLine1 = managerAddressLine1;
	}

	public String getManagerAddressLine2() {
		return managerAddressLine2;
	}

	public void setManagerAddressLine2(String managerAddressLine2) {
		this.managerAddressLine2 = managerAddressLine2;
	}

	public String getHangarCity() {
		return hangarCity;
	}

	public void setHangarCity(String hangarCity) {
		this.hangarCity = hangarCity;
	}

	public String getHangarState() {
		return hangarState;
	}

	public void setHangarState(String hangarState) {
		this.hangarState = hangarState;
	}

	public long getHangarZipCode() {
		return hangarZipCode;
	}

	public void setHangarZipCode(long hangarZipCode) {
		this.hangarZipCode = hangarZipCode;
	}
		
}
