package com.valtech.training.first;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.first.entities.Question;
import com.valtech.training.first.services.QuestionService;

@SpringBootTest
//@Transactional(propagation = Propagation.REQUIRED)
class FirstApplicationTests {
	
	@Autowired
	private Arithmetic arithmetic;
	
	@Autowired
	private SimpleInterest simpleInterest;
	
	@Autowired
	private QuestionService questionService;

	@Test
	void testArithmetic() {
		assertEquals(10, arithmetic.add(4, 6));
		assertEquals(200, simpleInterest.compute(200, 5, 20));
	}

	
	@Test
//	@Rollback
	void questionService() {
//		initData();
		assertEquals(5, questionService.countByTopic("Gk"));
		assertEquals(7, questionService.countByTopic("Java"));
		
		assertEquals(2, questionService.countByTopicAndQuestionTextContaining("Java", "exception"));
		assertEquals(3, questionService.countByTopicAndQuestionTextContaining("Java", "Interface"));
		assertEquals(3, questionService.countByTopicAndQuestionTextContainingIgnoreCase("Java", "interface"));
		assertEquals(5, questionService.findAllByTopic("Gk",0,5).size());
		assertEquals(0, questionService.findAllByTopic("Gk",1,5).size());
		
	}
	
//	@BeforeEach
	void initData() {
		long count = questionService.count();
		if(count != 0) return;
		
		Question q = 
				questionService.saveQuestion(new Question("What is the color of sky ?", "Red", "Green", "Blue", "White", "Blue", "Gk"));
				questionService.saveQuestion(new Question("What is the color of Mars ?", "Red", "Green", "Blue", "White", "Red", "Gk"));
				questionService.saveQuestion(new Question("What is the color of jupiter ?", "Red", "Green", "Blue", "Yellow", "Yellow", "Gk"));
				questionService.saveQuestion(new Question("What is the color of Saturn ?", "Red", "Green", "Blue", "White", "Blue", "Gk"));
				questionService.saveQuestion(new Question("What is the color of Venus ?", "Red", "Green", "Blue", "White", "White", "Gk"));
				//questionService.saveQuestion(new Question("What is the color of moon ?", "Red", "Blue", "Green", "White", "White", "Gk"));
				questionService.saveQuestion(new Question("What is the super class of exception ?", "Object", "Exception", "Throawble", "Error", "Throawble", "Java"));
				questionService.saveQuestion(new Question("Which class is used to create Dynamic Strings ?", "String", "DynamicString", "StringBuilder", "Builder", "StringBuilder", "Java"));
				questionService.saveQuestion(new Question("What is used to create Dynamic Strings ?", "String", "DynamicString", "StringBuilder", "Builder", "StringBuilder", "Java"));
				questionService.saveQuestion(new Question("How many methods are functional Interface ?", "None", "One", "Many", "Two", "One", "Java"));
				questionService.saveQuestion(new Question("How many methods are there in Marker Interface ?", "None", "One", "Many", "Two", "None", "Java"));
				questionService.saveQuestion(new Question("Can an Interface have private Method ?", "Yes", "No", "May be", "No method can be there in an interface", "Yes", "Java"));
				questionService.saveQuestion(new Question("Which subclass of exception is not checked by the compiler?", "Exception", "Error", "RuntimeException", "None", "RuntimeException", "Java"));
	}

}
