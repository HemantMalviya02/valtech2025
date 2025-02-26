<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
counters = ${counters}
Current Employee = ${current}
<form action="depts" method="post">
<table>
<tr>
	<td>Id</td>
	<td>${dept.id}</td>
</tr>
<tr>
	<td>Name</td>
	<td>${dept.name}</td>
</tr>
<tr>
	<td>Location</td>
	<td>${dept.location}</td>
</tr>

<tr>
	<td colspan="2">
		<!-- <input type="submit" name="operation" value="New"/>
		<input type="submit" name="operation" value="Update"/>
		<input type="submit" name="operation" value="Delete"/> -->
		
		<input type="submit" name="operation" value="First"/>
		<input type="submit" name="operation" value="Previous"/>
		<input type="submit" name="operation" value="Next"/>
		<input type="submit" name="operation" value="Last"/>
	</td>
</tr>

<tr>
<td>Name</td>
<td><input type="text" name="name"/></td>
</tr>

<tr>
<td>Age</td>
<td><input type="text" name="age"/></td>
</tr>

<tr>
<td>Salary</td>
<td><input type="text" name="salary"/></td>
</tr>

<tr>
<td>Experience</td>
<td><input type="text" name="experience"/></td>
</tr>

<tr>
<td>Level</td>
<td><input type="text" name="level"/></td>
</tr>

<!-- <tr>
	<td>Sal Greater</td>
	<td><input type="text" name="salGreater"/></td>
</tr>
<tr>
	<td>Sal Smaller</td>
	<td><input type="text" name="salSmaller"/></td>
</tr> -->

<tr>
	<td><input type="submit" value="search" name="operation"/></td>
</tr>


<tr>
	<th>Id <a href="depts?sortBy=id&&sortType=asc">asc</a> <a href="depts?sortBy=id&&sortType">dsc</a></th>
	<th>Name <a href="depts?sortBy=name&&sortType=asc">asc</a> <a href="depts?sortBy=name&&sortType">dsc</a></th>
	<th>Age <a href="depts?sortBy=age&&sortType=asc">asc</a> <a href="depts?sortBy=age&&sortType">dsc</a></th>
	<th>Gender <a href="depts?sortBy=gender&&sortType=asc">asc</a> <a href="depts?sortBy=gender&&sortType">dsc</a></th>
	<th>Salary <a href="depts?sortBy=salary&&sortType=asc">asc</a> <a href="depts?sortBy=salary&&sortType">dsc</a></th>
	<th>Experience <a href="depts?sortBy=experience&&sortType=asc">asc</a> <a href="depts?sortBy=experience&&sortType">dsc</a></th>
	<th>Level <a href="depts?sortBy=level&&sortType=asc">asc</a> <a href="depts?sortBy=level&&sortType">dsc</a></th>
	<th>DeptId</th>
	
</tr>

<c:forEach items="${employeeList}" var="e">

<tr>
	<td>${e.id}</td>
	<td>${e.name}</td>
	<td>${e.age}</td>
	<td>${e.gender}</td>
	<td>${e.salary}</td>
	<td>${e.experience}</td>
	<td>${e.level}</td>
	<td>${e.deptId}</td>
</tr>
</c:forEach>

</table>
</form>
</body>
</html>