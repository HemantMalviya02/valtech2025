package com.valtech.training.quizservice.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;

@Entity
public class QuestionResult {

	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "quizRes_seq")
	@SequenceGenerator(name = "quizRes_seq", sequenceName = "quizRes", allocationSize = 1)
	private long id;
	
	private String userAnswer;
	private String result;
	private long questionId;
	
	
	@ManyToOne(targetEntity = Quiz.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="quiz_id", referencedColumnName = "id")
	private Quiz quiz;


	public QuestionResult() {}
	
	public QuestionResult(String userAnswer, String result, long questionId) {
		this.userAnswer = userAnswer;
		this.result = result;
		this.questionId = questionId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserAnswer() {
		return userAnswer;
	}

	public void setUserAnswer(String userAnswer) {
		this.userAnswer = userAnswer;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(long questionId) {
		this.questionId = questionId;
	}

	public Quiz getQuiz() {
		return quiz;
	}

	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}
	
	
}
