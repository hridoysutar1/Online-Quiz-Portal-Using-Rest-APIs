package com.abc.model;

public class Statistics {

	private Long quizNumber;
	private Long questionNumber;
	private Long participantNumber;
	
	
	
	public Long getQuizNumber() {
		return quizNumber;
	}
	public void setQuizNumber(Long quizNumber) {
		this.quizNumber = quizNumber;
	}
	public Long getQuestionNumber() {
		return questionNumber;
	}
	public void setQuestionNumber(Long questionNumber) {
		this.questionNumber = questionNumber;
	}
	public Long getParticipantNumber() {
		return participantNumber;
	}
	public void setParticipantNumber(Long participantNumber) {
		this.participantNumber = participantNumber;
	}
	public Statistics() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Statistics(Long quizNumber, Long questionNumber, Long participantNumber) {
		super();
		this.quizNumber = quizNumber;
		this.questionNumber = questionNumber;
		this.participantNumber = participantNumber;
	}
	@Override
	public String toString() {
		return "Statistics [quizNumber=" + quizNumber + ", questionNumber=" + questionNumber + ", participantNumber="
				+ participantNumber + "]";
	}
	
	
	
}
