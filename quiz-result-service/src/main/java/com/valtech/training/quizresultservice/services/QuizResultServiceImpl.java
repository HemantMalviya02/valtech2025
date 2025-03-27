package com.valtech.training.quizresultservice.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.quizresultservice.entities.QuizResult;
import com.valtech.training.quizresultservice.repos.QuizResultRepo;
import com.valtech.training.quizresultservice.vos.QuestionResultVO;
import com.valtech.training.quizresultservice.vos.QuizResultVO;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class QuizResultServiceImpl implements QuizResultService {

	@Autowired
	private QuizResultRepo quizResultRepo;
	
	@Autowired
	private QuizResultClient quizResultClient;
	
	@Override
	public QuizResultVO createQuizResult(QuizResultVO vo) {
		List<QuestionResultVO> quiz = quizResultClient.findAllByQuizId(vo.quizId());
		int score=0;
		for (QuestionResultVO questionResultVO : quiz) {
			if(questionResultVO.result()==true) {
				score++;
			}
		}
		double per = ((double)score/quiz.size())*100;
		QuizResult qr = vo.to();
		qr.setScore(score);
		qr.setPercentage(per);
		quizResultRepo.save(qr);
		return QuizResultVO.from(qr);
	}
	
	@Override
	public QuizResultVO getQuizResult(long id) {
		return QuizResultVO.from(quizResultRepo.getReferenceById(id));
	}
	
	@Override
	public List<QuizResultVO> getAllQuizResult(){
		return quizResultRepo.findAll().stream().map(qr -> QuizResultVO.from(qr)).collect(Collectors.toList());
	}
}
