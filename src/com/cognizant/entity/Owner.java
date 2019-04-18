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

import org.springmodules.validation.bean.conf.loader.annotation.handler.Email;
import org.springmodules.validation.bean.conf.loader.annotation.handler.NotEmpty;

@Entity
@Table(name="Owner")
public class Owner implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="OWNER_ID")
	private long ownerId;
	
	@Size(max=100)
	@Column(name="OWNER_FIRST_NAME")
	private String ownerFirstName;

	@Size(max=100)
	@Column(name="OWNER_LAST_NAME")
	private String ownerLastName;
	
	@NotNull
	@Column(name="OWNER_CONTACT_NO")
	private long ownerContactNo;

	@NotEmpty @Email
	@Column(name="OWNER_EMAIL")
	private String ownerEmail;

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

}
