package day4;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import day2.Car;

class EmployeeTest {
	private EmployeeService es = new EmployeeService();
	
	Employee e1 = (Employee.builder().id(1).name("Hemant").age(22).salary(10000).gender(Gender.MALE).level(1).experience(3).build());
	Employee e2 = (Employee.builder().id(2).name("Sakshi S").age(22).salary(10000).gender(Gender.FEMALE).level(1).experience(3).build());
	Employee e3 = (Employee.builder().id(3).name("Rushabh").age(50).salary(12000).gender(Gender.MALE).level(1).experience(1).build());
	Employee e4 = (Employee.builder().id(4).name("Vishal").age(60).salary(15000).gender(Gender.MALE).level(2).experience(0).build());
	Employee e5 = (Employee.builder().id(1).name("Raj").age(60).salary(10000).gender(Gender.MALE).level(6).experience(0).build());
	
	List<Employee> employee = Employee.employee;
	
	@Test
	void testhashcode() {
		
		int hash = employee.hashCode();
		
		System.out.println(employee+" hashcode = "+ employee.hashCode());
		assertEquals(hash, employee.hashCode());
		assertNotEquals(hash, e1.hashCode());
		assertNotEquals(hash, e2.hashCode());
		assertNotSame(employee, e1);
		assertSame(employee, employee);
	}
	
	@Test
	void testEqual() {
		Employee employee = new Employee(1, "Hemant", 22, 10000.2F, Gender.MALE,1,1);
		Employee employee1 = new Employee(2, "Raj", 60, 10000.2F, Gender.MALE,1,1);
		
		assertTrue(employee.equals(employee));
		assertFalse(employee.equals(employee1));
	}
	@Test
	void testSortEmployee() {
		System.out.println("Testing Sorted Employee");
		Collections.sort(employee);
		System.out.println(employee);
	}
	
	@Test
	void TestTotalSalaryOfEmployeeByLevelAndGender() {
		assertEquals(135000, es.TotalSalaryOfEmployee(es.searchByLevelAndGender(employee, 2, Gender.MALE)));
		
	}
	
	@Test
	void TestTotalSalaryOfEmployeeByName() {
		es.TotalSalaryOfEmployee(es.searchEmployeeByName(employee, 's'));
		assertEquals(185000, es.TotalSalaryOfEmployee(es.searchEmployeeByName(employee, 's')));
	}
	
	@Test
	void TestTotalSalaryOfEmployeeByNameToLower() {
		assertEquals(176000, es.TotalSalaryOfEmployee(es.searchEmployeeByToLower(employee, 'R')));
		
	}
	
	@Test
	void TestTotalSalaryOfEmployeeByGender() {
		
		assertEquals(30000, es.TotalSalaryOfEmployee(es.searchEmployeeByGender(employee, Gender.FEMALE))); 
	}
	
	@Test
	void TestTotalSalaryOfEmployeeByLevel() {
		assertEquals(105000, es.TotalSalaryOfEmployee(es.searchEmployeeByLevel(employee, 2))); 
	}
	
	@Test
	void test() {
	
		List<Employee> employees = new ArrayList<Employee>();

		for(Employee e : employees) {
			System.out.println(e);
		} 
		

//		es.searchEmployeeByGender(employees, Gender.FEMALE);
//		es.searchEmployeeByName(employees, 's');
//		es.searchEmployeeByToLower(employees, 'H');
//		es.searchByLevelAndGender(employees, 3, Gender.MALE);
		
		
//		:: method reference
		
		
		Map<Gender, List<Employee>> mp = employees.stream()
        .collect(Collectors.groupingBy(Employee::getGender));
		System.out.println(mp);
		
		
//		if we want to print separately the key & value, we can do by, keySet(), and values()
		Set<Gender>lsk=mp.keySet();
		Collection<List<Employee>>ls=mp.values();
		System.out.println(lsk);
		System.out.println(ls);
		
	}
	
	
}


