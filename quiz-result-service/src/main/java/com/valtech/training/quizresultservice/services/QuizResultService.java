package com.valtech.training.quizresultservice.services;

import java.util.List;

import com.valtech.training.quizresultservice.vos.QuizResultVO;

public interface QuizResultService {

	QuizResultVO createQuizResult(QuizResultVO vo);

	QuizResultVO getQuizResult(long id);

	List<QuizResultVO> getAllQuizResult();

}