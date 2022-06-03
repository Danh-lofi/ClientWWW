<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>List Customers</title>
		<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/bootstrap.min.css"/>
		<script src="${pageContext.request.contextPath }/resources/js/bootstrap.min.js"></script>
	</head>
	<body>
		<div class="container">
			<div class="bg-primary">
				<h1 class="text-light text-center font-weight-bold">CRM - CUSTOMER Relationship Manager</h1>
			</div>
			
			<div class="content">
				<input type="button" value="Add Customer" class="btn btn-info mb-2"
						onclick="window.location.href='showFormForAdd'; return false;">
				
				<table class="table table-striped">
					<tr>
						<th scope="col">First Name</th>
						<th scope="col">Last Name</th>
						<th scope="col">Email</th>
						<th scope="col">Action</th>
					</tr>
					
					<c:forEach var="tempCustomer" items="${customers }">
						<c:url var="loadUpdateLink" value="showFormForUpdate">
							<c:param name="customerId" value="${tempCustomer.id }"/>
						</c:url>
						
						<c:url var="deleteLink" value="delete">
							<c:param name="customerId" value="${tempCustomer.id }"/>
						</c:url>
						
						<tr>
							<td>${tempCustomer.firstName }</td>
							<td>${tempCustomer.lastName }</td>
							<td>${tempCustomer.email }</td>
							<td>
								<a class="btn btn-primary" href="${loadUpdateLink }">UPDATE</a>
							<a class="btn btn-danger" href="${deleteLink}"
							onclick= "if(!(confirm('Are you sure you want delete this student?'))) return false;">DELETE</a>
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</body>
</html>