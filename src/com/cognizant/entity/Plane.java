package com.cognizant.entity;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name="Planes")

public class Plane implements Serializable
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="PLANE_ID")
	private long planeId;
		
	@NotNull @Size(max=10)
	@Column(name="PLANE_TYPE")
	private String planeType;
	
	@NotNull
	@Column(name="PLANE_CAPACITY")
	private int planeCapacity;

	@OneToOne(cascade=CascadeType.ALL,targetEntity=Owner.class)
	private Owner owner;
	
	public long getPlaneId() {
		return planeId;
	}

	public void setPlaneId(long planeId) {
		this.planeId = planeId;
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

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}
		
}
