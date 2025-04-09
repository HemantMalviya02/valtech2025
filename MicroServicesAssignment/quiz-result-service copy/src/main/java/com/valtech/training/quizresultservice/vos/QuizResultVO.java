package com.valtech.training.quizresultservice.vos;

import com.valtech.training.quizresultservice.entities.QuizResult;

public record QuizResultVO(long id,long quizId,int score,double percentage) {

	public static QuizResultVO from(QuizResult qr) {
		return new QuizResultVO(qr.getId(), qr.getQuizId(), qr.getScore(), qr.getPercentage());
	}
	
	public QuizResult to() {
		return new QuizResult(quizId);
	}
}
