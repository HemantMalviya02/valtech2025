<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Item Data</title>
</head>
<body>
<form action="items" method="post">
	<table>
		<tr>
			<td>Id</td>
			<td><input name="id" id="id" value="0" hidden="true"/></td>
		</tr>
		<tr>
			<td>name</td>
			<td><input name="name" id="name"/></td>
		</tr>
		<tr>
			<td>descItem</td>
			<td><input name="descItem" id="descItem"/></td>
		</tr>
		<tr>
			<td>currentQuantity</td>
			<td><input name="currQuantity" id="currQuantity"/></td>
		</tr>
		<tr>
			<td>reorderQuantity</td>
			<td><input name="reorderQuantity" id="reorderQuantity"/></td>
		</tr>
		<tr>
			<td>maximumQuantity</td>
			<td><input name="maxQuantity" id="maxQuantity"/></td>
		</tr>
		<tr>
			<td><input name="submit" type="submit" value="submit"/></td>
			<td><input name="cancel" type="submit" value="cancel"/></td>
		</tr>
	</table>
</form>
</body>
</html>