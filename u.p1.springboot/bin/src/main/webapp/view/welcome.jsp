<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Welcome</title>
	<link rel="stylesheet" href="css/stylesheet.css">
</head>
<body>
	<div class="frame">
		<c:if test="${pageContext.request.userPrincipal.name!=null}">
			<form method="post" id="logoutForm" action="${path}/Logout">
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			</form>
			<p>welcome ${pageContext.request.userPrincipal.name} | <a onclick="document.forms['logoutForm'].submit()">Logout</a>
		<p>${message}</p>
		<p>Path : ${path}"</p>
		<div class="home-link">
			<div class="hover-list-gap-fix"></div>
			<div class="hover-list">
				<div class="hover-list-item"><a href="${path}/user/form"><span class="list-link">Add User</span></a></div>
				<div class="hover-list-item"><a href="${path}/user/list"><span class="list-link">All Users</span></a></div>
			</div>
			<p>User</p>
		</div>
		<div class="home-link">
			<div class="hover-list-gap-fix"></div>
			<div class="hover-list">
				<div class="hover-list-item"><a href="${path}/address/list"><span class="list-link">All Addresses</span></a></div>
				<div class="hover-list-item"><a href="${path}/address/form"><span class="list-link">Add Address</span></a></div>
			</div>
			<p>Address</p>
		</div>
		</c:if>
	</div>
</body>
</html>