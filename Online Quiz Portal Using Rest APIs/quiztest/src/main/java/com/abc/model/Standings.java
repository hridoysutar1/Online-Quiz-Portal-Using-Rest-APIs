package com.abc.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Standings {
	
	public Standings(int participationNumber, int pId, String pName, int qzId, int score) {
		super();
		this.participationNumber = participationNumber;
		this.pId = pId;
		this.pName = pName;
		this.qzId = qzId;
		this.score = score;
	}
	public int getParticipationNumber() {
		return participationNumber;
	}
	public void setParticipationNumber(int participationNumber) {
		this.participationNumber = participationNumber;
	}
	
	
	@Id
	private int participationNumber;
	private int pId;
	private String pName;
	private int qzId;
	private int score;
	
	
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
	public int getQzId() {
		return qzId;
	}
	public void setQzId(int qzId) {
		this.qzId = qzId;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public Standings() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Standings(int pId, String pName, int qzId, int score) {
		super();
		this.pId = pId;
		this.pName = pName;
		this.qzId = qzId;
		this.score = score;
	}
	
	
	

}
