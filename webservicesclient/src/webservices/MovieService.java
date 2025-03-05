package webservices;

import java.util.List;

public interface MovieService {

	List<Movie> getAllMovies();

	Movie getMovie(int id);

	void addMovie(Movie m);

	void removeMovie(Movie m);

}