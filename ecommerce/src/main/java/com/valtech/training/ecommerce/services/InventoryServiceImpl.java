package com.valtech.training.ecommerce.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.ecommerce.entities.Item;
import com.valtech.training.ecommerce.repos.ItemRepo;
import com.valtech.training.ecommerce.vos.ItemVO;


@Service
@Transactional(propagation = Propagation.REQUIRED)
public class InventoryServiceImpl implements InventoryService{
	
	@Autowired
	private ItemRepo itemRepo;
	
	@Override
	public boolean existingItem(long itemId, int quantityAsked) {
		Item existingItem = itemRepo.getReferenceById(itemId);
		System.out.println(existingItem);
		
		if(existingItem != null && existingItem.getCurrQuantity() >= quantityAsked) {
			existingItem.setCurrQuantity(existingItem.getCurrQuantity() - quantityAsked);
			existingItem.setReorderQuantity(existingItem.getReorderQuantity() + quantityAsked);
			itemRepo.save(existingItem);
			return true;
		}
		else 
			return false;
	}
	
	@Override
	public void updateCurrQuantity(long itemId) {
		Item it = itemRepo.getReferenceById(itemId);
		
		if(it.getReorderQuantity() == it.getMaxQuantity()) {
			it.setCurrQuantity(it.getMaxQuantity());
			it.setReorderQuantity(0);
			itemRepo.save(it);
		}
	}
	
	
	
}
