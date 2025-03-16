package com.valtech.training.ecommerce.vos;

import java.util.List;

import com.valtech.training.ecommerce.entities.Customer;
import com.valtech.training.ecommerce.entities.LineItems;
import com.valtech.training.ecommerce.entities.Order;
import com.valtech.training.ecommerce.entities.Order.Status;

public record OrderVO(long id, long custId, String status) {
	
	public Order to() {
		Status orderStatus = Status.valueOf(status);
		return new Order(orderStatus);
	}
	
	public static OrderVO from(Order o) {
		String orderStatus = o.getStatus().name();
		return new OrderVO(o.getId(), o.getCustomer().getId(), orderStatus);
	}
}
