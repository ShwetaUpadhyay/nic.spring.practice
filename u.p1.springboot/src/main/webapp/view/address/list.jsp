<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Address List</title>
	<link rel="stylesheet" href="../css/stylesheet.css">
</head>
<body>
	<div class="main-div">
		<div class="list">
			<div class="table-heading frame">
				<h2>Address List</h2>
			</div>
			<div class="table-list frame">
				<table border="1" >
					<thead>
						<tr>
							<th>Country</th>
							<th>State</th>
							<th>City</th>
							<th>User</th>
							<th>Edit</th>
							<th>Delete</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${addresses}" var="address">
							<tr>
								<td>${address.country}</td>
								<td>${address.state}</td>
								<td>${address.city}</td>
								<td>${address.user.userName}</td>
								<td><a href="${path}/address/edit/${address.id}">Edit</a>
								<td><a href="${path}/address/delete/${address.id}">Delete</a>
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