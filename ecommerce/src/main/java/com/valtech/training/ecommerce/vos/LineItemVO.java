package com.valtech.training.ecommerce.vos;

import com.valtech.training.ecommerce.entities.Item;
import com.valtech.training.ecommerce.entities.LineItems;
import com.valtech.training.ecommerce.entities.Order;

public record LineItemVO(long id, long itemId, int quantity, long orderId) {
	
	
	public LineItems to() {
		return new LineItems(quantity);
	}
	
	public static LineItemVO from(LineItems li) {
		return new LineItemVO(li.getId(), li.getItem().getId(), li.getQuantity(), li.getOrder().getId());
	}
}
