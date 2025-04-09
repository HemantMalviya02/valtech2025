package com.valtech.training.quizresultservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.valtech.training.quizresultservice.services.QuizResultService;
import com.valtech.training.quizresultservice.vos.QuizResultVO;

@RestController
@RequestMapping("/api/v1/quizResult")
public class QuizResultController {

	@Autowired
	private QuizResultService quizResultService;
	
	@PostMapping("/")
	public QuizResultVO createQuizResult(@RequestBody QuizResultVO vo) {
		return quizResultService.createQuizResult(vo);
	}
	
	@GetMapping("/")
	public List<QuizResultVO> getQuizResults(){
		return quizResultService.getAllQuizResult();
	}
	
	@GetMapping("/{id}")
	public QuizResultVO getQuizResult(@PathVariable long id) {
		return quizResultService.getQuizResult(id);
	}
}
