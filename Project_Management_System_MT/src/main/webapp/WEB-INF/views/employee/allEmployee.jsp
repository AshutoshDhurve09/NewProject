<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<link rel="stylesheet" href="/resources/loginForm/css/style.css">
<center>
<c:import url="home.jsp"/><br>
<spring:url value="/user/search" var="searchUrl"/>
	<form:form action="${ searchUrl }" method="POST">
	<center>
	<input type="text" id="searchproject" name="searchName"	placeholder="Search" required="required"> 
	<input type="submit" value="FirstName"><br><br>
	<label>Sort:</label>
	<a href="/user/sortonfirstname"><input type="button" value="FirstName"></a>
	<a href="/user/sortbylastname"><input type="button" value="LastName"></a>
	<a href="/user/sortbyid"><input type="button" value="ID"></a>
	</center>
</form:form>
<form action="/user/showEditUser" method="post" modelAttribute="use">
		<br> <br>
		<table border="1" align="center" cellpadding="5" cellspacing="5"> 
	
			<tbody>
				
				<tr>
					<th>EmployeeName</th>
					<th>EmailId</th>
					<th>Password</th>
					<th>Role</th>
					<th>Company Name</th>
					<th>Action</th>
					</tr>
					
				<c:forEach items="${employees}" var="u">
					
					
						<tr>
						
						<td><c:out value="${ u.employeeName }"></c:out></td>
						
						<td><c:out value="${ u.emailId }"></c:out></td>
						
						<td><c:out value="${ u.password }"></c:out></td>
						
						<td><c:out value="${ u.designation }"></c:out></td>
						
						<td><c:out value="${u.company }"></c:out></td>
						
						
						<td>
						<input type="hidden" name="uId" value="${ u.employeeId }">
						<input type="submit"  name="action" value="Edit"><br>
	                    <input type="submit"  name="action" value="delete"></td>


					</tr>
				</c:forEach>
			</tbody>
		</table>
	</form>


</body>
</html>