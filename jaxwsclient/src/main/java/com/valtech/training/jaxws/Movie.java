package com.valtech.training.jaxws;

import java.util.List;


public class Movie {
	
	private long id;
	private String name;
	private String genre;
	private String language;
	
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

	@Override
	public String toString() {
		return "Movie [id=" + id + ", name=" + name + ", genre=" + genre + ", language=" + language + ", actors="
				+ actors + "]";
	}
	
	
	
}
