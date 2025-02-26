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

	@Test
	void testhashcode() {
		Employee employee = new Employee(1, "Hemant", 22, 10000.2F, Gender.MALE,1,1);
		Employee employee1 = new Employee(1, "Hemant", 22, 10000.2F, Gender.MALE,1,1);
		Employee employee2 = new Employee(1, "Hemantt", 22, 10000.2F, Gender.MALE,1,1);

		
		int hash = employee.hashCode();
		System.out.println(employee+" hashcode = "+ employee.hashCode());
		assertEquals(hash, employee.hashCode());
		assertEquals(hash, employee1.hashCode());
		assertNotEquals(hash, employee2.hashCode());
		assertNotSame(employee, employee1);
		assertSame(employee, employee);
//		employee.setVariant("ZX");
//		System.out.println(employee +" "+ employee.hashCode());
//		assertNotEquals(hash, employee.hashCode());
//		employee.setVersion(6);
//		System.out.println(employee+" "+employee.hashCode());
//		assertEquals("Honda City ZX 2024 6", employee.toString());
//		employee.setModel("Jazz");
//		assertEquals("Honda Jazz ZX 2024 6", employee.toString());
	}
	
	@Test
	void test() {
		List<Employee> employees = new ArrayList<Employee>();
		employees.add(Employee.builder().id(1).name("Hemant").age(22).salary(10000).gender(Gender.MALE).level(1).experience(3).build());
		employees.add(Employee.builder().id(2).name("Sakshi S").age(22).salary(10000).gender(Gender.FEMALE).level(1).experience(3).build());
		employees.add(Employee.builder().id(3).name("Rushabh").age(50).salary(12000).gender(Gender.MALE).level(1).experience(1).build());
		employees.add(Employee.builder().id(4).name("Vishal").age(60).salary(15000).gender(Gender.MALE).level(2).experience(0).build());
		employees.add(Employee.builder().id(1).name("Raj").age(60).salary(10000).gender(Gender.MALE).level(6).experience(0).build());
		
		Collections.sort(employees);
		
		for(Employee e : employees) {
			System.out.println(e);
		} 
		List<Employee> myEmp = employees.stream().filter(emp->emp.getLevel() == 1).collect(Collectors.toList());
		System.out.println("Employee sorted by level: "+myEmp);
		
		System.out.println("Employee sorted by gender: " + employees.stream().filter(emp->emp.getGender() == Gender.FEMALE).collect(Collectors.toList()));
		
		System.out.println("Employee sorted by name: " + employees.stream().filter(emp->emp.getName().toLowerCase().contains(Character.toString('S').toLowerCase())).collect(Collectors.toList()));
		
		System.out.println("Employee sorted by name: " + employees.stream().filter(emp->emp.getName().toLowerCase().contains("s")).collect(Collectors.toList()));
		
		System.out.println("Employee sorted by toLower: " + employees.stream().filter(emp->emp.getName().equalsIgnoreCase("H")).collect(Collectors.toList()));
		
		System.out.println("Employee sorted by level & gender: " + employees.stream().filter(emp->emp.getLevel() == 1 && 
				emp.getGender() == Gender.MALE).collect(Collectors.toList()));
		
		System.out.println("Employee sorted by level & gender: " + employees.stream().filter(emp->emp.getLevel() == 1 && 
				emp.getGender() == Gender.MALE).mapToDouble(Employee::getSalary).sum());
		
//		:: method reference
		
//		List<Employee>empL=employees.stream().filter(emp->emp.getLevel() == 1 && emp.getGender().equals(Gender.MALE)).collect(Collectors.toList());
//		double sum=empL.stream().mapToDouble(Employee::getSalary).sum();
//		System.out.println(sum);
		
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


