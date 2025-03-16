package com.valtech.training.quizservice.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valtech.training.quizservice.entities.Quiz;

@Repository
public interface QuizRepo extends JpaRepository<Quiz, Long>{

}
