<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="item" method="post">
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
			<td>Description</td>
			<td><input type="text" name="description"/></td>
		</tr>
		<tr>
			<td>Reorder Quantity</td>
			<td><input type="text" name="reOrderQuantity"/></td>
		</tr>
		<tr>
			<td>Max Address</td>
			<td><input type="text" name="maxQuantity"/></td>
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