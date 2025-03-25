package com.valtech.training.quizservice;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import com.valtech.training.quizservice.vos.QuizVO;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class QuizServiceApplicationTests {

	@LocalServerPort
	private Integer port;
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	void addQuiz() {
		String url = "http://localhost:"+port+"/api/v1/quiz/";
		QuizVO quizVO = restTemplate.postForObject(url, new QuizVO(0, "Java", "Raj",3), QuizVO.class);
	}
}
