<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Java Training</title>
</head>
<body>

<form action="employees" method="post">

	<table>
		<tr>
			<td>Id</td>
			<td><input type="text" name="id" value="${emp.id}" ${readonly}/></td>
		</tr>
		<tr>
			<td>Name</td>
			<td><input type="text" name="name" value="${emp.name}"/></td>
		</tr>
		<tr>
			<td>Age</td>
			<td><input type="text" name="age" value="${emp.age}"/></td>
		</tr>
		<tr>
			<td>Gender</td>
			<td><input type="text" name="gender" value="${emp.gender}" ${readonly}/></td>
		</tr>
		<tr>
			<td>Salary</td>
			<td><input type="text" name="salary" value="${emp.salary}"/></td>
		</tr>
		<tr>
			<td>Experience</td>
			<td><input type="text" name="experience" value="${emp.experience}"/></td>
		</tr>
		<tr>
			<td>Level</td>
			<td><input type="text" name="level" value="${emp.level}"/></td>
		</tr>
		<tr>
			<td>deptId</td>
			<td><input type="text" name="deptId" value="${emp.deptId}"/></td>
		</tr>
		
		<tr>
			<td colspan="2">
				<input type="submit" name="operation" value='${mode}' />
				<input type="submit" name="operation" value="Cancel" />
			</td>
		</tr>
		
	</table>
</form>

</body>
</html>