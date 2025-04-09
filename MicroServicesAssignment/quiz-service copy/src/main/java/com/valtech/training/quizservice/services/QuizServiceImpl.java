package com.valtech.training.quizservice.services;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.quizservice.entities.Quiz;
import com.valtech.training.quizservice.repos.QuizRepo;
import com.valtech.training.quizservice.vos.QuestionVO;
import com.valtech.training.quizservice.vos.QuizVO;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class QuizServiceImpl implements QuizService {
	
	@Autowired
	private QuizRepo quizRepo;
	
	@Autowired
	private QuestionClient questionClient;
	
	
	@Override
	public QuizVO saveOrUpdate(QuizVO vo) {
		Quiz quiz = vo.to();
		String topic = quiz.getTopic();
		System.out.println("topic = "+topic);
		List<QuestionVO> questions = questionClient.getQuestion(topic);
		Collections.shuffle(questions);
//		System.out.println("---------------ques"+questions.size());
		int noOfQues = quiz.getNoOfQuestions();
//		System.out.println("---------------+++++++"+noOfQues);
		questions = questions.stream().limit(questions.size()).collect(Collectors.toList());
//		System.out.println("---------------"+questions);
		quiz.setTopic(topic);
		quiz.setNoOfQuestions(questions.size());
//		quiz.setQuestionId(quesIds);
		quiz = quizRepo.save(quiz);
		return QuizVO.from(quiz);
	}
	
	
}
