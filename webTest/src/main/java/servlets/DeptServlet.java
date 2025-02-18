package servlets;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import dao.Employee;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/depts")


public class DeptServlet extends HttpServlet {
	
	private DeptDAO deptDAO;
	List<Employee>employeeList;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		deptDAO = new DeptDAOImpl(config.getServletContext());
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String operation = req.getParameter("operation");
		
		String searchName = req.getParameter("name");
		String searchAge = req.getParameter("age");
		String searchSalary = req.getParameter("salary");
		String searchExperience = req.getParameter("experience");
		String searchLevel = req.getParameter("level");
//		String searchByGreaterSal = req.getParameter("salGreater");x
		
		if("Cancel".equals(operation)) {
			req.setAttribute("depts", deptDAO.getAll());
			req.getRequestDispatcher("Dept.jsp").forward(req, resp);
			return;
		}
//		Dept depts = Dept.builder()
//				.id(Integer.parseInt(req.getParameter("id")))
//				.name(req.getParameter("name"))
//				.location(req.getParameter("location"))
//				.build();
//		
//		if("Save".equals(operation)) {
//			deptDAO.save(depts);
//			req.setAttribute("emps", deptDAO.getAll());
//			req.getRequestDispatcher("Dept.jsp").forward(req, resp);
//			return;	
//		}
//		if("Update".equals(operation)) {
//			deptDAO.update(depts);
//			req.setAttribute("emps", deptDAO.getAll());
//			req.getRequestDispatcher("Dept.jsp").forward(req, resp);
//			return;
//		}
		
		HttpSession session = req.getSession();
		
		Dept current = (Dept) session.getAttribute("current");
		
		if(current == null)
				current = deptDAO.first();
		else 	
			
			if("First".equals(operation)) {
				current = deptDAO.first();   
			}else if("Last".equals(operation)){
				current = deptDAO.last();
			}else if("Previous".equals(operation)) {
				current = deptDAO.previous(current.getId());
			}else if("Next".equals(operation)){
				current = deptDAO.next(current.getId());
			}
		session.setAttribute("current", current);
		// expression in jsp can work with objects in session also...
		req.setAttribute("dept", current);
		
		
		employeeList = deptDAO.setDept(current.getId());
//		req.setAttribute("employeeList", employeeList);
		
		if("search".equals(operation)) {
			if(searchName != null) {
				employeeList = employeeList.stream().filter(employee->employee.getName().toLowerCase().contains(searchName.toLowerCase())).toList();
			}
			
			if(!searchAge.isEmpty()) {
				if(searchAge.charAt(0)=='>'){
					employeeList = employeeList.stream().filter(employee->employee.getAge() > Integer.parseInt(searchAge.substring(1))).toList();
				}
				else if(searchAge.charAt(0)=='<') {
					employeeList = employeeList.stream().filter(employee->employee.getAge() < Integer.parseInt(searchAge.substring(1))).toList();
				}
				else {
				employeeList = employeeList.stream().filter(employee->employee.getAge() == Integer.parseInt(searchAge)).toList();
				}
			}
			
			if(!searchSalary.isEmpty()) {
				if(searchSalary.charAt(0) == '>') {
					employeeList = employeeList.stream().filter(employee->employee.getSalary() > Integer.parseInt(searchSalary.substring(1))).toList();
				}
				else if(searchSalary.charAt(0) == '<') {
					employeeList = employeeList.stream().filter(employee->employee.getSalary() > Integer.parseInt(searchSalary.substring(1))).toList();
				}
				else {
				employeeList = employeeList.stream().filter(employee->employee.getSalary() == Integer.parseInt(searchSalary)).toList();
				}
			}
			
			
			if(!searchExperience.isEmpty()) {
				if(searchExperience.charAt(0) == '>') {
					employeeList = employeeList.stream().filter(employee->employee.getExperience() > Integer.parseInt(searchExperience.substring(1))).toList();
				}
				else if(searchExperience.charAt(0) == '>') {
					employeeList = employeeList.stream().filter(employee->employee.getExperience() < Integer.parseInt(searchExperience.substring(1))).toList();
				}
			else {
				employeeList = employeeList.stream().filter(employee->employee.getExperience() == Integer.parseInt(searchExperience)).toList();
			}
			}
			if(!searchLevel.isEmpty()) {
				if(searchLevel.charAt(0) == '>') {
				employeeList = employeeList.stream().filter(employee->employee.getLevel() > Integer.parseInt(searchLevel.substring(1))).toList();
			}
				else if(searchLevel.charAt(0) == '<')  {
					employeeList = employeeList.stream().filter(employee->employee.getLevel() < Integer.parseInt(searchLevel.substring(1))).toList();
				}
				else {
				employeeList = employeeList.stream().filter(employee->employee.getLevel() == Integer.parseInt(searchLevel)).toList();
				}
			}
			
//			if(!searchByGreaterSal.isEmpty()) {
//				employeeList = employeeList.stream().filter(employee->employee.getSalary() > Integer.parseInt(searchByGreaterSal)).toList();
//			}
//			if(!searchBySmallerSal.isEmpty()) {
//				employeeList = employeeList.stream().filter(employee->employee.getSalary() < Integer.parseInt(searchBySmallerSal)).toList();
//			}
			
		}
		
