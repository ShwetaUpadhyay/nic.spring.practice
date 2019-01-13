<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>User List</title>
	<link rel="stylesheet" href="../css/stylesheet.css">
</head>
<body>
	<div class="main-div">
		<div class="list">
			<div class="table-heading frame">
				<h2>User List</h2>
			</div>
			<div class="table-list frame">
				<table border="1">
					<thead>
						<tr>
							<th>User ID</th>
							<th>User Name</th>
							<th>Password</th>
							<th>Edit</th>
							<th>Delete</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${users}" var="user">
							<tr>
								<td>${user.userId}</td>
								<td>${user.userName}</td>
								<td>${user.password}</td>
								<td><a href="${path}/user/edit/${user.id}">Edit</a>
								<td><a href="${path}/user/delete/${user.id}">Delete</a>
							</tr>
						</c:forEach>
					</tbody>
				</table>	
			</div>
			<div class="home-link frame">
				<a href="${path}/">Welcome</a>
			</div>
		</div>
	</div>
</body>
</html>