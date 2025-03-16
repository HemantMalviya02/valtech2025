package com.valtech.training.quizservice.entities;

import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Quiz {
	
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "quiz_seq")
	@SequenceGenerator(name = "quiz_seq", sequenceName = "quiz_seq", allocationSize = 1)
	private long id;
	
	private String topic;
	private int noOfQuestions;
	
	@ElementCollection
	@CollectionTable(name = "quiz_table", joinColumns = @JoinColumn(name = "quiz_id"))
	private List<Long> questionId;

	public Quiz(String topic, int noOfQuestions) {
		this.topic = topic;
		this.noOfQuestions = noOfQuestions;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public int getNoOfQuestions() {
		return noOfQuestions;
	}

	public void setNoOfQuestions(int noOfQuestions) {
		this.noOfQuestions = noOfQuestions;
	}

	public List<Long> getQuestionId() {
		return questionId;
	}

	public void setQuestionId(List<Long> questionId) {
		this.questionId = questionId;
	}
	
	
}
