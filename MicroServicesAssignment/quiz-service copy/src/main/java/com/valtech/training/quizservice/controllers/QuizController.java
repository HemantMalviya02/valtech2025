package com.valtech.training.quizservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.valtech.training.quizservice.services.QuizService;
import com.valtech.training.quizservice.vos.QuizVO;

@RestController
@RequestMapping("/api/v1/quiz")
public class QuizController {
	
	@Autowired
	private QuizService quizService;
	
	@PostMapping("/")
	public QuizVO createQuiz(@RequestBody QuizVO vo) {
		return quizService.saveOrUpdate(vo);
	}
}
