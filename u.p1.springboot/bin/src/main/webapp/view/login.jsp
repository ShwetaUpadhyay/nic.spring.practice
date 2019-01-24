<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Login</title>
</head>
<body>
	<div class="main-div">
		<div class="frame">
			<h1>Please Login Here</h1>
		</div>
		<div class="frame">
			<p>${error}</p>
			<p>${message}</p>
			<form action="${path}/user/login" method="post" class="form-signin">
				<table>
					<tbody>
						<tr>
							<td>Username</td>
							<td><input type="text" name="username" placeholder="Enter User Name"/></td>
						</tr>
						<tr>
							<td>Password</td>
							<td><input type="password" name="password" placeholder="Enter your password"/></td>
						</tr>
						<tr>
							<td colspan="2"><input type="submit" value="Login"/></td>
						</tr>
					</tbody>
				</table>
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			</form>
		</div>
	</div>
</body>
</html>