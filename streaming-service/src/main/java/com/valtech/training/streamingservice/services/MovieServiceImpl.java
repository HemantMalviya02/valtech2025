package com.valtech.training.streamingservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.streamingservice.repos.MovieRepo;
import com.valtech.training.streamingservice.vos.MovieVO;


@Service
@Transactional(propagation = Propagation.REQUIRED)
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieRepo movieRepo;
	
	@Override
	public MovieVO createOrUpdate(MovieVO vo) {
		return MovieVO.from(movieRepo.save(vo.to()));
	}
	
	@Override
	public List<MovieVO> getAllMovies() {
		return MovieVO.from(movieRepo.findAll());
	}
	
	@Override
	public MovieVO getMovie(long id) {
		return MovieVO.from(movieRepo.getReferenceById(id));
	}
	
	@Override
	public List<MovieVO> getMoviesByGenre(String genre) {
		return MovieVO.from(movieRepo.findAllByGenre(genre));
	}
	
	@Override
	public List<MovieVO> getMoviesByGenreAndLanguage(String genre, String language) {
		return MovieVO.from(movieRepo.findAllByGenreAndLanguage(genre, language));
	}
}
