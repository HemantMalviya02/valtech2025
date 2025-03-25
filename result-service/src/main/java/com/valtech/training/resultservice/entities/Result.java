package com.valtech.training.resultservice.entities;

import java.util.List;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

public class Result {
	
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "result_seq")
	@SequenceGenerator(name = "result_seq", sequenceName = "result_seq", allocationSize = 1)
	private long id;
	
	private int score;
	private List<Long> quizId;
	private Double percentage;
	
	public Result () {}

	public Result(int score, Double percentage) {
		this.score = score;
		this.percentage = percentage;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public List<Long> getQuizId() {
		return quizId;
	}

	public void setQuizId(List<Long> quizId) {
		this.quizId = quizId;
	}

	public Double getPercentage() {
		return percentage;
	}

	public void setPercentage(Double percentage) {
		this.percentage = percentage;
	}
	
}
