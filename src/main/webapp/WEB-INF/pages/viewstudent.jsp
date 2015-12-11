<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Student</title>
	<style>
		td, th{
			text-align:left;
			padding-right:30px;
		}
	</style>
</head>
<body>
	<c:set value="${requestScope.student }" var="student"></c:set>
	<h2>View Student</h2>
	<table>
		<tr>
			<th>Profile</th>
			<td><img src="${pageContext.request.contextPath}/${student.image }" alt=": ${student.image }"></td>
		</tr>
		<tr>
			<th>ID</th>
			<td>: ${student.id }</td>	
		</tr>
		<tr>
			<th>First Name</th>
			<td>: ${student.fname }</td>
		</tr>
		<tr>
			<th>Last Name</th>
			<td>: ${student.lname }</td>
		</tr>
		<tr>
			<th>Gender</th>
			<td>: ${student.gender }</td>
		</tr>
		<tr>
			<th>Age</th>
			<td>: ${student.age }</td>
		</tr>
		<tr>
			<th>Birth Date</th>
			<td>: ${student.birthdate }</td>
		</tr>
		<tr>
			<th>Register Date</th>
			<td>: ${student.rdate }</td>
		</tr>
	</table>
</body>
</html>