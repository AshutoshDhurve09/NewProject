<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
			<c:if test="${not empty employee.userName}">
				<c:url value="/employee/logout" var="logOutUrl" scope="session"/>
					
				
				
				<a href="${ session.logOutUrl }">Logout</a>
			</c:if>
			</center>

	<table border="1" align="center">
		<h1>
			<center>UPDATE PROJECT</center></h1>
			
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
		
		<spring:url value="/project/editproject" var="projectAddUrl" />
		<form:form modelAttribute="proj" action="${ projectAddUrl }">
			<tr>
				<td><label>Project Name:</label></td>
				<td><form:input type="text" path="projectName" id="projectname" /><br />
				</td>
			</tr>
			<%-- <form:checkbox path="checkDate" /> --%>
			<tr>
				<td><label>Start Date</label></td>
				<td><form:input type="text"  path="startDate" id="startdate" name="startDate" /></td>
			</tr>
			<tr>
				<td><label>End Date</label></td>
				<td><form:input type="text" path="endDate" name="endDate"/><br />
				</td>
			</tr>
			<tr>
				<td><label>Priority</label></td>
				<td><form:input type="range" path="priority" maxlength="100" /><br /></td>
			</tr>
			<tr>
				<td><label>Manager</label></td>
				<td><input type="text" name="managerName" value="${ sessionScope.employee.userName }" readonly="readonly"> <span id="merror" style="color: red">*</span><br />
				</td>
			</tr>
			<tr>
				<td><input type="hidden" name="projectId" value="${ proj.projectId }"> 
				<input type="submit" value="Update"> <input type="reset" value="RESET"></td>
			</tr>


		</form:form>
	</table>

</body>
</html>