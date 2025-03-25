package com.valtech.training.streamingservice.services;

import java.util.List;

import com.valtech.training.streamingservice.vos.WebSeriesVO;

public interface WebSeriesService {

	WebSeriesVO createOrUpdate(WebSeriesVO vo);

	List<WebSeriesVO> getAllWebSeries();

	WebSeriesVO getWebSeries(long id);

	List<WebSeriesVO> getAllByEpisodeCount(int count);

	List<WebSeriesVO> getAllByEpisodeDuration(int episodeDuration);

}