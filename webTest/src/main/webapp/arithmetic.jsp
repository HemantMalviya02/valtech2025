<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Java Training</title>
</head>
<body>
<h2>
Welcome <%= request.getAttribute("username") %> you are registered as a 
<%= request.getAttribute("role") %><br/>
</h2>

A = <%= request.getParameter("a") %> <br/>
B = <%= request.getParameter("b") %> <br/>
Operation = <%= request.getParameter("operation") %><br/>
Result = <%= request.getAttribute("result") %><br/>
<form action="arithmetic" method="post">
	A = <input type="text" name="a" /><br>
	B = <input type="text" name="b" />
	<input type="submit" name="operation" value="Add" />
	<input type="submit" name="operation" value="Sub" />
	<input type="submit" name="operation" value="Mul" />
	<input type="submit" name="operation" value="Div" />
</form>
</body>
</html>