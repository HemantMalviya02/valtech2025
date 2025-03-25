package com.valtech.training.resultservice.vos;

import java.util.List;

import com.valtech.training.resultservice.entities.Result;

public record ResultVO (long id, int score,  List<Long> quizId, double percentage){

	public Result to() {
		return new Result(score, percentage);
	}
	
	public static ResultVO from(Result res) {
		return new ResultVO(res.getId(), res.getScore(), res.getQuizId(), res.getPercentage());
	}
}
