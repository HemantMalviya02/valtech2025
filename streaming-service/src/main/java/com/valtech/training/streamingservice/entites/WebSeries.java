package com.valtech.training.streamingservice.entites;

import jakarta.persistence.Entity;

@Entity
public class WebSeries extends Content{
	
	private int episodeCount;
	private long episodeDuration;
		
	public WebSeries() {}


	public WebSeries(String name, String genre, String language, long costPerView, int episodeCount,
			long episodeDuration) {
		super(name, genre, language, costPerView);
		this.episodeCount = episodeCount;
		this.episodeDuration = episodeDuration;
	}


	public int getEpisodeCount() {
		return episodeCount;
	}


	public void setEpisodeCount(int episodeCount) {
		this.episodeCount = episodeCount;
	}


	public long getEpisodeDuration() {
		return episodeDuration;
	}


	public void setEpisodeDuration(long episodeDuration) {
		this.episodeDuration = episodeDuration;
	}
	
	
}
