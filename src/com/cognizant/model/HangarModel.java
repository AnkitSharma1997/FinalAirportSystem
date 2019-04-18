package com.cognizant.model;

import com.cognizant.entity.Hangar;

public class HangarModel 
{
	private int hangarId;
	
	private String managerId;
	
	private String managerAddressLine1;

	private String managerAddressLine2;
	
	private String hangarCity;
	
	private String hangarState;
	
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

	@Override
	public String toString() {
		return "HangarModel [hangarId=" + hangarId + ", managerId=" + managerId + ", managerAddressLine1="
				+ managerAddressLine1 + ", managerAddressLine2=" + managerAddressLine2 + ", hangarCity=" + hangarCity
				+ ", hangarState=" + hangarState + ", hangarZipCode=" + hangarZipCode + "]";
	}
	
    public Hangar modelToEntity(HangarModel hangarModel){
    	
    	Hangar hangar=new Hangar();
    	
		hangar.setManagerId(hangarModel.getManagerId());
		hangar.setManagerAddressLine1(hangarModel.getManagerAddressLine1());
		hangar.setManagerAddressLine2(hangarModel.getManagerAddressLine2());
		hangar.setHangarCity(hangarModel.getHangarCity());
		hangar.setHangarState(hangarModel.getHangarState());
		hangar.setHangarZipCode(hangarModel.getHangarZipCode());
   	 	
   	 	return hangar;
    }
    
    public HangarModel entityToModel(Hangar hangar){
    	
    	HangarModel hangarModel=new HangarModel();
    	
    	hangarModel.setHangarId(hangar.getHangarId());
    	hangarModel.setManagerId(hangar.getManagerId());
    	hangarModel.setManagerAddressLine1(hangar.getManagerAddressLine1());
    	hangarModel.setManagerAddressLine2(hangar.getManagerAddressLine2());
    	hangarModel.setHangarCity(hangar.getHangarCity());
    	hangarModel.setHangarState(hangar.getHangarState());
    	hangarModel.setHangarZipCode(hangar.getHangarZipCode());
    	
  	 	return hangarModel;
    }
}
