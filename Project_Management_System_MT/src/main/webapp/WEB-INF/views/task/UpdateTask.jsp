<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<title>Add Task</title>
<link rel="stylesheet" type="text/css" href="style.css">

</head>
<body>
	<h3 align="center">Update Task</h3>

	<center>
		<a href="/task/home">HOME</a><br>
		<%-- <c:if test="${not empty employee.userName}">
			<c:url value="/employee/logout" var="logOutUrl" scope="session" />



			<a href="${ session.logOutUrl }">Logout</a>
		</c:if>
 --%>

	</center>
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
		<a href="/employee/logout">logout</a>
	</center>
	<spring:url value="/task/edittask" var="TaskAddUrl" />
	<form:form modelAttribute="task" action="${ TaskAddUrl }">


		<table border="1" align="center">
			<tr>
				<th>PROJECT MANAGER</th>
			</tr>
			<tr>
				<td><label>project:</label> <form:select
						path="projectEntity.projectName">
						<form:options items="${ projectNames }" />
					</form:select>
			</tr>
			<tr>
				<td><label>Task</label> <form:input type="text" path="taskName"
						size="25" maxlength="50" class="field" /></td>
			</tr>
			<tr>
				<td><form:checkbox path="status" value="Parent Task" /><label>Parent
						Task</label></td>
			</tr>
			<tr>
				<td><label>Priority:</label>
				<form:input type="range" minlength="0" maxlength="30"
						path="priority" /></td>
			</tr>
			<tr>
				<td><label>Parent-Task</label>
				<form:input type="text" path="parentTaskId" size="25" maxlength="50"
						class="field" /></td>
			</tr>
			<tr>
				<td><label>Start-Date</label>
				<form:input type="text" path="taskStartDate" /></td>
			</tr>
			<tr>
				<td><label>End-Date</label>
				<form:input type="text" path="taskEndDate" /></td>
			</tr>
			<tr>
				<td><label>User</label><input type="text" name="userName"
					class="field" size="25" maxlength="50"
					value="${ employee.userName }" readonly="readonly"></td>
			</tr>
			<tr>
				<td><input type="submit" value="UpdateTask" /> <input
					type="submit" value="Reset" /></td>
			</tr>
		</table>


	</form:form>
</body>
</html>