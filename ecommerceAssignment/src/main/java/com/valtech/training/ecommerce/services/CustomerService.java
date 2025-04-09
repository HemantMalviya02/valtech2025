package com.valtech.training.ecommerce.services;

import java.util.List;

import com.valtech.training.ecommerce.entities.Customer;
import com.valtech.training.ecommerce.vos.CustomerVO;

public interface CustomerService {

	CustomerVO addCustomer(CustomerVO cust);

	void removeCustomer(CustomerVO cust);

	CustomerVO enableCustomerStatus(CustomerVO cust);

	CustomerVO disableCustomerStatus(CustomerVO cust);
	
	CustomerVO getCustomer(long id);
	
	List<CustomerVO> getCustomers();

}