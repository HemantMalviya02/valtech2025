package com.valtech.training.jaxws;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.SequenceGenerator;

@Entity
public class Movie {
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "movie_seq")
	@SequenceGenerator(name = "movie_seq", sequenceName = "movie_seq", allocationSize = 1)
	private long id;
	private String name;
	private String genre;
	private String language;
	
	@ElementCollection(targetClass = String.class, fetch = FetchType.EAGER)
	@CollectionTable(name = "movie_actors", 
			joinColumns = @JoinColumn(name = "movie_id", referencedColumnName = "id"))
	private List<String> actors;
	
	public Movie() {}

	public Movie(String name, String genre, String language, List<String> actors) {
		super();
		this.name = name;
		this.genre = genre;
		this.language = language;
		this.actors = actors;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public List<String> getActors() {
		return actors;
	}

	public void setActors(List<String> actors) {
		this.actors = actors;
	}
	
	
}
