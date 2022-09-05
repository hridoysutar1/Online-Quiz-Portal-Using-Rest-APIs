package com.abc.model;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ParticipantDetails {
	
	@Id
	private int pId;
	private String pName;
	private String pEmail;
	private String password;
	
	public ParticipantDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public String getpEmail() {
		return pEmail;
	}
	public void setpEmail(String pEmail) {
		this.pEmail = pEmail;
	}
	
	
	
	public ParticipantDetails(int pId, String pName, String pEmail, String password) {
		super();
		this.pId = pId;
		this.pName = pName;
		this.pEmail = pEmail;
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public ParticipantDetails(int pId, String pName, String pEmail) {
		super();
		this.pId = pId;
		this.pName = pName;
		this.pEmail = pEmail;
	}
	

}
