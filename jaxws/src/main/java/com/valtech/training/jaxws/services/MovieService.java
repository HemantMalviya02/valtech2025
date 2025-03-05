package com.valtech.training.jaxws.services;

import java.util.List;

import com.valtech.training.jaxws.Movie;

public interface MovieService {

	List<Movie> getAllMovies();

	Movie getMovie(long id);

	Movie createMovie(Movie m);

}