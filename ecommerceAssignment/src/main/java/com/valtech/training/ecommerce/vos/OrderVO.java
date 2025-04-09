package com.valtech.training.ecommerce.vos;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.valtech.training.ecommerce.entities.LineItems;
import com.valtech.training.ecommerce.entities.Orders;
import com.valtech.training.ecommerce.entities.Orders.Status;
import com.valtech.training.ecommerce.repos.OrderRepo;
import com.valtech.training.ecommerce.services.CustomerService;
import com.valtech.training.ecommerce.services.OrderService;
import com.valtech.training.ecommerce.services.OrderServiceImpl;

import jakarta.persistence.criteria.Order;

public class OrderVO {
	
	private long id;
	private String status ;
	private long custId;
	private long itemIds ; 
	private Integer quantity;

	@Autowired
	static CustomerService customerService;
	
	public OrderVO() {}
	
	public OrderVO(long id, String status, long custId, long itemIds, int quantity) {
		this.id = id;
		this.status = status;
		this.custId = custId;
		this.itemIds = itemIds;
		this.quantity = quantity;
	}
	
	public Orders to() {
		Status st = Status.valueOf(status);
		Orders o = new Orders(st);
		return o;
	}

	public OrderVO from(Orders o) {
		String orderStatus = o.getStatus().name();
		return new OrderVO(o.getId(), orderStatus, o.getCustomer().getId(), o.getLineItems().get(0).getItem().getId() , o.getLineItems().get(0).getQuantity());
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}

	public long getCustId() {
		return custId;
	}

	public void setCustId(long custId) {
		this.custId = custId;
	}

	public long getItemIds() {
		return itemIds;
	}

	public void setItemIds(long itemIds) {
		this.itemIds = itemIds;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
