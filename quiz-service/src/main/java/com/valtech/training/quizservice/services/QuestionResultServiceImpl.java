package com.valtech.training.quizservice.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.quizservice.entities.QuestionResult;
import com.valtech.training.quizservice.repos.QuestionResultRepo;
import com.valtech.training.quizservice.repos.QuizRepo;
import com.valtech.training.quizservice.vos.QuestionResultVO;
import com.valtech.training.quizservice.vos.QuestionVO;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class QuestionResultServiceImpl {
	
	@Autowired
	private QuestionResultRepo questionResultRepo;
	
	@Autowired
	private QuestionClient questionClient;
	
	@Autowired
	private QuizRepo quizRepo;
	
	public QuestionResultVO saveOrUpdate(QuestionResultVO vo) {
		QuestionResult quesRes = vo.to(quizRepo.getReferenceById(vo.quizId()));
		QuestionVO quesVo = questionClient.getQuestionById(vo.questionId());
		String correctAns = quesVo.correctOption();
		if(vo.userAnswer().equals(correctAns)) {
			quesRes.setResult("correct");
		}
		else 
			quesRes.setResult("incorrect");
		
		questionResultRepo.save(quesRes);
		return QuestionResultVO.from(quesRes);
	}
	
	public List<QuestionResultVO> getAllByQuizId(long id) {
		return questionResultRepo.findAllQuestionResultsByQuizId(id).stream()
								 .map(l -> QuestionResultVO.from(l)).collect(Collectors.toList());
	}
	
	public QuestionResultVO get(long id) {
		return QuestionResultVO.from(questionResultRepo.getReferenceById(id));
	}
	
	public List<QuestionResultVO> getAll() {
		return questionResultRepo.findAll().stream().map(ls -> QuestionResultVO.from(ls)).collect(Collectors.toList());
	}
}
