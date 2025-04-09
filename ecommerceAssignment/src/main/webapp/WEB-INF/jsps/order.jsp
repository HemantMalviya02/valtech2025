<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix= "c" uri ="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="order" method="post">
<table>
<tr>
	<td>Id</td>
	<td></td>
	<td></td>
	<td>Name</td>
	<td></td>
	<td></td>
	<td>Description</td>
	<td></td>
	<td></td>
	<td>Quantity</td>
</tr>
<c:forEach items ="${items}" var="item">
<tr>
	<td>${item.id}</td>
	<td></td>
	<td></td>
	<td>${item.name}</td>
	<td></td>
	<td></td>
	<td>${item.description}</td>
	<td></td>
	<td></td>
</tr>
</c:forEach>
<tr>
	<td>Item Id</td>
	<td>Quantity</td>
	<td>Customer ID</td>
</tr>
<tr>
	<td><input type="text" name= "itemIds"></td>
	<td><input type="text" name= "quantity"></td>
	<td><input type="text" name= "custId"></td>
	<td colspan="2">
	<input type="submit" name="submit" value="submit"/>
</tr>
</table>
</form>
<table>
<tr>
<c:forEach items ="${itemIds}" var="ids" >
	
	<td>Id : "${ids}"</td>

</c:forEach>
<c:forEach items ="${itemQuantity}" var="qnt" >

	<td> Quantity :"${qnt}"</td>
</c:forEach>
</tr>
</table>
</body>
</html>