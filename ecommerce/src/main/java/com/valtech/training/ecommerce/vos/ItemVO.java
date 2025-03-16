package com.valtech.training.ecommerce.vos;

import com.valtech.training.ecommerce.entities.Item;

public record ItemVO(long id, String name, String descItem, int currQuantity, int reorderQuantity, int maxQuantity) {
	
	public Item to() {
		return new Item(name, descItem, currQuantity, reorderQuantity, maxQuantity);
	}
	
	public static ItemVO from(Item i) {
		return new ItemVO(i.getId(), i.getName(), i.getDescItem(), i.getCurrQuantity(), i.getReorderQuantity(), i.getMaxQuantity());
	}
}