		Cookie [] cookies = req.getCookies();
		for(int i=0; i<cookies.length; i++) {
			System.out.println(cookies[i].getName()+" "+cookies[i].getValue());
		}
		resp.addCookie(new Cookie("operation", operation));
		
//		req.setAttribute("employeeList", deptDAO.setDept(current.getId()));
		
		req.setAttribute("employeeList", employeeList);
		req.getRequestDispatcher("Dept.jsp").forward(req, resp);
	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String operation = req.getParameter("operation");
		System.out.println("op :  "+operation);
		String sortBy = req.getParameter("sortBy");
		String sortType = req.getParameter("sortType");
		
		HttpSession session = req.getSession();
		
		Dept current ;
		if(operation == null && sortBy == null ) {
			current = deptDAO.first();
			session.setAttribute("current", current);
		}
		
		else{
			current = (Dept) session.getAttribute("current");
			if(current == null)
				current = deptDAO.first();
		}

		
		if("Update".equals(operation)) {
			int id = Integer.parseInt(req.getParameter("id"));
			Dept d = deptDAO.getDept(id);
			req.setAttribute("dept", d);
			req.setAttribute("mode", "Update");
			req.setAttribute("readonly", "readonly");
			req.getRequestDispatcher("editDepartment.jsp").forward(req, resp);
			return;
		}
		
		if("Delete".equals(operation) ) {
			int id = Integer.parseInt(req.getParameter("id"));
			deptDAO.delete(id);
			req.setAttribute("dept", deptDAO.getAll());
			req.getRequestDispatcher("Dept.jsp").forward(req, resp);
			return;
		}
		
		if("new".equals(operation)) {
			req.setAttribute("mode", "Save");
			req.getRequestDispatcher("editDepartment.jsp").forward(req, resp);
			return;
		}
		
//		Initially it will show first data
//		req.setAttribute("dept", deptDAO.first());
		req.setAttribute("dept", current);
		
//		HttpSession session = req.getSession();
//		session.setAttribute("current", deptDAO.first());
		
//		employeeList = deptDAO.setDept(deptDAO.first().getId());

		employeeList = deptDAO.setDept(current.getId());
		
		System.out.println("employeeList in setDept:: "+employeeList);
		req.setAttribute("employeeList", employeeList);
		

	
		System.out.println(sortBy);
		
		if("id".equals(sortBy)) {
			if("asc".equals(sortType)) {
				List<Employee> sortedByIdAsc = employeeList
											   .stream()
											   .sorted((Employee e1, Employee e2) -> Long.compare(e1.getId(), e2.getId())) 
//											   .sorted((Employee e1, Employee e2) -> e1.getId().compareTo(e2.getId())
//											   .sorted(Comparator.comparing(Employee::getId))
											   .collect(Collectors.toList());
											   req.setAttribute("employeeList", sortedByIdAsc);
											   
//											   System.out.println("sortedByIdAsc" + sortedByIdAsc);
			}
			else {
				List<Employee> sortedByIdDsc = employeeList
											   .stream()
											   .sorted((Employee e1, Employee e2) -> Long.compare(e2.getId(), e1.getId()))
											   .collect(Collectors.toList());
											   req.setAttribute("employeeList", sortedByIdDsc);
			}
		}
		
