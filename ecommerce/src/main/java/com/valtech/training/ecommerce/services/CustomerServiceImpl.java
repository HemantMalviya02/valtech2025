package com.valtech.training.ecommerce.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.ecommerce.entities.Customer;
import com.valtech.training.ecommerce.entities.Customer.CustomerStatus;
import com.valtech.training.ecommerce.repos.CustomerRepo;
import com.valtech.training.ecommerce.vos.CustomerVO;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepo customerRepo;
	
	@Override
	public CustomerVO saveOrUpdate(CustomerVO cv) {
		Customer customer = cv.to();
		customer = customerRepo.save(customer);
		return CustomerVO.from(customer);
	}
	
	@Override
	public CustomerVO getCustomer(long id) {
		return CustomerVO.from(customerRepo.getReferenceById(id));
	}
	
	@Override
	public CustomerVO enableCustomer(CustomerVO cv) {
		Customer customer = cv.to();
		customer.setCstatus(CustomerStatus.ENABLE);
		customerRepo.save(customer);
		return CustomerVO.from(customer);
	}
	
	@Override
	public CustomerVO disableCustomer(CustomerVO cv) {
		Customer customer = cv.to();
		customer.setCstatus(CustomerStatus.DISABLE);
		customerRepo.save(customer);
		return CustomerVO.from(customer);
	}
	
	@Override
	public List<CustomerVO> getAll() {
		return customerRepo.findAll().stream().map(cs -> CustomerVO.from(cs)).collect(Collectors.toList());
	}
	
}
