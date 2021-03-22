<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="grey">
	<form:form modelAttribute="student" action="studentSaved" method="POST">
		<div align="center">
		
		<h1>Add Student</h1>
		<hr>
			<table>
			<tr>
					<td><form:hidden path="id" /></td>
				</tr>
			
				<tr>
					<td><b>Name ::</b></td>
					<td><form:input path="name" placeholder="your name" /></td>
				</tr>

				<tr>
					<td><b>Mobile :: </b></td>
					<td><form:input path="mobile" /></td>
				</tr>

				<tr>
					<td><b>Country ::</b></td>
					<td><form:input path="country" /></td>
				</tr>

				<tr>
					<td></td>
					<td align="center"><input type="submit" value="Add"></td>
				</tr>
			</table>
		</div>
	</form:form>
</body>
</html>