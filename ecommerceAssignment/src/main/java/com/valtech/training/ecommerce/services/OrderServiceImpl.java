package com.valtech.training.ecommerce.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.ecommerce.entities.Customer.CustStatus;
import com.valtech.training.ecommerce.entities.Item;
import com.valtech.training.ecommerce.entities.LineItems;
import com.valtech.training.ecommerce.entities.Orders;
import com.valtech.training.ecommerce.entities.Orders.Status;
import com.valtech.training.ecommerce.repos.LineItemRepo;
import com.valtech.training.ecommerce.repos.OrderRepo;
import com.valtech.training.ecommerce.vos.ItemVO;
import com.valtech.training.ecommerce.vos.LineItemVO;
import com.valtech.training.ecommerce.vos.OrderVO;

import jakarta.persistence.criteria.Order;

@Service
@Transactional(propagation = Propagation.SUPPORTS)
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepo orderRepo;
	@Autowired
	private InventoryService inventoryService;
	
	@Autowired
	private ItemService itemService;
	
	@Autowired
	private CustomerService customerService;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public String OrderProcess(OrderVO orderVO) {
		if(orderVO.getStatus()=="DISABLE") return "Customer is Disable to place Order";
		
		long itemId = orderVO.getItemIds() ;
		int quantity = orderVO.getQuantity();
		long customerId = orderVO.getCustId();
		
		LineItems lineitem = new LineItems();
		lineitem.setItem(itemService.getItem(itemId).to());
		lineitem.setQuantity(quantity);
		Orders o = new Orders();
		o.setStatus(Status.ORDERED);
		o.setLineItems(List.of(lineitem));
		o.setCustomer(customerService.getCustomer(customerId).to());

		List<LineItems> lineItems =o.getLineItems();
		System.out.println("lineItems:: "+o.getLineItems());
		
		for(LineItems lineItem : lineItems) {
			int quantities = lineItem.getQuantity();
			System.out.println(lineItem.toString());
			Item i = lineItem.getItem();
			lineItem.setOrder(o);
			System.out.println("item in process.."+i);
			long id = i.getId();

			Boolean ans = inventoryService.checkCurrentItem(quantities, id);
			
			if(!ans) {
				return "Item is out of stocks";
			}
			
			lineItem.setOrder(o);
			inventoryService.setCurrentIfRequired(id);
		}
		orderRepo.save(o);
		return "Order Placed Successfully";
	}

	public void setInventoryService(InventoryService inventoryService) {
		this.inventoryService = inventoryService;
	}
}
