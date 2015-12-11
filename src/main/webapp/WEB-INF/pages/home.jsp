<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
<link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet">
	<style>
		img{
			width:30px;
			heigth:auto;
		}
	</style>
</head>
<body>
<h1 id="header">Student List</h1>
	<h3><a href='formstudent'>Add Student</a></h3>
	
	<c:set value="${student }" var="students"></c:set>
	<table>
		<tr>
			<th>Profile</th>
			<th>Lastname</th>
			<th>Firstname</th>
			<th>Gender</th>
			<th>Action</th>
		</tr>
		<c:forEach items="${students }" var="student">
			<tr>
				<td><img src='${student.image }'/></td>
				<td>${student.lname }</td>
				<td>${student.fname }</td>
				<td>${student.gender }</td>
				<td><a id='view' href='viewstudent?id=${student.id }'>View</a><a id='edit' href="editstudent?id=${student.id }">Edit</a><a id='delete' href="delete?id=${student.id }">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>