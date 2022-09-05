package com.abc.model;

public class QuestionToParticipant {
	private Long id;
	private String qusText;
	
	
	public Long getId() {
		return id;
	}
	
	public String getQusText() {
		return qusText;
	}
	public void setQusText(String qusText) {
		this.qusText = qusText;
	}
	public QuestionToParticipant() {
		super();
		// TODO Auto-generated constructor stub
	}
	public QuestionToParticipant(Long id, String qusText) {
		super();
		this.id = id;
		this.qusText = qusText;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
	

}
