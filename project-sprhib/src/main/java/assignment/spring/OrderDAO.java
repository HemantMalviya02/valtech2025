package assignment.spring;

import java.util.List;

public interface OrderDAO {
	void save(Order o);
	void update(Order o);
	void delete(long id);
	Order get(long id);
	List<Order> getAll();
}
