package com.valtech.training.ecommerce.entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;



@Entity
@Table
public class Customer {

	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cust_Seq")
	@SequenceGenerator(name = "cust_Seq" , sequenceName = "custseq", allocationSize = 1)
	private long id;
	private String name;
	private int age;
	private String address;
	private String perAddress;
	@Enumerated(EnumType.STRING)
	private CustStatus custStatus;
	
	public enum CustStatus{
		ENABLE , DISABLE
	}
	public Customer() {}
	
	public Customer(String name, int age, String address, String perAddress, CustStatus status) {
		this.name = name;
		this.age = age;
		this.address = address;
		this.perAddress = perAddress;
		this.custStatus = status;
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPerAddress() {
		return perAddress;
	}
	public void setPerAddress(String perAddress) {
		this.perAddress = perAddress;
	}
	public CustStatus getStatus() {
		return custStatus;
	}
	public void setStatus(CustStatus status) {
		this.custStatus = status;
	}
	
}
