package com.valtech.training.ecommerce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.ecommerce.entities.Customer;
import com.valtech.training.ecommerce.entities.Customer.CustStatus;
import com.valtech.training.ecommerce.repos.CustomerRepo;
import com.valtech.training.ecommerce.vos.CustomerVO;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepo customerRepo;
	
	@Override
	public CustomerVO addCustomer(CustomerVO custVO) {
		return CustomerVO.from(customerRepo.save(custVO.to())) ;
	}
	
	@Override
	public void removeCustomer(CustomerVO custVO) {
		customerRepo.delete(custVO.to()) ;
	}
	
	@Override
	public CustomerVO enableCustomerStatus(CustomerVO custVO) {
		Customer cust = custVO.to();
		if(cust.getStatus()!= CustStatus.ENABLE)
			cust.setStatus(CustStatus.ENABLE);
		customerRepo.save(cust);
		return CustomerVO.from(cust);
	}
	
	@Override
	public CustomerVO disableCustomerStatus(CustomerVO custVO) {
		Customer cust = custVO.to();
		if(cust.getStatus()!= CustStatus.DISABLE)
			cust.setStatus(CustStatus.DISABLE);
		customerRepo.save(cust);
		return CustomerVO.from(cust);
	}
	
	@Override
	public CustomerVO getCustomer(long id) {
		return CustomerVO.from(customerRepo.getReferenceById(id)) ;
		
	}

	@Override
	public List<CustomerVO> getCustomers() {
		return CustomerVO.from(customerRepo.findAll()) ;
	}
	
	public void setCustomerRepo(CustomerRepo customerRepo) {
		this.customerRepo = customerRepo;
	}
}
