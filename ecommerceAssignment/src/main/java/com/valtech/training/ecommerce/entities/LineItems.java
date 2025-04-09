package com.valtech.training.ecommerce.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;

@Entity
public class LineItems {

	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "lineItem_Seq")
	@SequenceGenerator(name = "lineItem_Seq",sequenceName = "lineItemseq ", allocationSize = 1)
	private long id;
	private int quantity;
	@ManyToOne(targetEntity = Orders.class , cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "order_id",referencedColumnName = "id")
	private Orders orders;
	@ManyToOne(targetEntity = Item.class  ,fetch = FetchType.EAGER)
	@JoinColumn(name = "item_id", referencedColumnName = "id")
	private Item items;
	
	public LineItems() {}
	
	public LineItems(int quantity) {
		this.quantity = quantity;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Orders getOrder() {
		return orders;
	}
	public void setOrder(Orders order) {
		this.orders = order;
	}
	public Item getItem() {
		return items;
	}
	public void setItem(Item item) {
		this.items = item;
	}
	@Override
	public String toString() {
		return "LineItems [id=" + id + ", quantity=" + quantity + ", orders=" + orders + ", items=" + items + "]";
	}
}
