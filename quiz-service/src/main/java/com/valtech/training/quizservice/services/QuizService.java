package com.valtech.training.quizservice.services;

import org.springframework.stereotype.Service;

import com.valtech.training.quizservice.vos.QuizVO;

@Service
public interface QuizService {

	QuizVO saveOrUpdate(QuizVO vo);

}