		if("name".equals(sortBy)) {
			if("asc".equals(sortType)) {
				List<Employee> sortedByNameAsc = employeeList
						 						.stream()
						 						.sorted((Employee e1, Employee e2) -> e1.getName().compareTo(e2.getName()))
						 						.collect(Collectors.toList());
				req.setAttribute("employeeList", sortedByNameAsc);
				
//				System.out.println("sortedByNameAsc" + sortedByNameAsc);
			}
			else {
				List<Employee> sortedByNameDsc = employeeList
						 .stream()
						 .sorted((Employee e1, Employee e2) -> e2.getName().compareTo(e1.getName()))
						 .collect(Collectors.toList());
				req.setAttribute("employeeList", sortedByNameDsc);
				
//				System.out.println("sortedByNameDsc" + sortedByNameDsc);
			}
			
		}
		
		if("age".equals(sortBy)) {
//			System.out.println("************************");
			if("asc".equals(sortType)) {
//				System.out.println("-------------------------------");
				List<Employee> sortedByAgeAsc = employeeList
												.stream()
												.sorted(Comparator.comparingInt(Employee::getAge))
												.collect(Collectors.toList());
				System.out.println("sortedByAgeAsc" + sortedByAgeAsc);
				req.setAttribute("employeeList", sortedByAgeAsc);
			}
			else {
				List<Employee> sortedByAgeDesc = employeeList
												 .stream()
												 .sorted((Comparator.comparingInt(Employee::getAge).reversed()))
												 .collect(Collectors.toList());
				req.setAttribute("employeeList", sortedByAgeDesc);
			}
		}
		
		if("gender".equals(sortBy)) {
			if("asc".equals(sortType)) {
				List<Employee> sortedByGenderAsc = employeeList
												   .stream()
												   .sorted((Comparator.comparing(Employee::getGender)))
												   .collect(Collectors.toList());
				req.setAttribute("employeeList", sortedByGenderAsc);
			}
			else {
				List<Employee> sortedByGenderDsc = employeeList
						   						   .stream()
						   						   .sorted((Comparator.comparing(Employee::getGender).reversed()))
						   						   .collect(Collectors.toList());
				req.setAttribute("employeeList", sortedByGenderDsc);
			}
		}
		
		if("salary".equals(sortBy)) {
			if("asc".equals(sortType)) {
				List<Employee> sortedBySalaryAsc = employeeList
											   .stream()
											   .sorted((Employee e1, Employee e2) -> Double.compare(e1.getSalary(), e2.getSalary())) 
											   .collect(Collectors.toList());
											   req.setAttribute("employeeList", sortedBySalaryAsc);
			}
			else {
				List<Employee> sortedBySalaryDsc = employeeList
											   .stream()
											   .sorted((Employee e1, Employee e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
											   .collect(Collectors.toList());
											   req.setAttribute("employeeList", sortedBySalaryDsc);
			}
		}
		
		if("experience".equals(sortBy)) {
			if("asc".equals(sortType)) {
				List<Employee> sortedByExpAsc = employeeList
												.stream()
												.sorted(Comparator.comparingInt(Employee::getExperience))
												.collect(Collectors.toList());
				req.setAttribute("employeeList", sortedByExpAsc);
			}
			else {
				List<Employee> sortedByExpDesc = employeeList
												 .stream()
												 .sorted((Comparator.comparingInt(Employee::getExperience).reversed()))
												 .collect(Collectors.toList());
				req.setAttribute("employeeList", sortedByExpDesc);
			}
		}
	
		if("level".equals(sortBy)) {
			if("asc".equals(sortType)) {
				List<Employee> sortedByLevelAsc = employeeList
												.stream()
												.sorted(Comparator.comparingInt(Employee::getLevel))
												.collect(Collectors.toList());
				req.setAttribute("employeeList", sortedByLevelAsc);
			}
			else {
				List<Employee> sortedByLevelDesc = employeeList
												 .stream()
												 .sorted((Comparator.comparingInt(Employee::getLevel).reversed()))
												 .collect(Collectors.toList());
				req.setAttribute("employeeList", sortedByLevelDesc);
			}
		}
		
		
		session.setAttribute("current", current);
		
		req.getRequestDispatcher("Dept.jsp").forward(req, resp);
	}
}
