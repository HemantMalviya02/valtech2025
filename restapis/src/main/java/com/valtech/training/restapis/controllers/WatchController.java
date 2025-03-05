package com.valtech.training.restapis.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.valtech.training.restapis.entities.Watch;
import com.valtech.training.restapis.services.WatchService;
import com.valtech.training.restapis.vos.WatchVO;

@RestController
@RequestMapping("/api/v1/watches")
public class WatchController {
	
	@Autowired
	private WatchService watchService;
	
	@GetMapping ("/brand/{brand}")               // in postMan = http://localhost:8080/watches/brand/Noise
	public List<WatchVO> getWatchesByBrand(@PathVariable("brand") String brand) {
		return watchService.getWatchesByBrand(brand);
	}
	
//	Another Way of doing this below
	
//	@GetMapping("/watches/")							// in postMan = http://localhost:8080/watches/?brand=Noise
//	public List<WatchVO> getWatchesByBrand(@RequestParam("Brand") String brand) {
//		return watchService.getWatchesByBrand(brand);
//	}
	
	@GetMapping("/{id}")						// in postMan = http://localhost:8080/watches/1
	public WatchVO getWatch(@PathVariable("id") long id) {
		return watchService.getWatch(id);
	}
	
	@GetMapping("/")							// if NULL = in postMan = http://localhost:8080/watches/
														//Else = in postMan = http://localhost:8080/watches/?brand=Noise
	public List<WatchVO> getWatches(@RequestParam(name = "brand", required = false) String brand) {
		if(brand == null) 
			return watchService.getWatches();
		else
			return watchService.getWatchesByBrand(brand);  
	}
	
	@PostMapping("/")
	public WatchVO createWatch(@RequestBody WatchVO watch) {
		return watchService.createWatch(watch);
	}
	
	@PutMapping("/{id}")
	public WatchVO updateWatch(@PathVariable("id") long id, @RequestBody WatchVO watch) {
		return watchService.updateWatch(id, watch);
	}
	
}
