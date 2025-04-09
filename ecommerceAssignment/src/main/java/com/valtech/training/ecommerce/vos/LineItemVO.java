package com.valtech.training.ecommerce.vos;

import com.valtech.training.ecommerce.entities.Item;
import com.valtech.training.ecommerce.entities.LineItems;

public record LineItemVO(long id, int quantity, long orderId , String itemId){

	public LineItems to(Item item) {
		LineItems li = new LineItems(quantity);
		li.setItem(item);
		return li;
	}
	
	public static LineItemVO from(LineItems l) {
		return new LineItemVO(l.getId(), l.getQuantity(), l.getOrder().getId(), String.valueOf(l.getItem().getId()) );
	}
	
}
