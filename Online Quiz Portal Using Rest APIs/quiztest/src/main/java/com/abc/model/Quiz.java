package com.abc.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Quiz {
	
	@Id
	private long quizId;
	@Column
	private String quizName;
	
	@OneToMany()
	//@JoinColumn(name="questionlist" )
	private List<Question> questionList;

	public long getQuizId() {
		return quizId;
	}

	public void setQuizId(long quizId) {
		this.quizId = quizId;
	}

	public String getQuizName() {
		return quizName;
	}

	public void setQuizName(String quizName) {
		this.quizName = quizName;
	}

	public List<Question> getQuestionList() {
		return questionList;
	}

	public void setQuestionList(List<Question> questionList) {
		this.questionList = questionList;
	}

	public Quiz(long quizId, String quizName, List<Question> questionList) {
		super();
		this.quizId = quizId;
		this.quizName = quizName;
		this.questionList = questionList;
	}

	public Quiz() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Quiz [quizId=" + quizId + ", quizName=" + quizName + ", questionList=" + questionList + "]";
	}
	
	
	

}
