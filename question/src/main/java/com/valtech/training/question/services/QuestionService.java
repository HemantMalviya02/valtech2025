package com.valtech.training.question.services;

import java.util.List;

import com.valtech.training.question.vos.QuestionVO;

public interface QuestionService {

	QuestionVO saveOrUpdate(QuestionVO vo);

	QuestionVO get(long id);

	List<QuestionVO> getAll();

	List<QuestionVO> findAllByTopic(String topic);

}