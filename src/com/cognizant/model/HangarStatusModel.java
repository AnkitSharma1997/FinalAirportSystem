package com.cognizant.model;

import java.io.Serializable;

import com.cognizant.entity.Hangar;
import com.cognizant.entity.HangarStatus;

public class HangarStatusModel implements Serializable {
	
	 private int hangarId;
	 
	 private String managerId;
	 
	 private int planeId;

	 private String status;
	 
	 private String occupancyFromDate;
	 
	 private String occupancyTillDate;
	 
	 private String availableFromDate;
	 
	 private String availableTillDate;

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

	public int getPlaneId() {
		return planeId;
	}

	public void setPlaneId(int planeId) {
		this.planeId = planeId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getOccupancyFromDate() {
		return occupancyFromDate;
	}

	public void setOccupancyFromDate(String occupancyFromDate) {
		this.occupancyFromDate = occupancyFromDate;
	}

	public String getOccupancyTillDate() {
		return occupancyTillDate;
	}

	public void setOccupancyTillDate(String occupancyTillDate) {
		this.occupancyTillDate = occupancyTillDate;
	}

	public String getAvailableFromDate() {
		return availableFromDate;
	}

	public void setAvailableFromDate(String availableFromDate) {
		this.availableFromDate = availableFromDate;
	}

	public String getAvailableTillDate() {
		return availableTillDate;
	}

	public void setAvailableTillDate(String availableTillDate) {
		this.availableTillDate = availableTillDate;
	}

	@Override
	public String toString() {
		return "HangarStatus [hangarId=" + hangarId + ", managerId=" + managerId + ", planeId=" + planeId + ", status="
				+ status + ", occupancyFromDate=" + occupancyFromDate + ", occupancyTillDate=" + occupancyTillDate
				+ ", availableFromDate=" + availableFromDate + ", availableTillDate=" + availableTillDate + "]";
	}
	  
    public HangarStatus modelToEntity(HangarStatusModel hangarStatusModel){
    	
    	HangarStatus hangarStatus=new HangarStatus();
    	
		hangarStatus.setHangarId(hangarStatusModel.getHangarId());
		hangarStatus.setManagerId(hangarStatusModel.getManagerId());
		hangarStatus.setPlaneId(hangarStatusModel.getPlaneId());		
		hangarStatus.setOccupancyFromDate(hangarStatusModel.getOccupancyFromDate());
		hangarStatus.setOccupancyTillDate(hangarStatusModel.getOccupancyTillDate());
		hangarStatus.setAvailableFromDate(hangarStatusModel.getAvailableFromDate());
		hangarStatus.setAvailableFromDate(hangarStatusModel.getAvailableFromDate());
		
   	 	return hangarStatus;
    }
    
    public HangarStatusModel entityToModel(HangarStatus hangarStatus){
    	
    	HangarStatusModel hangarStatusModel=new HangarStatusModel();
    	
		hangarStatusModel.setHangarId(hangarStatus.getHangarId());
		hangarStatusModel.setManagerId(hangarStatus.getManagerId());
		hangarStatusModel.setPlaneId(hangarStatus.getPlaneId());
		hangarStatusModel.setStatus(hangarStatus.getStatus());
		hangarStatusModel.setAvailableFromDate(hangarStatus.getAvailableFromDate());
		hangarStatusModel.setAvailableTillDate(hangarStatus.getAvailableTillDate());
		hangarStatusModel.setOccupancyFromDate(hangarStatus.getOccupancyFromDate());
		hangarStatusModel.setOccupancyTillDate(hangarStatus.getOccupancyTillDate());
    	
  	 	return hangarStatusModel;
    }

}
