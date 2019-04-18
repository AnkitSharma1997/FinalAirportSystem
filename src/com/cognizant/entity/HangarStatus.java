package com.cognizant.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="Hangar_Status")
public class HangarStatus implements Serializable {
	
	@Id @NotNull 
	@Column(name = "hangar_id")
	 private int hangarId;
	 
	@NotNull
	@Column(name = "manager_id")
	 private String managerId;

	@Column(name="plane_id")	
	 private int planeId;

	@NotNull 
	@Column(name ="status")
	 private String status;
	 
    @DateTimeFormat(pattern="mm/dd/yyyy")
	@Column(name="occupancy_from_date")
	 private String occupancyFromDate;
	 
    @DateTimeFormat(pattern="mm/dd/yyyy")
    @Column(name="occupancy_till_date")
	 private String occupancyTillDate;
	 
    @DateTimeFormat(pattern="mm/dd/yyyy")
    @Column(name="available_from_date")
	 private String availableFromDate;
	 
    @DateTimeFormat(pattern="mm/dd/yyyy")
    @Column(name ="available_till_date")
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

}
