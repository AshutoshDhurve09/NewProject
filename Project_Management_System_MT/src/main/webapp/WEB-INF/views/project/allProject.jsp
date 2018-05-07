<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="false"%>
<%-- <%@ taglib uri="http://htmlcompressor.googlecode.com/taglib/compressor"	prefix="compress"%> --%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

</head>
<body>
<center>
<a href="/project/home">HOME</a></center>

			<c:if test="${not empty employee.userName}">
				<c:url value="/employee/logout" var="logOutUrl" scope="session"/>
					
				
				
				<a href="${ session.logOutUrl }">Logout</a>
			</c:if>
			
<br>
<br>
	<spring:url value="/project/search" var="searchUrl"/>
	<form:form action="${ searchUrl }" method="POST">
	<center>
		<input type="text" id="searchproject" name="searchName"	placeholder="Search" required="required"> 
		<input type="submit" value="Search">
		<label>Sort By</label>
		<a href="/project/sortonstartdate"><input type="button" value="Start-Date"></a>
		<a href="/project/sortonenddate"><input type="button" value="End-Date"></a>
		<a href="/project/sortbypriority"><input type="button" value="Priority"></a>
		<input type="button" value="Completed">
		</center>
	</form:form>
<form action="/project/showEditProject" method="post" modelAttribute="proj">
		<br> <br>
		<table border="1" align="center">
			<thead>
				<tr>
					<th>Project Details</th>
					<th>Priority</th>
					<th>Action</th>
					
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${projects}" var="p">
					<tr>
						
						<td><label>project:</label>
						<c:out value="${ p.projectName }"></c:out>
						<br>
						<label>StartDate</label>
						<c:out value="${ p.startDate }"></c:out>
						<br>
						<label>EndDate</label>
						<c:out value="${ p.endDate }"></c:out>
						</td> 
						
						<td><c:out value="${ p.priority }"></c:out></td> 

						<td><input type="hidden" name="pId" value="${ p.projectId }">
						<input type="submit" name="action" value="Update"> <br> <br>
						<input type="submit" name="action" value="Suspend"></td>


					</tr>
				</c:forEach>
			</tbody>
		</table>
		
	</form>
	
</body>
</html>