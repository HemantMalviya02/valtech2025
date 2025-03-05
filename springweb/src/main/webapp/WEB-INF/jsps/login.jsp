<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<span style="color:red">${message}</span>

<form  method="post" action="login">
	<table>
		<tr>
			<td>Username</td>
			<td><input name="username" type="text"/></td>
		</tr>
		<tr>
			<td>Password</td>
			<td><input name="password" type="password"/></td>
		</tr>
		<tr>
			<td colspan="2">
				<input name="action" value="Login" type="submit" />
				<input name="action" value="Cancel" type="submit" />
			</td>
		</tr>
	</table>
</form>

</body>
</html>