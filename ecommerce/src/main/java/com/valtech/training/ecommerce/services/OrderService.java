package com.valtech.training.ecommerce.services;

import com.valtech.training.ecommerce.entities.Order;

public interface OrderService {

	void placeOrder(Order order, long id);

}