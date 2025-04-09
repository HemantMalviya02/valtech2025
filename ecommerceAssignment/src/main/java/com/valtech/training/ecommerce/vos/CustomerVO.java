package com.valtech.training.ecommerce.vos;

import java.util.List;
import java.util.stream.Collectors;

import com.valtech.training.ecommerce.entities.Customer;
import com.valtech.training.ecommerce.entities.Customer.CustStatus;

public class CustomerVO {

	private long id;
	private String name;
	private int age;
	private String address ;
	private String perAddress;
	private String custStatus;
	
	public CustomerVO() {}
	
	public CustomerVO(long id, String name, int age, String address, String perAddress, String custStatus) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.address = address;
		this.perAddress = perAddress;
		this.custStatus = custStatus;
	}

	public Customer to() {
		CustStatus status = CustStatus.valueOf(custStatus);
		return new Customer(name, age, address, perAddress, status);
	}
	
	public static CustomerVO from(Customer c) {
		String cs = c.getStatus().name();
		return new CustomerVO(c.getId(), c.getName(), c.getAge(), c.getAddress(),c.getPerAddress() , cs);
	}
	
	public static List<CustomerVO> from (List<Customer> custs){
		return custs.stream().map(c->CustomerVO.from(c)).collect(Collectors.toList());
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

	public String getCustStatus() {
		return custStatus;
	}

	public void setCustStatus(String custStatus) {
		this.custStatus = custStatus;
	}
}
