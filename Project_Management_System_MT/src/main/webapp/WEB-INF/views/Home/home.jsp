<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<spring:url value="/Company/add" var="CompanyAddUrl" />
	<form:form modelAttribute="company" action="${ projectAddUrl }">
		<center>
			<h1>PROJECT MANAGEMENT SYSTEM</h1>
			
			<a href="/company/generalAdminLogin"><input type="button" value="General Admin"></a>
			<span style="padding-left:20px"><a href="/company/companyAdminLogin"><input type="button" value="Company Admin"></a></span>
		</center>
		<table border="1" align="center">
			<!-- <tr>
				<td>Login For General Admin:</td>
				<td><a href="/company/generalAdminLogin"></a></td>
			</tr> -->
		</table>
		<br>
		<br>
		<h3 align="center">Login For Company</h3>
		<table border="1" align="center" cellpadding="5" cellspacing="5">
			<tr>
				<td>Company Name:</td>
				<td><form:select id="companyName" path="companyName">
						<form:options items="${companyNames}" />
					</form:select></td>

			</tr>

			<tr>
				<td>Employee Name</td>
				<td><form:input path="adminName" id="adminName" type="text"
						onblur="addUser()" /> <span id="fnerror" style="color: red"></span></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><form:input type="password" path="password" /></td>

			</tr>
			<%-- <tr>
				<td>Role</td>
				<td><form:select id="designations" path="designations">
						<form:options items="${designations}" />
					</form:select></td>
			</tr> --%>

			<tr align="center"><td></td><td>
				<input type="submit" name="Login">
				<input type="reset" name="Reset"></td>

			</tr>

		</table>

	</form:form>



</body>
</html>