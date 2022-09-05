package com.abc.model;

public class CheckAnswer {
	private int qusId;
	private String qusText;
	private String yourAnswer;
	private String correctAnswer;
	private Boolean correct;
	
	
	
	public int getQusId() {
		return qusId;
	}
	public void setQusId(int qusId) {
		this.qusId = qusId;
	}
	public String getQusText() {
		return qusText;
	}
	public void setQusText(String qusText) {
		this.qusText = qusText;
	}
	public String getYourAnswer() {
		return yourAnswer;
	}
	public void setYourAnswer(String yourAnswer) {
		this.yourAnswer = yourAnswer;
	}
	public String getCorrectAnswer() {
		return correctAnswer;
	}
	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}
	public boolean isCorrect() {
		return correct;
	}
	public void setCorrect(boolean correct) {
		this.correct = correct;
	}
	public CheckAnswer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CheckAnswer(int qusId, String qusText, String yourAnswer, String correctAnswer, boolean correct) {
		super();
		this.qusId = qusId;
		this.qusText = qusText;
		this.yourAnswer = yourAnswer;
		this.correctAnswer = correctAnswer;
		this.correct = correct;
	}
	
	
	
	

}
