package com.valtech.training.streamingservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.valtech.training.streamingservice.services.WebSeriesService;
import com.valtech.training.streamingservice.vos.WebSeriesVO;

@RestController
@RequestMapping("/api/v1/webseries")
public class WebSeriesController {
	
	@Autowired
	private WebSeriesService webSeriesService;
	
	@PostMapping("/")
	public WebSeriesVO saveWebSeries(@RequestBody WebSeriesVO vo) {
		return webSeriesService.createOrUpdate(vo);
	}
	
	@GetMapping("/{id}")
	public WebSeriesVO getWebSeries(@PathVariable("id") long id) {
		return webSeriesService.getWebSeries(id);
	}
	
	@GetMapping("/")
	public List<WebSeriesVO> getAllWebSeries() {
		return webSeriesService.getAllWebSeries();
	}
	
	@GetMapping("/episodecount/{episodeCount}")
	List<WebSeriesVO> getAllByEpisodeCount(@PathVariable("episodeCount") int episodecount){
		return webSeriesService.getAllByEpisodeCount(episodecount);
	}
	
	@GetMapping("/episodeDuration/{episodeDuration}")
	List<WebSeriesVO> getAllByEpisodeDuration(@PathVariable("episodeDuration") int episodeDuration){
		return webSeriesService.getAllByEpisodeDuration(episodeDuration);
	}
	
}
