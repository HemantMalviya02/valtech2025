package com.valtech.training.quizservice.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valtech.training.quizservice.entities.Quiz;
import com.valtech.training.quizservice.vos.QuestionVO;

@Repository
public interface QuizRepo extends JpaRepository<Quiz, Long>{
	
}
