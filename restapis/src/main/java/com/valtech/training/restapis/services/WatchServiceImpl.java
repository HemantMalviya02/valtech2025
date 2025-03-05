package com.valtech.training.restapis.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.restapis.entities.Watch;
import com.valtech.training.restapis.repos.WatchRepo;
import com.valtech.training.restapis.vos.WatchVO;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class WatchServiceImpl implements WatchService {
	
	@Autowired
	private WatchRepo watchRepo;
	
	
	@Override
	public WatchVO createWatch(WatchVO watch) {
		return WatchVO.from(watchRepo.save(watch.toWatch()));
	}
	
	
	@Override
	public WatchVO updateWatch(long id, WatchVO watch) {
		Watch watch1 = watchRepo.getReferenceById(id);
		watch.updateWatchFromVO(watch1);
		return WatchVO.from(watchRepo.save(watch1));
	}
	
	
	@Override
	public WatchVO getWatch(long id) {
		return WatchVO.from(watchRepo.getReferenceById(id));
	}
	
	
	@Override
	public List<WatchVO> getWatches() {
		return WatchVO.toWatchVO(watchRepo.findAll());
	}


	@Override
	public List<WatchVO> getWatchesByBrand(String brand) {
		return WatchVO.toWatchVO(watchRepo.findAllByBrand(brand));
	}

}
