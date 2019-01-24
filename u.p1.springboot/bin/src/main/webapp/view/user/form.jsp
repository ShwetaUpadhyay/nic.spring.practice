<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>User List</title>
	<link rel="stylesheet" href="../css/stylesheet.css">
</head>
<body>
	<div class="main-div frame">
		<header>
			<h2>User Form</h2>
		</header>
		<div class="form-div">
			<form:form method="post" action="${path}/user/add" modelAttribute="userForm">
			<form:hidden path="id"/>
				<table>
					<tr>
						<td align="right">User ID</td>
						<td><form:input path="userId" placeholer="Enter User ID"/></td>
					</tr>
					<tr>
						<td align="right">User Name</td>
						<td><form:input path="userName" placeholer="Enter User Name"/></td>
					</tr>
					<tr>
						<td align="right">Password</td>
						<td><form:password path="password" placeholer="Enter User Password"/></td>
					</tr>
					<tr>
						<td align="right">Role</td>
						<td>
							<form:select path="${role.id}">
								<c:forEach items="${roles}" var="role">
									<form:option value="${role.id}">${role.name}</form:option>
								</c:forEach>
							</form:select>
						</td>
					</tr>
					<tr>
						<td colspan="2"><form:button value="Save">Save</form:button></td>
						<td><a href="${path}/user/list">List User</a></td>
					</tr>
				</table>
			</form:form>
		</div>
		<div class="home-link">
				<p><a href="${path}/user/list">User List</a></p>
			</div>
	</div>
</body>
</html>