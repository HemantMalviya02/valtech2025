package com.valtech.training.question.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.valtech.training.question.services.QuestionService;
import com.valtech.training.question.vos.QuestionVO;

@RestController
@RequestMapping("/api/v1/questions")
public class QuestionController {
	
	@Autowired
	private QuestionService questionService;
	
	
	@PostMapping("/")
	public QuestionVO createQuestion(@RequestBody QuestionVO vo) {
		return questionService.saveOrUpdate(vo);
	}
	
	
	@GetMapping("/") 
	public List<QuestionVO> getAllQuestions(){
		return questionService.getAll();
	}
	
	@GetMapping("/{id}")
	public QuestionVO getQuestion(@PathVariable("") long id) {
		return questionService.get(id);
	}
//	
	@GetMapping("/topic/{topic}")
	public List<QuestionVO> getAllByTopic(@PathVariable("topic") String topic) {
		return questionService.findAllByTopic(topic);
	}
}
