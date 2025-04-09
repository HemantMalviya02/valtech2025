package com.valtech.training.question.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valtech.training.question.entities.Question;
import com.valtech.training.question.vos.QuestionVO;

@Repository
public interface QuestionRepo extends JpaRepository<Question, Long>{

	List<Question> findAllByTopic(String topic);

}
