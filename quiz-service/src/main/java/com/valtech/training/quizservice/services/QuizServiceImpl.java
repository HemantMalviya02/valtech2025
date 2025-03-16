package com.valtech.training.quizservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.quizservice.entities.Quiz;
import com.valtech.training.quizservice.repos.QuizRepo;
import com.valtech.training.quizservice.vos.QuizVO;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class QuizServiceImpl {
	
	@Autowired
	private QuizRepo quizRepo;
	
	public QuizVO saveOrUpdate(QuizVO vo) {
		Quiz quiz = vo.to();
		quiz = quizRepo.save(quiz);
		return QuizVO.from(quiz);
	}
	
//	public 
}
