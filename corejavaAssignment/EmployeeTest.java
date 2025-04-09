package day4;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import day2.Car;

class EmployeeTest {
	private EmployeeService es = new EmployeeService();
	
//	Employee e1 = (Employee.builder().id(1).name("Hemant").age(22).salary(10000).gender(Gender.MALE).level(1).experience(3).build());
//	Employee e2 = (Employee.builder().id(2).name("Sakshi S").age(22).salary(10000).gender(Gender.FEMALE).level(1).experience(3).build());
//	Employee e3 = (Employee.builder().id(3).name("Rushabh").age(50).salary(12000).gender(Gender.MALE).level(1).experience(1).build());
//	Employee e4 = (Employee.builder().id(4).name("Vishal").age(60).salary(15000).gender(Gender.MALE).level(2).experience(0).build());
//	Employee e5 = (Employee.builder().id(1).name("Raj").age(60).salary(10000).gender(Gender.MALE).level(6).experience(0).build());
	
//	List<Employee> employee = Employee.employee;
	
	List<Employee> employee = new ArrayList<Employee>();
	
	@BeforeEach
	void testAdd() {
		employee.add(Employee.builder().id(1).name("Hemant").age(22).salary(10000).gender(Gender.MALE).level(1).experience(3).build());
		employee.add(Employee.builder().id(2).name("Sakshi S").age(22).salary(10000).gender(Gender.FEMALE).level(1).experience(3).build());
		employee.add(Employee.builder().id(3).name("Rushabh").age(50).salary(12000).gender(Gender.MALE).level(1).experience(1).build());
		employee.add(Employee.builder().id(4).name("Vishal").age(60).salary(15000).gender(Gender.MALE).level(2).experience(0).build());
		employee.add(Employee.builder().id(5).name("Raj").age(60).salary(10000).gender(Gender.MALE).level(6).experience(0).build());
	}
	
	@Test
	void testhashcode() {
		
		int hash = employee.hashCode();
		
		Employee e1 = employee.get(0);
		Employee e2 = employee.get(1);
		
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
		assertEquals(3, employee.get(0).getId());
	}
	
	@Test
	void testTotalSalaryOfEmployeeByLevelAndGender() {
		assertEquals(15000, es.totalSalaryOfEmployee(es.searchByLevelAndGender(employee, 2, Gender.MALE)));
		
	}
	
	@Test
	void testTotalSalaryOfEmployeeByName() {
		es.totalSalaryOfEmployee(es.searchEmployeeByName(employee, 's'));
		assertEquals(37000, es.totalSalaryOfEmployee(es.searchEmployeeByName(employee, 's')));
	}
	
	@Test
	void testTotalSalaryOfEmployeeByNameToLower() {
		assertEquals(22000, es.totalSalaryOfEmployee(es.searchEmployeeByToLower(employee, 'R')));
		
	}
	
	@Test
	void testTotalSalaryOfEmployeeByGender() {
		
		assertEquals(10000, es.totalSalaryOfEmployee(es.searchEmployeeByGender(employee, Gender.FEMALE))); 
	}
	
	@Test
	void testTotalSalaryOfEmployeeByLevel() {
		assertEquals(15000, es.totalSalaryOfEmployee(es.searchEmployeeByLevel(employee, 2))); 
	}
	
	
	
	@Test
	void testsearchEmployeeByLevel() {
		assertEquals(1, es.searchEmployeeByLevel(employee, 2).size());
	}
	
	@Test
	void testsearchEmployeeByGender() {
		assertEquals(1, es.searchEmployeeByGender(employee, Gender.FEMALE).size());
	}
	
	@Test
	void testsearchEmployeeByName() {
		assertEquals(3,es.searchEmployeeByName(employee, 's').size());
	}
	
	@Test
	void testsearchEmployeeByToLower() {	
		assertEquals(2,es.searchEmployeeByToLower(employee, 'R').size());
	}
	
	@Test
	void testsearchByLevelAndGender() {
		assertEquals(2, es.searchEmployeeByToLower(employee, 'R').size());
	}
	
	
	
	@Test
	void test() {
		
//		:: method reference
		Map<Gender, List<Employee>> mp = employee.stream()
        .collect(Collectors.groupingBy(Employee::getGender));
		System.out.println(mp);
		assertNotNull(mp);
		
		
//		if we want to print separately the key & value, we can do by, keySet(), and values()
		Set<Gender>lsk=mp.keySet();
		Collection<List<Employee>>ls=mp.values();
		System.out.println(lsk);
		System.out.println(ls);
		
	}
	
	
}


