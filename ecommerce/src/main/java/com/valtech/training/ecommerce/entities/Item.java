package com.valtech.training.ecommerce.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Item {
	
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orderseq") 
	@SequenceGenerator(name="orderseq", sequenceName = "order_seq", allocationSize = 1)
	private long id;
	private String name;
	private String descItem;
	private int currQuantity;
	private int reorderQuantity;   // minimum quantity
	private int maxQuantity;
	
	public Item() {}

	public Item(String name, String descItem, int currQuantity, int reorderQuantity, int maxQuantity) {
		this.name = name;
		this.descItem = descItem;
		this.currQuantity = currQuantity;
		this.reorderQuantity = reorderQuantity;
		this.maxQuantity = maxQuantity;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescItem() {
		return descItem;
	}

	public void setDescItem(String desc_item) {
		this.descItem = desc_item;
	}

	public int getCurrQuantity() {
		return currQuantity;
	}

	public void setCurrQuantity(int curr_quantity) {
		this.currQuantity = curr_quantity;
	}

	public int getReorderQuantity() {
		return reorderQuantity;
	}

	public void setReorderQuantity(int reorder_quantity) {
		this.reorderQuantity = reorder_quantity;
	}

	public int getMaxQuantity() {
		return maxQuantity;
	}

	public void setMaxQuantity(int max_quantity) {
		this.maxQuantity = max_quantity;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", descItem=" + descItem + ", currQuantity=" + currQuantity
				+ ", reorderQuantity=" + reorderQuantity + ", maxQuantity=" + maxQuantity + "]";
	}

	
}
