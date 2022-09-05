package com.abc.model;

public class QuizToParticipant {
	private int id;
	private String name;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public QuizToParticipant() {
		super();
		// TODO Auto-generated constructor stub
	}
	public QuizToParticipant(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	

}
