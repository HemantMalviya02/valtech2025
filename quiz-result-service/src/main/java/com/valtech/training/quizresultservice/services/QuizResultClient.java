package com.valtech.training.quizresultservice.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.valtech.training.quizresultservice.vos.QuestionResultVO;

@Component
public class QuizResultClient {

	public List<QuestionResultVO> findAllByQuizId(long id){
		RestTemplate temp = new RestTemplate();
		String url = "http://localhost:9030/api/v1/QuestionResult/quiz/"+id;
		System.out.println("Id url-------"+url);
		List<QuestionResultVO> ques = Arrays.asList(temp.getForObject(url, QuestionResultVO[].class));
		System.out.println("Question"+ques);
		return ques;
	}
}
