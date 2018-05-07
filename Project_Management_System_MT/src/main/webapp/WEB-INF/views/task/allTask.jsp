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
<center>
<a href="/task/home">HOME</a></center>

			<c:if test="${not empty employee.userName}">
				<c:url value="/employee/logout" var="logOutUrl" scope="session"/>
					
				
				
				<a href="${ session.logOutUrl }">Logout</a>
			</c:if>
			
<br>
<center><h3>VIEW TASK</h3></center>
<br>
	<spring:url value="/task/search" var="searchUrl" />
	<form:form action="${ searchUrl }" method="POST">
	<center>
		<label>Project:</label>
		<input type="text" id="searchtask" name="searchName" placeholder="Search" required="required" >
		<input type="submit" value="search">
		<label>Sort Task By</label>
		<a href="/task/sortonstartdate"><input type="button" value="Start-Date"></a>
		<a href="/task/sortonenddate"><input type="button" value="End-Date"></a>
		<a href="/task/sortbypriority"><input type="button" value="Priority"></a>
		<input type="button" value="Completed">
		<br>
		<br>
		</form:form>
		<label>..............................................................................................</label>
		</center>
		<form action="/task/showEditTask" method="post" modelAttribute="task">
		<table border="1" align="center">
			<thead>
				<tr>
					<th>Task</th>
					<th>Parent_Task</th>
					<th>Priority</th>
					<th>Start_Date</th>
					<th>End_Date</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${tasks}" var="t">
			<tr>
						
						<td>
						<c:out value="${ t.taskName }"></c:out>
						</td>
					
						<td>
						<c:out value="${ t.parentTaskId }"></c:out>
						</td>
						<td>
						<c:out value="${ t.priority }"></c:out>
						</td>
						 
						 <td>
						<c:out value="${ t.taskStartDate }"></c:out>
						</td>
					
						<td>
						<c:out value="${ t.taskEndDate }"></c:out>
						</td>
						

						<td>
						
						<form action="/task/showEditTask" method="post" modelAttribute="task">
						<input type="hidden" name="tId" value="${ t.taskId}">
						<input type="submit" action="action" value="Edit"> <br> <br>
						<input type="button" value="End-Task"></td>
						</form>

					</tr>
				</c:forEach>
			</tbody>
			


		</table>
</form>
	



</body>
</html>