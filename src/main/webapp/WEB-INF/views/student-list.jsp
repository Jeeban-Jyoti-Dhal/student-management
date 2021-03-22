<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2 align="center" style="color: olive;">Student Lists</h2>
	<hr>
	
	<div align="center">
	<p style="font-family: inherit; color: red;">Add Your details here, If you are New</p>
	<a href="addStudent">Add</a>
	
		<table border="2" cellspacing="5" cellpadding="4">

			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Mobile</th>
				<th>Country</th>
			</tr>


			<c:forEach items="${students}" var="students">
				<tr>
					<td>${students.id}</td>
					<td>${students.name}</td>
					<td>${students.mobile}</td>
					<td>${students.country}</td>
					<td> <a href="updateStudent?id=${students.id}">Update</a> </td>
					<td><a href="deleteStudent?id=${students.id}" onclick="if(!(confirm('Are you sure?you  want to delete it'))) return false">Delete</a></td>
				</tr>
			</c:forEach>

		</table>
	</div>

</body>
</html>