package com.valtech.training.quizservice.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valtech.training.quizservice.entities.QuestionResult;

@Repository
public interface QuestionResultRepo extends JpaRepository<QuestionResult, Long>{
	public List<QuestionResult> findAllQuestionResultsByQuizId(long id);
}
