package com.valtech.training.ecommerce.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Item {
	
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "item_Seq")
	@SequenceGenerator(name = "item_Seq", sequenceName = "itemseq" , allocationSize = 1)
	private long id;
	private String name;
	private String description;
	private int currentQuantity;
	private int reorderQuantity;
	private int maximumQuantity;
	
	public Item() {}

	public Item( String description, String name ,int currQuantity, int reOrderQuantity, int maxQuantity) {
		this.description = description;
		this.name = name;
		this.currentQuantity = currQuantity;
		this.reorderQuantity = reOrderQuantity;
		this.maximumQuantity = maxQuantity;
		
	}
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDesc() {
		return description;
	}

	public void setDesc(String desc) {
		description = desc;
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
		return reorderQuantity;
	}

	public void setReOrderQuantity(int reOrderQuantity) {
		this.reorderQuantity = reOrderQuantity;
	}

	public int getMaxQuantity() {
		return maximumQuantity;
	}

	public void setMaxQuantity(int maxQuantity) {
		this.maximumQuantity = maxQuantity;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", description=" + description + ", currQuantity=" + currentQuantity
				+ ", reOrderQuantity=" + reorderQuantity + ", maxQuantity=" + maximumQuantity + "]";
	}
}
