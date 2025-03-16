package com.valtech.training.ecommerce.services;

public interface InventoryService {

	boolean existingItem(long itemId, int quantityAsked);

	void updateCurrQuantity(long itemId);

}