package com.valtech.training.quizservice.vos;

public record QuestionVO (long id, String questionText, String option1, String option2, String option3, 
		 String option4, String correctOption, String topic) {

}
