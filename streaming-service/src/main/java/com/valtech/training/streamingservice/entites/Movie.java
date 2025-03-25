package com.valtech.training.streamingservice.entites;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Movie extends Content{
	
	private long duration;

	public Movie() {}


	public Movie(String name, String genre, String language, long costPerView, long duration) {
		super(name, genre, language, costPerView);
		this.duration = duration;
	}

	public long getDuration() {
		return duration;
	}

	public void setDuration(long duration) {
		this.duration = duration;
	} 
	
	
	
	
	
}
