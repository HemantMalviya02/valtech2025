package com.valtech.training.quizresultservice.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class QuizResult {

	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "result_seq")
	@SequenceGenerator(name = "result_seq",sequenceName = "result_seq",allocationSize = 1)
	private long id;
	private long quizId;
	private int score;
	private double percentage;
	
	public QuizResult() {}
	
	public QuizResult(long quizId) {
		this.quizId = quizId;
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public long getQuizId() {
		return quizId;
	}
	
	public void setQuizId(long quizId) {
		this.quizId = quizId;
	}
	
	public int getScore() {
		return score;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
	public double getPercentage() {
		return percentage;
	}
	
	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}
	
	
}
