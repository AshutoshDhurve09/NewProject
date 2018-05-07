<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
            
			<center>
			<c:if test="${ employee.designation eq 'ADMINISTRATOR' }">
				 <a href="/user/add">Add User</a>
				<a href="/task/viewTask">View Task</a>
				<a href="/employee/logout" scope="session"/>logout</a>
					<%-- <a href="${ session.logOutUrl }">Logout</a> --%>
			</c:if>
			
			<c:if test="${ employee.designation eq 'PROJECT_MANAGER' }">
				<a href="/project/add">Add Project</a>
				<a href="/task/add">Add Task</a> 
				<a href="/task/viewTask">View Task</a>
				<a href="/employee/logout" scope="session"/>logout</a>
			</c:if>
			</center>
			<center>
			<c:if test="${not empty employee.userName}">
				<%-- <c:url value="/employee/logout" var="logOutUrl" scope="session"/>
					<a href="${ session.logOutUrl }">Logout</a> --%>
			</c:if>
			</center>
</body>
</html>