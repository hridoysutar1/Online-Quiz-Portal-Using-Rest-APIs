package com.abc.model;

public class PAnswer {
	
	private int qlid;
	private String ans;
	
	
	
	public int getQlid() {
		return qlid;
	}
	public void setQlid(int qlid) {
		this.qlid = qlid;
	}
	public String getAns() {
		return ans;
	}
	public void setAns(String ans) {
		this.ans = ans;
	}
	public PAnswer(int qlid, String ans) {
		super();
		this.qlid = qlid;
		this.ans = ans;
	}
	public PAnswer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
