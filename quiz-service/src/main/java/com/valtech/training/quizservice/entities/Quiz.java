package com.valtech.training.quizservice.entities;

import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Quiz {
	
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "quiz_seq")
	@SequenceGenerator(name = "quiz_seq", sequenceName = "quiz_seq", allocationSize = 1)
	private long id;
	
	private String username;
	private String topic;
	private int noOfQuestions;
	
//	@ElementCollection     //list cant be stored directly, so it will create a new table and store in it along with id
//	@CollectionTable(name = "quiz_table", joinColumns = @JoinColumn(name = "quiz_id"))
//	private List<Long> questionId;
	
	@OneToMany()
	@JoinColumn(name="questionResult_id", referencedColumnName = "id")
	private List<QuestionResult> questionRes;
	
	public Quiz() {}

	public Quiz(String topic, int noOfQuestions, String username) {
		this.topic = topic;
		this.noOfQuestions = noOfQuestions;
		this.username = username;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<QuestionResult> getQuestionRes() {
		return questionRes;
	}

	public void setQuestionRes(List<QuestionResult> questionRes) {
		this.questionRes = questionRes;
	}	
	
	
}
