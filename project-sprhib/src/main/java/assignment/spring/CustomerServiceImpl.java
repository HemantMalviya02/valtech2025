package assignment.spring;

import org.springframework.beans.factory.annotation.Autowired;

import assignment.spring.Customer.CustomerStatus;

public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	CustomerDAO customerDAO;
	
	public void setCustomerDAO(CustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}
	
	@Override
	public void addCustomer(Customer c) {
		customerDAO.save(c);
	}
	@Override
	public Customer getCustomer(long id) {
		return customerDAO.get(id);
	}
	@Override
	public void deleteCustomer(long id) {
		customerDAO.delete(id);
	}
	
	@Override
	public void enableCustomer(Customer c) {
		c.setCstatus(CustomerStatus.ENABLE);
		customerDAO.update(c);
		
	}
	
	@Override
	public void disableCustomer(Customer c) {
		c.setCstatus(CustomerStatus.DISABLE);
		customerDAO.update(c);
	}
	
}
