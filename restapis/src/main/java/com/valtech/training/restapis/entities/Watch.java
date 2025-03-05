package com.valtech.training.restapis.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Watch {
	
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "watch_seq")
	@SequenceGenerator(name = "watch_seq", sequenceName = "watch_seq", allocationSize = 1)
	private long id;
	private String brand;
	private String model;
	private String color;
	private float price;
	private String type;
	
	@ManyToOne(targetEntity = Owner.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "owner_id", referencedColumnName = "id")
	private Owner owner;
	
	public Watch() {}

	public Watch(String brand, String model, String color, float price, String type) {
		super();
		this.brand = brand;
		this.model = model;
		this.color = color;
		this.price = price;
		this.type = type;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	
	
}
