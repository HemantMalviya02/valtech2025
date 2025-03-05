package day4;

import java.util.List;
import java.util.stream.Collectors;

public class EmployeeService {
	public List<Employee> searchEmployeeByLevel(List<Employee> employees, int level){
		return employees.stream().filter(emp->emp.getLevel() == level).collect(Collectors.toList());	
	}
	
	public List<Employee> searchEmployeeByGender(List<Employee> employees, Gender gender){
		return (employees.stream().filter(emp->emp.getGender() == gender).collect(Collectors.toList()));	
	}
	
	public List<Employee> searchEmployeeByName(List<Employee> employees, char ch) {
		return (employees.stream().filter(emp->emp.getName().toLowerCase().contains(Character.toString(ch).toLowerCase())).collect(Collectors.toList()));
	}
	
	public List<Employee> searchEmployeeByToLower(List<Employee> employees,char ch) {
		return (employees.stream().filter(emp->emp.getName().contains(Character.toString(ch))).collect(Collectors.toList()));
	}
	
	public double TotalSalaryOfEmployee(List<Employee> employees) {
		return (employees.stream().mapToDouble(Employee::getSalary).sum());
	}
		
	public List<Employee> searchByLevelAndGender(List<Employee> employees, int level, Gender gender) {
		return (employees.stream().filter(emp->emp.getLevel() == level && emp.getGender() == gender).collect(Collectors.toList()));
	}
}
