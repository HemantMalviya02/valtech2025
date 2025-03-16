<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register Customer</title>
</head>
<body>
<form action="register" method="post">
	<table>
		<tr>
			<td>Id</td>
			<td><input name="id" id="id"/></td>
		</tr>
		
		<tr>
			<td>name</td>
			<td><input name="name" id="name"/></td>
		</tr>	
		<tr>
			<td>age</td>
			<td><input name="age" id="age"/></td>
		</tr>
		<tr>
			<td>address</td>
			<td><input name="address" id="address"/></td>
		</tr>
		<tr>
			<td>permanentAddress</td>
			<td><input name="permanentAddress" id="permanentAddress"/></td>
		</tr>
		<tr>
			<td><input name="submit" type="submit" value="Submit"/></td>
			<td><input name="cancel" type="submit" value="Cancel"/></td>
		</tr>
	</table>
</form>
</body>
</html>