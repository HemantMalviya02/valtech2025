<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Change Password</title>
</head>
<body>
	<form action="changePassword" method="post">
		<table>
			<tr>
				<td>Current Password</td>
				<td><input name="currentPassword" type="password"/></td>
			</tr>
			<tr>
				<td>New Password</td>
				<td><input name="newPassword" type="password"/></td>
			</tr>
			<tr>
				<td>Confirm Password</td>
				<td><input name="confirmPassword" type="password"/></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="Change Password" />
				</td>
			</tr>
		</table>
	</form>
</body>
</html>