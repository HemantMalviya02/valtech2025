package com.valtech.training.ecommerce.vos;

import com.valtech.training.ecommerce.entities.Item;

public class ItemVO {

	private long id;
	private String name;
	private String description;
	private int currentQuantity;
	int reOrderQuantity ;
	int maximumQuantity;
	
	public ItemVO() {}

	public ItemVO(long id, String name, String description, int currQuantity, int reOrderQuantity, int maxQuantity) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.currentQuantity = currQuantity;
		this.reOrderQuantity = reOrderQuantity;
		this.maximumQuantity = maxQuantity;
	}
	
	public Item to() {
		Item i = new Item(name, description, currentQuantity, reOrderQuantity, maximumQuantity);
		i.setId(id);
		return i;
	}
	
	public static ItemVO from(Item i) {
		return new ItemVO(i.getId(), i.getName(), i.getDesc(), i.getCurrQuantity(), i.getReOrderQuantity(), i.getMaxQuantity());
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getCurrQuantity() {
		return currentQuantity;
	}

	public void setCurrQuantity(int currQuantity) {
		this.currentQuantity = currQuantity;
	}

	public int getReOrderQuantity() {
		return reOrderQuantity;
	}

	public void setReOrderQuantity(int reOrderQuantity) {
		this.reOrderQuantity = reOrderQuantity;
	}

	public int getMaxQuantity() {
		return maximumQuantity;
	}

	public void setMaxQuantity(int maxQuantity) {
		this.maximumQuantity = maxQuantity;
	}
	
}
