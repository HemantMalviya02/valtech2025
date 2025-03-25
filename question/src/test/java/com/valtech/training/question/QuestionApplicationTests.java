package com.valtech.training.question;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.valtech.training.question.vos.QuestionVO;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class QuestionApplicationTests {

	@LocalServerPort
	private Integer port;
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	public void test() {
		String url = "http://localhost:"+port+"/api/v1/questions/";
		ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}
	
	@Test
	void addQuestion() {
		String url = "http://localhost:"+port+"/api/v1/questions/";
		
		System.out.println("..........." + url);
		List question = restTemplate.getForObject(url, List.class);
		System.out.println("--------------------"+question);
		if(question.size() == 0) {
//			System.out.println("Adding question to database...");
		
		QuestionVO question1 = restTemplate.postForObject(url, new QuestionVO(0, "What is the color of sky ?",
								"Red", "Green", "Blue", "White", "Blue", "Gk"), QuestionVO.class);
		QuestionVO question2 = restTemplate.postForObject(url, new QuestionVO(0, "What is the color of Mars ?",
								"Red", "Green", "Blue", "White", "Red", "Gk"), QuestionVO.class);
		QuestionVO question3 = restTemplate.postForObject(url, new QuestionVO(0, "What is the color of jupiter ?",
								"Red", "Green", "Blue", "Yellow", "Yellow", "Gk"), QuestionVO.class);
		QuestionVO question4 = restTemplate.postForObject(url, new QuestionVO(0, "What is the color of Saturn ?",
								"Red", "Green", "Blue", "White", "Blue", "Gk"), QuestionVO.class);
		QuestionVO question5 = restTemplate.postForObject(url, new QuestionVO(0, "What is the color of Venus ?",
								"Red", "Green", "Blue", "White", "White", "Gk"), QuestionVO.class);
		QuestionVO question6 = restTemplate.postForObject(url, new QuestionVO(0, "What is the color of moon ?",
								"Red", "Blue", "Green", "White", "White", "Gk"), QuestionVO.class);
		
		QuestionVO question7 = restTemplate.postForObject(url, new QuestionVO(0, "What is the super class of exception ?",
								"Object", "Exception", "Throawble", "Error", "Throawble", "Java"), QuestionVO.class);
		QuestionVO question8 = restTemplate.postForObject(url, new QuestionVO(0, "Which class is used to create Dynamic Strings ?",
								"String", "DynamicString", "StringBuilder", "Builder", "StringBuilder", "Java"), QuestionVO.class);
		QuestionVO question9 = restTemplate.postForObject(url, new QuestionVO(0, "What is used to create Dynamic Strings ?",
								"String", "DynamicString", "StringBuilder", "Builder", "StringBuilder", "Java"), QuestionVO.class);
		QuestionVO question10 = restTemplate.postForObject(url, new QuestionVO(0, "How many methods are functional Interface ?",
								"None", "One", "Many", "Two", "One", "Java"), QuestionVO.class);
		QuestionVO question11 = restTemplate.postForObject(url, new QuestionVO(0, "How many methods are there in Marker Interface ?",
								"None", "One", "Many", "Two", "None", "Java"), QuestionVO.class);
		QuestionVO question12 = restTemplate.postForObject(url, new QuestionVO(0, "Can an Interface have private Method ?",
								"Yes", "No", "May be", "No method can be there in an interface", "Yes", "Java"), QuestionVO.class);
		QuestionVO question13 = restTemplate.postForObject(url, new QuestionVO(0, "Which subclass of exception is not checked by the compiler?",
								"Exception", "Error", "RuntimeException", "None", "RuntimeException", "Java"), QuestionVO.class);
		
		QuestionVO question14 = restTemplate.postForObject(url, new QuestionVO(0, "Which of the following is a linear data structure?",
				"Array", "AVLTrees", "BinaryTrees", "Graphs", "Array", "DSA"), QuestionVO.class);
		QuestionVO question15 = restTemplate.postForObject(url, new QuestionVO(0, "Which of the following is not the type of queue?",
				"PriorityQueue", "SingleEndedQueue", "CircularQueue", "OrdinaryQueue", "SingleEndedQueue", "DSA"), QuestionVO.class);
		QuestionVO question16 = restTemplate.postForObject(url, new QuestionVO(0, "Which of the following data structures allow insertion and deletion from both ends?",
				"Stack", "Queue", "Deque", "Strings", "Deque", "DSA"), QuestionVO.class);
		QuestionVO question17 = restTemplate.postForObject(url, new QuestionVO(0, "Which of the following is a Divide and Conquer algorithm?",
				"BubbleSort", "SelectionSort", "MergeSort", "HeapSort", "MergeSort", "DSA"), QuestionVO.class);
		QuestionVO question18 = restTemplate.postForObject(url, new QuestionVO(0, "What is the time complexity of the binary search algorithm?",
				"o(n)", "o(1)", "o(logn)", "o(n^2)", "o(logn)", "DSA"), QuestionVO.class);
		QuestionVO question19 = restTemplate.postForObject(url, new QuestionVO(0, "Which data structure is mainly used for implementing the recursive algorithm?",
				"Queue", "Stack", "Array", "List", "Stack", "DSA"), QuestionVO.class);
		}
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
