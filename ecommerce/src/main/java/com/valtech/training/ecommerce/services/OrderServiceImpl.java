package com.valtech.training.ecommerce.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.ecommerce.entities.Customer;
import com.valtech.training.ecommerce.entities.LineItems;
import com.valtech.training.ecommerce.entities.Order;
import com.valtech.training.ecommerce.entities.Order.Status;
import com.valtech.training.ecommerce.repos.OrderRepo;


@Service
@Transactional(propagation = Propagation.REQUIRED)
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	InventoryService inventoryService;
	
	@Autowired
	OrderRepo orderRepo;
	
	@Override
	public void placeOrder(Order order, long id) {
		
		if(Customer.CustomerStatus.DISABLE.equals(order.getCustomer().getCstatus())) {
			System.out.println("Invalid Customer!");
		}
		else  {
			boolean placeOrder  = false;
			for (LineItems lineItem : order.getLineitems()) {
				placeOrder = inventoryService.existingItem(lineItem.getItem().getId(), lineItem.getQuantity());
			}
			if(placeOrder) {
				order.setStatus(Status.PLACED);
			}
			else {
				order.setStatus(Status.FAIL);
			}
			orderRepo.save(order);
		}
	}
}
