<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Student</title>
	<style>
		td, th{
			text-align:left;
			padding-right: 20px;
		}
	</style>
</head>
<body>
	<c:choose>
		<c:when test="${status==1 }">
			<h1>Update Student</h1>
		</c:when>
		<c:otherwise>
			<h1>Add Student</h1>
		</c:otherwise>
	</c:choose>
	

	<table>
		<c:choose>
			<c:when test="${status==1 }">
				<form:form method="post" modelAttribute="student" action="updatestudent">
					<c:set value="${requestScope.onestudent }" var="one"></c:set>
				
					<form:input path="id" value="${param.id }" type="hidden"/>
					<tr>
						<th>Lastname</th>
						<td>: <form:input path="lname" value="${one.lname }"/></td>
					</tr>
					<tr>
						<th>Firstname</th>
						<td>: <form:input path="fname" value="${one.fname }"/></td>
					</tr>
					<tr>
						<th>Gender</th>
						<td>: <form:input path="gender" value="${one.gender }"/></td>
					</tr>
					<tr>
						<th>Age</th>
						<td>: <form:input path="age" value="${one.age }"/></td>
					</tr>
					<tr>
						<th>Birth Date</th>
						<td>: <form:input path="birthdate" value="${one.birthdate }"/></td>
					</tr>
					<tr>
						<th>Register Date</th>
						<td>: <form:input path="rdate" value="${one.rdate }"/></td>
					</tr>
					<tr>
						<th></th>
						<td>: <input type="submit" value="Update Student"></td>
					</tr>
				</form:form>	
			</c:when>
			<c:otherwise>
					<form:form method="post" modelAttribute="student" action="addstudentinfo">
						<tr>
							<th>Lastname</th>
							<td>: <form:input path="lname"/></td>
						</tr>
						<tr>
							<th>Firstname</th>
							<td>: <form:input path="fname"/></td>
						</tr>
						<tr>
							<th>Gender</th>
							<td>: <form:input path="gender"/></td>
						</tr>
						<tr>
							<th>Age</th>
							<td>: <form:input path="age"/></td>
						</tr>
						<tr>
							<th>Birth Date</th>
							<td>: <form:input path="birthdate"/></td>
						</tr>
						<tr>
							<th>Register Date</th>
							<td>: <form:input path="rdate"/></td>
						</tr>
						<tr>
							<th></th>
							<td>: <input type="submit" value="Add Student"></td>
						</tr>
					</form:form>
			</c:otherwise>
		</c:choose>
	
	</table>
</body>
</html>