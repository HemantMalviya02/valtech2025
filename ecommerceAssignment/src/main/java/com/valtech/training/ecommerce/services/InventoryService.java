package com.valtech.training.ecommerce.services;

public interface InventoryService {

	Boolean checkCurrentItem(int quantity, long id);
	void setCurrentIfRequired(long id);
}