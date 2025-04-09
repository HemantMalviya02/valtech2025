package com.valtech.training.ecommerce.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.ecommerce.entities.Item;
import com.valtech.training.ecommerce.repos.ItemRepo;

@Service
@Transactional(propagation = Propagation.SUPPORTS)
public class InventoryServiceImpl implements InventoryService {
	@Autowired
	private ItemRepo itemRepo;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Boolean checkCurrentItem(int quantity , long id) {
		System.out.println("id in check...."+id);
		Item i = itemRepo.getReferenceById(id);
		System.out.println("Current Quantity in Item:: "+ i.getCurrQuantity()+" And Quantity:: "+quantity);
		if(i.getCurrQuantity()>quantity) {
			i.setCurrQuantity(i.getCurrQuantity()-quantity);
			System.out.println("Id of item in a list:: -------"+i.getCurrQuantity()); 
			itemRepo.save(i); 
			return true;
		}
		return false;
	}

	@Override
	public void setCurrentIfRequired(long id) {
		
		Item i = itemRepo.getReferenceById(id);

		if(i.getCurrQuantity()<i.getReOrderQuantity()) {
			i.setCurrQuantity(i.getMaxQuantity());
		}
	}
	
}
