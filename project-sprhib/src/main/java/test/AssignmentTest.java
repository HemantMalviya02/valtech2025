package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import assignment.spring.Customer;
import assignment.spring.Customer.CustomerStatus;
import assignment.spring.CustomerDAO;
import assignment.spring.CustomerDAOImpl;
import assignment.spring.CustomerService;
import assignment.spring.CustomerServiceImpl;
import assignment.spring.InventoryService;
import assignment.spring.InventoryServiceImpl;
import assignment.spring.Item;
import assignment.spring.ItemDAO;
import assignment.spring.ItemDAOImpl;
import assignment.spring.LineItemDAOImpl;
import assignment.spring.LineItems;
import assignment.spring.Order;
import assignment.spring.Order.Status;
import assignment.spring.OrderDAOImpl;
import assignment.spring.OrderService;
import assignment.spring.OrderServiceImpl;

class AssignmentTest {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("springHib.xml");
		
		
		
		InventoryService is = ctx.getBean(InventoryServiceImpl.class);
		OrderService os = ctx.getBean(OrderServiceImpl.class);
		CustomerService cs = ctx.getBean(CustomerServiceImpl.class);    // not creating customerService bcoz the methods are same as in DAOImpl.
		
		
//		LineItemDAOImpl li = ctx.getBean(LineItemDAOImpl.class);
//		OrderDAOImpl or = ctx.getBean(OrderDAOImpl.class);
//		ItemDAO it = ctx.getBean(ItemDAOImpl.class);
//		Item i = ctx.getBean(Item.class);
		

//		System.out.println(it.getClass().getName());
//		
		
//		---------------FOR ORDER---------------------
		
		Customer c = cs.getCustomer(2L);
//		System.out.println(c);
//		Order o = new Order();
//		o.setCustomer(c);
//		o.setStatus(Status.PLACED);
//		or.save(o);
		
		
//		---------------FOR LINEITEMS---------------------
		
		Item i = is.get(11);
//		Item i = is.get(1L);
//		Item i1 = it.get(3L);
		System.out.println(i);
		
		
		Order o = new Order();
		o.setCustomer(c);
		LineItems lineItem = new LineItems();
		lineItem.setItem(i);
		lineItem.setQuantity(4);     // for pass case
		lineItem.setOrder(o);
		System.out.println("????????????????"+lineItem.getItem().getId());
		List<LineItems> lineItems = new ArrayList<LineItems>();
		lineItems.add(lineItem);
		o.setLineitems(lineItems);
//		o.setLineitems(Arrays.asList(lineItem));
//		
		os.placeOrder(o);
		
//		Item i = it.get(1L);
//		System.out.println(i);
//		Order lo = or.get(10L);
//		System.out.println(lo);
//		LineItems lineItem = new LineItems();
//		lineItem.setItem(i);
//		lineItem.setOrder(lo);
//		lineItem.setQuantity(4);
//		li.save(lineItem);
		
		
//		---------------FOR ITEM---------------------
		
//		it.save(new Item("WrathX", "Pre Workout", 10, 4, 15));
		
		
//		del.delete(5L);
		
		
//		Item it1 = it.get(3L);
//		it1.setDesc_item("Micronised Monohydrate");
//		it.update(it1);
//		it.getAll().forEach(i -> System.out.println(i));
		
		
//		---------------FOR CUSTOMER---------------------
		
//		System.out.println(cs.getClass().getName());
//		cs.save(new Customer("Dev", 30, "Mumbai", "Dehradun"));
		Customer c1 = cs.getCustomer(3L);
//		c.setAge(28);
//		cs.update(c);
//		cs.getAll().forEach(ct -> System.out.println(ct));
		

//		cs.addCustomer(new Customer("Rohit", 21, "Pune", "Abu"));
		
		cs.disableCustomer(c1);	
//		cs.enableCustomer(c1);
		
		ctx.close();
	}
	
	
	
}
