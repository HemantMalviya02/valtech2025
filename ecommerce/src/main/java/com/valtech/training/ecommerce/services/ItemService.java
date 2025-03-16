package com.valtech.training.ecommerce.services;

import java.util.List;

import com.valtech.training.ecommerce.vos.ItemVO;

public interface ItemService {

	ItemVO saveOrUpdate(ItemVO iv);

	List<ItemVO> getAll();

}