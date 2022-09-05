package com.abc.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Question {
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long questionId;
	@Column
	private String questionText;
	@Column
	private String questionAnswer;
	
	

	public Long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}

	public String getQuestionText() {
		return questionText;
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	public String getQuestionAnswer() {
		return questionAnswer;
	}

	public void setQuestionAnswer(String questionAnswer) {
		this.questionAnswer = questionAnswer;
	}

	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Question(Long questionId, String questionText, String questionAnswer) {
		super();
		this.questionId = questionId;
		this.questionText = questionText;
		this.questionAnswer = questionAnswer;
	}

	@Override
	public String toString() {
		return "Question [questionId=" + questionId + ", questionText=" + questionText + ", questionAnswer="
				+ questionAnswer + "]";
	}
	
}
