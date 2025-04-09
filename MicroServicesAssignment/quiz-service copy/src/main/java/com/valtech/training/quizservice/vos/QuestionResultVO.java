package com.valtech.training.quizservice.vos;

import com.valtech.training.quizservice.entities.QuestionResult;
import com.valtech.training.quizservice.entities.Quiz;

public record QuestionResultVO (long id, String userAnswer, String result, long questionId, long quizId){

	public QuestionResult to(Quiz q) {
		QuestionResult quiz =  new QuestionResult(userAnswer, result, questionId);
		quiz.setQuiz(q);
		return quiz;
	}
	
	public static QuestionResultVO from(QuestionResult q) {
		return new QuestionResultVO(q.getId(), q.getUserAnswer(), q.getResult(), q.getQuestionId(),q.getQuiz().getId());
	}
}
