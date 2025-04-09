package com.valtech.training.question.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.question.entities.Question;
import com.valtech.training.question.repos.QuestionRepo;
import com.valtech.training.question.vos.QuestionVO;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class QuestionServiceImpl implements QuestionService {
	
	@Autowired
	private QuestionRepo questionRepo;
	
	@Override
	public QuestionVO saveOrUpdate(QuestionVO vo) {
		Question question = vo.to();
		question = questionRepo.save(question);
		return QuestionVO.from(question);
	}
	
	@Override
	public QuestionVO get(long id) {
		return QuestionVO.from(questionRepo.getReferenceById(id));
	}
	
	@Override
	public List<QuestionVO> getAll() {
		return questionRepo.findAll().stream().map(ls -> QuestionVO.from(ls)).collect(Collectors.toList());
	}
	
	@Override
	public List<QuestionVO> findAllByTopic(String topic) {
		return QuestionVO.from(questionRepo.findAllByTopic(topic));
	}
	
	
}
