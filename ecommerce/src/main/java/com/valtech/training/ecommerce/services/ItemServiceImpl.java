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
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	private ItemRepo itemRepo;
	
	@Override
	public ItemVO saveOrUpdate(ItemVO iv) {
		Item item = iv.to();
		item = itemRepo.save(item);
		return ItemVO.from(item);
	}
	@Override
	public List<ItemVO> getAll() {
		return itemRepo.findAll().stream().map(l -> ItemVO.from(l)).collect(Collectors.toList());
	}
}
