package com.valtech.training.jaxws.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valtech.training.jaxws.Movie;

@Repository
public interface MovieRepo extends JpaRepository<Movie, Long>{
	
}
