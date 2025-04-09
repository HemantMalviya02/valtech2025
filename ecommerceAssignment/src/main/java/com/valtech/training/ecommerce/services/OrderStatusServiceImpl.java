package com.valtech.training.ecommerce.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.valtech.training.ecommerce.entities.Orders;
import com.valtech.training.ecommerce.entities.Orders.Status;
import com.valtech.training.ecommerce.repos.OrderRepo;



public class OrderStatusServiceImpl implements OrderStatusService {
	
	@Autowired
	private OrderRepo orderRepo;
	
	
	@Override
	public Status checkOrderStatus(long orderId) {
		System.out.println("OrderId for Check status:: "+orderId);
		Orders o = orderRepo.getReferenceById(orderId);
		return o.getStatus(); 
	}
	
	@Override
	public Status SetNextOrderStatus(long orderId) {
		
		Status currentStatus = orderRepo.getReferenceById (orderId).getStatus();
		Status[] status = Status.values();
		
		int currentStatusIndex = currentStatus.ordinal();
		int nextStatusIndex = currentStatusIndex;
		
		if(currentStatusIndex!=status.length-1)
		nextStatusIndex ++;
		
		Orders o = orderRepo.getReferenceById(orderId);
		o.setStatus(status[nextStatusIndex]);
		orderRepo.save(o);
		return status[nextStatusIndex];
	}
	
	public void setOrderRepo(OrderRepo orderRepo) {
		this.orderRepo = orderRepo;
	}
	
}


