package com.cognizant.model;

import com.cognizant.entity.Hangar;
import com.cognizant.entity.Owner;
import com.cognizant.entity.Plane;

public class PlaneModel 
{
	private long planeId;
	
	private long ownerId;
	
	private String ownerFirstName;

	private String ownerLastName;
	
	private long ownerContactNo;

	private String ownerEmail;
	
	private String planeType;
	
	private int planeCapacity;

	public long getPlaneId() {
		return planeId;
	}

	public void setPlaneId(long planeId) {
		this.planeId = planeId;
	}

	public long getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(long ownerId) {
		this.ownerId = ownerId;
	}

	public String getOwnerFirstName() {
		return ownerFirstName;
	}

	public void setOwnerFirstName(String ownerFirstName) {
		this.ownerFirstName = ownerFirstName;
	}

	public String getOwnerLastName() {
		return ownerLastName;
	}

	public void setOwnerLastName(String ownerLastName) {
		this.ownerLastName = ownerLastName;
	}

	public long getOwnerContactNo() {
		return ownerContactNo;
	}

	public void setOwnerContactNo(long ownerContactNo) {
		this.ownerContactNo = ownerContactNo;
	}

	public String getOwnerEmail() {
		return ownerEmail;
	}

	public void setOwnerEmail(String ownerEmail) {
		this.ownerEmail = ownerEmail;
	}

	public String getPlaneType() {
		return planeType;
	}

	public void setPlaneType(String planeType) {
		this.planeType = planeType;
	}

	public int getPlaneCapacity() {
		return planeCapacity;
	}

	public void setPlaneCapacity(int planeCapacity) {
		this.planeCapacity = planeCapacity;
	}

	@Override
	public String toString() {
		return "PlaneModel [planeId=" + planeId + ", ownerId=" + ownerId + ", ownerFirstName=" + ownerFirstName
				+ ", ownerLastName=" + ownerLastName + ", ownerContactNo=" + ownerContactNo + ", ownerEmail="
				+ ownerEmail + ", planeType=" + planeType + ", planeCapacity=" + planeCapacity + "]";
	}
		
}
