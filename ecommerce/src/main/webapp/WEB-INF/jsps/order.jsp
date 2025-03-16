<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Orders</title>
</head>
<body>
<form action="orders" method="post">
	<table>
		<tr>
			<th>Id</th>
			<th>name</th>
			<th>descriptionOfItem</th>
			<th>currentQuantity</th>
			<th>reorderQuantity</th>
			<th>maximumQuantity</th>
		</tr>
		
		<c:forEach items="${item}" var="i">
			<tr>
				<td>${i.id}</td>
				<td>${i.name}</td>
				<td>${i.descItem}</td>
				<td>${i.currQuantity}</td>
				<td>${i.reorderQuantity}</td>
				<td>${i.maxQuantity}</td>
			</tr>
		</c:forEach>
	</table>
</form>
</body>
</html>