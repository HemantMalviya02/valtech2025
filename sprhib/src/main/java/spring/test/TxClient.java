package spring.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.tx.Employee;
import spring.tx.EmployeeService;
import spring.tx.Gender;

public class TxClient {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("tx-hib-annotation.xml");
		EmployeeService es = ctx.getBean(EmployeeService.class);
		System.out.println(es.getClass().getName());
		es.update(new Employee(10,"Ten", 10, 100000, Gender.FEMALE, 10, 10));
		es.getAll().forEach(e -> System.out.println(e));
		ctx.close();
	}

}
