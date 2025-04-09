package com.valtech.training.ecommerce.services;

import java.util.List;
import java.util.Set;

import com.valtech.training.ecommerce.entities.LineItems;
import com.valtech.training.ecommerce.entities.Orders;
import com.valtech.training.ecommerce.vos.LineItemVO;
import com.valtech.training.ecommerce.vos.OrderVO;


public interface OrderService {
	
	String OrderProcess(OrderVO orderVO);

	
}