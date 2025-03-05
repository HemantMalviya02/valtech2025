package assignment.spring;

import java.util.List;

public interface OrderService {

	void placeOrder(Order order);

	void update(Order order);

	void delete(long id);

	Order get(long id);

	List<Order> getAll();

}