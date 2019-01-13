<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Add Address</title>
	<link rel="stylesheet" href="../css/stylesheet.css">
</head>
<body>
	<div class="main-div frame">
		<header>
			<h2>Address Form</h2>
		</header>
		<div class="form-div">
			<form:form method="post" action="${path}/address/add" modelAttribute="addressForm">
			<form:hidden path="id"/>
				<table>
					<tr>
						<td align="right">Country</td>
						<td><form:input path="Country" placeholer="Enter Country"/></td>
					</tr>
					<tr>
						<td align="right">State</td>
						<td><form:input path="State" placeholer="Enter State"/></td>
					</tr>
					<tr>
						<td align="right">City</td>
						<td><form:input path="City" placeholer="Enter City"/></td>
					</tr>
					<tr>
						<td>User</td>
						<td>
							<form:select path="user.id">
								<c:forEach items="${users}" var="user">
									<form:option value="${user.id}">${user.userName} - ${user.id}</form:option>
								</c:forEach> 
							</form:select>
						</td>
					</tr>
					<tr>
						<td colspan="2"><form:button value="Save">Save</form:button></td>
						<td><a href="${path}/address/list">List Address</a></td>
					</tr>
				</table>
			</form:form>
		</div>
		<div class="home-link">
				<p><a href="${path}/address/list">Address List</a></p>
			</div>
	</div>
</body>
</html>