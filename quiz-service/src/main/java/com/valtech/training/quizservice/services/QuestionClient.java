package com.valtech.training.quizservice.services;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.valtech.training.quizservice.vos.QuestionVO;

@Component
public class QuestionClient {
	public List<QuestionVO> getQuestion(String topic) {
		RestTemplate template = new RestTemplate();
		String url = "http://localhost:9040/api/v1/questions/"+topic;
		List<QuestionVO> qsn = template.getForObject(url, List.class); 
		return qsn;
	}
}
