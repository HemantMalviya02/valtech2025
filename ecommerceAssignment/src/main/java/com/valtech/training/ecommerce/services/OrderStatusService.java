package com.valtech.training.ecommerce.services;

import com.valtech.training.ecommerce.entities.Orders.Status;

public interface OrderStatusService {

	Status checkOrderStatus(long orderId);

	Status SetNextOrderStatus(long orderId);

}