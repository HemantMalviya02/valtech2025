package com.valtech.training.quizresultservice.vos;

public record QuestionResultVO(Long id,Long quizId,Long quesId,String userAnswer,boolean result) {

}
