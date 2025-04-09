package com.valtech.training.ecommerce.entities;

import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;



@Entity
public class Orders {
	
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_Seq")
	@SequenceGenerator(name = "order_Seq" ,sequenceName = "orderseq" , allocationSize = 1)	
	private long id;
	
	@Enumerated(EnumType.STRING)
	private Status status;
	
	@ManyToOne(targetEntity = Customer.class ,cascade = CascadeType.ALL ,fetch = FetchType.EAGER)
	@JoinColumn(name = "customer_id",referencedColumnName = "id")
	private Customer customer;
	@OneToMany(mappedBy = "orders",targetEntity = LineItems.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	
	private List<LineItems> lineItems;
	public enum Status{
		ORDERED, PACKED , SHIPPED, DELIVERED
	}

	public Orders() {}

	public Orders( Status status) {
		this.status = status;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<LineItems> getLineItems() {
		return lineItems;
	}

	public void setLineItems(List<LineItems> lineItems) {
		this.lineItems = lineItems;
	}
}
