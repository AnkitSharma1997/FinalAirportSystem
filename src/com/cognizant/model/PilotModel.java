package com.cognizant.model;

import com.cognizant.entity.Pilot;

public class PilotModel 
{
	private int pilotId;
	
	private String pilotLicenseNumber;
	
	private String pilotAddressLine1;

	private String pilotAddressLine2;
	
	private String pilotCity;
	
	private String pilotState;
	
	private long pilotZipCode;
	
	private long pilotSsn;

	public int getPilotId() {
		return pilotId;
	}

	public void setPilotId(int pilotId) {
		this.pilotId = pilotId;
	}

	public String getPilotLicenseNumber() {
		return pilotLicenseNumber;
	}

	public void setPilotLicenseNumber(String pilotLicenseNumber) {
		this.pilotLicenseNumber = pilotLicenseNumber;
	}

	public String getPilotAddressLine1() {
		return pilotAddressLine1;
	}

	public void setPilotAddressLine1(String pilotAddressLine1) {
		this.pilotAddressLine1 = pilotAddressLine1;
	}

	public String getPilotAddressLine2() {
		return pilotAddressLine2;
	}

	public void setPilotAddressLine2(String pilotAddressLine2) {
		this.pilotAddressLine2 = pilotAddressLine2;
	}

	public String getPilotCity() {
		return pilotCity;
	}

	public void setPilotCity(String pilotCity) {
		this.pilotCity = pilotCity;
	}

	public String getPilotState() {
		return pilotState;
	}

	public void setPilotState(String pilotState) {
		this.pilotState = pilotState;
	}

	public long getPilotZipCode() {
		return pilotZipCode;
	}

	public void setPilotZipCode(long pilotZipCode) {
		this.pilotZipCode = pilotZipCode;
	}

	public long getPilotSsn() {
		return pilotSsn;
	}

	public void setPilotSsn(long pilotSsn) {
		this.pilotSsn = pilotSsn;
	}

	@Override
	public String toString() {
		return "PilotModel [pilotId=" + pilotId + ", pilotLicenseNumber=" + pilotLicenseNumber + ", pilotAddressLine1="
				+ pilotAddressLine1 + ", pilotAddressLine2=" + pilotAddressLine2 + ", pilotCity=" + pilotCity
				+ ", pilotState=" + pilotState + ", pilotZipCode=" + pilotZipCode + ", pilotSsn=" + pilotSsn + "]";
	}

    public Pilot modelToEntity(PilotModel pilotModel){
    	
    	Pilot pilot=new Pilot();
    	
		pilot.setPilotLicenseNumber(pilotModel.getPilotLicenseNumber());
		pilot.setPilotAddressLine1(pilotModel.getPilotAddressLine1());
		pilot.setPilotAddressLine2(pilotModel.getPilotAddressLine2());
		pilot.setPilotCity(pilotModel.getPilotCity());
		pilot.setPilotState(pilotModel.getPilotState());
		pilot.setPilotZipCode(pilotModel.getPilotZipCode());
		pilot.setPilotSsn(pilotModel.getPilotSsn());
   	 	
   	 	return pilot;
    }
    
    public PilotModel entityToModel(Pilot pilot){
    	
    	PilotModel pilotModel=new PilotModel();
    	
    	pilotModel.setPilotId(pilot.getPilotId());
    	pilotModel.setPilotLicenseNumber(pilot.getPilotLicenseNumber());
    	pilotModel.setPilotAddressLine1(pilot.getPilotAddressLine1());
    	pilotModel.setPilotAddressLine2(pilot.getPilotAddressLine2());
    	pilotModel.setPilotCity(pilot.getPilotCity());
    	pilotModel.setPilotState(pilot.getPilotState());
    	pilotModel.setPilotZipCode(pilot.getPilotZipCode());
    	pilotModel.setPilotSsn(pilot.getPilotSsn());
    	
  	 	return pilotModel;
    }

}
