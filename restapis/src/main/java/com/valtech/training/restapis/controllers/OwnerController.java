package com.valtech.training.restapis.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.DeleteExchange;

import com.valtech.training.restapis.services.OwnerService;
import com.valtech.training.restapis.vos.OwnerVO;

@RestController
@RequestMapping("/api/v1/owners")
public class OwnerController {
	
	@Autowired
	private OwnerService ownerService;
	
//	by request mapping it will use the path as prefix in every path
	
	
	@PutMapping("/{id}/watches")
	public OwnerVO updateWatches (@PathVariable("id") long id, @RequestBody List<Long> watches){
		return ownerService.addWatchesToOwner(id, watches);
	}

	
//	get ownerById
//	create owner
//	getAllOwners
	
	@GetMapping("/{id}")
	public OwnerVO getOwner(@PathVariable("id") long id) {
		return ownerService.getOwner(id);
	}
	
	@PostMapping("/")
	public OwnerVO create(@RequestBody OwnerVO owner) {
		return ownerService.createOwner(owner);
	}
	
	@GetMapping("/")
	public List<OwnerVO> getOwners() {
		return ownerService.getOwners();
	}
	
	@PutMapping("/{id}")
	public OwnerVO update(@PathVariable("id") long id, @RequestBody OwnerVO owner) {
		return ownerService.updateOwner(id, owner);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") long id) {
		ownerService.deleteOwner(id);
	}
	
	
	
}
