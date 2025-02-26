<%@page import="dao.Employee"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table>
	<tr>
		<th>Id</th>
		<th>Name</th>
		<th>Age</th>
		<th>Gender</th>
		<th>Salary</th>
		<th>Experience</th>
		<th>Level</th>
		<th>Actions</th>
	</tr>
	<c:forEach items="${emps}" var="e">
	<tr>
		<td>${e.id}</td>
		<td>${e.name}</td>
		<td>${e.age}</td>
		<td>${e.gender}</td>
		<td>${e.salary}</td>
		<td>${e.experience}</td>
		<td>${e.level}</td>
		
		<td>
			<a href="employees?operation=Update&id=${e.id}">Update</a>
			<a href="employees?operation=Delete&id=${e.id}">Delete</a>
		</td>
	</tr>
	</c:forEach>
	<tr>
		<td colspan="7">
			<a href="employees?operation=new">New Employee</a>
	</tr>
	
	</table>


<table>
<tr>
	<th>Id</th>
	<th>Name</th>
	<th>Age</th>
	<th>Gender</th>
	<th>Salary</th>
	<th>Experience</th>
	<th>Level</th>
</tr>
<%
	List<Employee> emps = (List<Employee>) request.getAttribute("emps");
	for(Employee e : emps) {
		
%>
	<tr>
		<td>
			<%= e.getId() %>
		</td>
		<td>
			<%= e.getName() %>
		</td>
		<td>
			<%= e.getAge() %>
		</td>
		<td>
			<%= e.getGender() %>
		</td>
		<td>
			<%= e.getSalary() %>
		</td>
		<td>
			<%= e.getExperience() %>
		</td>
		<td>
			<%= e.getLevel() %>
		</td>
	</tr>
	
<% } %>
</table>

</body>
</html>