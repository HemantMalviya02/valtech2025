package assignment.spring;

public interface CustomerService {

	void addCustomer(Customer c);

	void deleteCustomer(long id);

	void enableCustomer(Customer c);

	void disableCustomer(Customer c);

	Customer getCustomer(long id);

}