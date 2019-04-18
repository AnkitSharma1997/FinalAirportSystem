package com.cognizant.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="Pilots")

public class Pilot implements Serializable
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="PILOT_ID")
	private int pilotId;
	
	@NotNull
	@Column(name="PILOT_LICENSE_NUMBER")
	private String pilotLicenseNumber;
	
	@Size(max=100)
	@Column(name="PILOT_ADDRESS_LINE_1")
	private String pilotAddressLine1;

	@Size(max=100)
	@Column(name="PILOT_ADDRESS_LINE_2")
	private String pilotAddressLine2;
	
	@Size(max=50)
	@Column(name="PILOT_CITY")
	private String pilotCity;
	
	@Size(max=50)
	@Column(name="PILOT_STATE")
	private String pilotState;
	
	@NotNull
	@Column(name="PILOT_ZIP_CODE")
	private long pilotZipCode;
	
	@NotNull
	@Column(name="PILOT_SSN")
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
	
}
