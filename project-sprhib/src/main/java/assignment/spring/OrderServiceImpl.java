package assignment.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import assignment.spring.Order.Status;

public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderDAO orderDAO;
	@Autowired
	private InventoryService inventoryService;
	
	@Override
	public void placeOrder(Order order) {
		boolean placeOrder  = false;
		for (LineItems lineItem : order.getLineitems()) {
//			System.out.println("+++++++++++++++"+lineItem.getItem().getId());
			placeOrder = inventoryService.existingItem(lineItem.getItem().getId(), lineItem.getQuantity());
		}
		if(placeOrder) {
			order.setStatus(Status.PLACED);
		}
		else {
			order.setStatus(Status.FAIL);
		}
		orderDAO.save(order);
	}
	
	@Override
	public void update(Order order) {
		orderDAO.update(order);
	}
	@Override
	public void delete(long id) {
		orderDAO.delete(id);
	}
	@Override
	public Order get(long id) {
		return orderDAO.get(id);
	}
	@Override
	public List<Order> getAll() {
		return orderDAO.getAll();
	}
	
	public void setOrderDAO(OrderDAO orderDAO) {
		this.orderDAO = orderDAO;
	}
	
	public void setInventoryService(InventoryService inventoryService) {
		this.inventoryService = inventoryService;
	}
}
