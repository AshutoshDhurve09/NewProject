<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1 align="center">UPDATE USER</h1>
	
			<center>
			<c:if test="${ employee.designation eq 'ADMINISTRATOR' }">
				 <a href="/user/add">Add User</a>
				<a href="/task/viewTask">View Task</a>
			</c:if>
			
			<c:if test="${ employee.designation eq 'PROJECT_MANAGER' }">
				<a href="/project/add">Add Project</a>
				<a href="/task/add">Add Task</a> 
				<a href="/task/viewTask">View Task</a>
			</c:if>
			</center>
	<table border="1" align="center">



		<spring:url value="/user/editUser" var="userAddUrl" />
		<form:form modelAttribute="use" action="${ userAddUrl }">

			<tr>
				<td><label> First Name: </label></td>
				<td><form:input path="firstName" value="" type="text" size="25" maxlength="50" class="field" /></td>
			</tr>
			<tr>
				<td><label>Last Name:</label></td>
				<td><form:input path="lastName"   value="" type="text" size="25" maxlength="50" class="field" /></td>
			</tr>
			<tr>
				<td><label>Employee ID:</label></td>
				<td><form:input path="employeeId"   value="" type="text" size="25" maxlength="50" class="field" /></td>
			</tr>

				<tr>	<td>Designation:</td>
					<td><form:select id="designation" path="designation">
							<form:options items=""/>							
 						</form:select></td>
				</tr> 

			<tr>
				<td>
				<input type="hidden" name="userId" value="${ use.userId }">
				<input type="submit" value="Add" /> 
				<input type="reset" value="Reset" /> 
				<input type="submit" name="submit" class="submit" value="Search" /> <!-- <input type="text" name="text" class="search" placeholder="Search Here" /> -->
				</td>
			</tr>


		</form:form>


	</table>
</body>
</html>