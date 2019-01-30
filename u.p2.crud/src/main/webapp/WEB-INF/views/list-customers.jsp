<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List Customer</title>
<%@ page isELIgnored="false" %>
</head>
<body>
	<h2>CRM - Customer Relationship Manager</h2>
	<input type="button" value="Add Customer"
		onclick="window.location.href='showForm'; return false;" />
	<br>
	<h2>Message from server</h2>
	<h2>${test}</h2>
	<h2>
		<c:out value="${test}" />
	</h2>
	<table>
		<tr>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Email</th>
			<th>Action</th>
		</tr>

		<c:forEach items="${Customers}" var="customer">

			<c:url var="updateLink" value="/customer/edit">
				<c:param name="customerId" value="${tempCustomer.id}" />
			</c:url>
			<c:url var="deleteLink" value="/customer/delete">
				<c:param name="customerId" value="${tempCustomer.id}" />
			</c:url>

			<tr>
				<td>${customer.firstName}</td>
				<td>${customer.lastName}</td>
				<td>${customer.email}</td>
				<td><a href="${updateLink}">Update</a> | <a
					href="${deleteLink}"
					onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a></td>
			</tr>

		</c:forEach>
	</table>
</body>
</html>