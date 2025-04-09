package com.valtech.training.ecommerce.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.ecommerce.repos.ItemRepo;
import com.valtech.training.ecommerce.vos.ItemVO;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemRepo itemRepo;
	
	@Override
	public ItemVO addOrUpdateItem(ItemVO itemVO) {
		System.out.println("reOrderQuantity in Service :: "+itemVO.to().getReOrderQuantity());
		return ItemVO.from(itemRepo.save(itemVO.to()));
	}
	
	@Override
	public void deleteItem(ItemVO itemVO) {
		itemRepo.save(itemVO.to());
	}
	
	@Override
	public ItemVO getItem(long id) {
		return ItemVO.from(itemRepo.getReferenceById(id));
	}
	
	@Override
	public List<ItemVO> getAllItems(){
		return itemRepo.findAll().stream().map(i->ItemVO.from(i)).collect(Collectors.toList());
	}
}
