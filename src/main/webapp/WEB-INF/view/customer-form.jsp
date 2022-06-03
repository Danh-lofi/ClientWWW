<%@page import="javax.servlet.jsp.tagext.Tag"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>ADD CUSTOMER</title>
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/bootstrap.min.css"/>
	<script src="${pageContext.request.contextPath }/resources/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="bg-primary">
				<h1 class="text-light text-center font-weight-bold">CRM - CUSTOMER Relationship Manager</h1>
		</div>
		
		<form:form action="saveCustomer" modelAttribute="customer" method="GET">
			<form:hidden path="id"/>
			<table>
				<tr>
					<td>First Name: </td>
					<td><form:input path="firstName" value="${customer.firstName }"/></td>
				</tr>
				
				<tr>
					<td>Last Name: </td>
					<td><form:input path="lastName" value="${customer.lastName }"/></td>
				</tr>
				
				<tr>
					<td>Email: </td>
					<td><form:input path="email" value="${customer.email }"/></td>
				</tr>
				
				<tr>
					<td></td>
					<td><input type="submit" value="Save" class="btn btn-primary"></td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>