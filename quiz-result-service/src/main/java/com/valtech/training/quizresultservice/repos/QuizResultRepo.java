package com.valtech.training.quizresultservice.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valtech.training.quizresultservice.entities.QuizResult;

@Repository
public interface QuizResultRepo extends JpaRepository<QuizResult, Long>{

}
