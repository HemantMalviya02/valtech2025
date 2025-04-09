<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="custRegister" method="post">
	<table>
		<tr>
			<td>Id</td>
			<td><input type="text" name="id"/></td>
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
			<td>Address</td>
			<td><input type="text" name="address"/></td>
		</tr>
		<tr>
			<td>Permanent Address</td>
			<td><input type="text" name="perAddress"/></td>
		</tr>
		<tr>
			<td colspan="2">
			<input type="submit" name="submit" value="submit"/>
			<input type="submit" name="cancel" value = "cancel"/>
			</td>
		</tr>
	</table>
</form>
</body>
</html>