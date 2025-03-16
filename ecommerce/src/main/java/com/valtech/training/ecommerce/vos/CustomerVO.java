package com.valtech.training.ecommerce.vos;

import com.valtech.training.ecommerce.entities.Customer;

public record CustomerVO(long id, String name, int age, String address, String permanentAddress) {

	public Customer to() {
		return new Customer(name, age, address, permanentAddress);
	}
	
	public static CustomerVO from(Customer c) {
		return new CustomerVO(c.getId(), c.getName(), c.getAge(),c.getAddress(), c.getPermanentAddress());
	}
	
}
