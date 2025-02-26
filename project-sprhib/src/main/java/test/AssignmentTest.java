package test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import assignment.spring.Customer;
import assignment.spring.CustomerDAO;
import assignment.spring.CustomerDAOImpl;
import assignment.spring.Item;
import assignment.spring.ItemDAO;
import assignment.spring.ItemDAOImpl;

class AssignmentTest {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("springHib.xml");
		
		ItemDAOImpl it = ctx.getBean(ItemDAOImpl.class);
		CustomerDAOImpl cs = ctx.getBean(CustomerDAOImpl.class);
//		
//		System.out.println(it.getClass().getName());
//		
//		it.save(new Item("WrathX", "Pre Workout", 10, 4, 15));
		
		
//		del.delete(5L);
		
		
//		Item it1 = it.get(3L);
//		it1.setDesc_item("Micronised Monohydrate");
//		it.update(it1);
//		it.getAll().forEach(i -> System.out.println(i));
		
		
		
//		System.out.println(cs.getClass().getName());
		cs.save(new Customer("Yash", 23, "Ahemdabad", "Ambaji"));
		Customer c = cs.get(2L);
		c.setAge(28);
		cs.update(c);
		cs.getAll().forEach(ct -> System.out.println(ct));
		
		
		ctx.close();
	}
	
	
	
}
