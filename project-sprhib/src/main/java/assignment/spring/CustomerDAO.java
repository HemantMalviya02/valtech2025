package assignment.spring;

import java.util.List;

public interface CustomerDAO {
	void save(Customer c);
	void update(Customer c);
	void delete(long id);
	Customer get(long id);
	List<Customer> getAll();
}
