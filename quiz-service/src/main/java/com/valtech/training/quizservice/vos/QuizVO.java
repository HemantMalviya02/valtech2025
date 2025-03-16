package com.valtech.training.quizservice.vos;

import java.util.List;

import com.valtech.training.quizservice.entities.Quiz;

public record QuizVO (long id, String topic, int noOfQuestion, List<Long> questionId){
	
	public Quiz to() {
		return new Quiz(topic, noOfQuestion);
	}
	
	public static QuizVO from(Quiz q) {
		return new QuizVO(q.getId(), q.getTopic(), q.getNoOfQuestions(), q.getQuestionId());
	}
}
