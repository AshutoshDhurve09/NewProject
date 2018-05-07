<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<spring:url value="/company/addAdminCompany" var="CompanyAddUrl" />
	<form:form modelAttribute="company" action="${ CompanyAddUrl }" method="post" >
		<center>
			<h2>LOGIN PAGE FOR GENERAL_ADMIN</h2>
			<a href="/employee/home"><b>Home</b></a>
		</center>
		<table border="1" align="center">
			<tr>
				<td>Admin_Name:</td>
				<td><form:input type="text" path="adminName" /></td>
           </tr>
			<tr>
				<td>Password:</td>
				<td><form:input type="password" path="password" /></td>
           </tr>
			<tr>
				<td></td><td><input type="submit" name="Login" value="Login">
				<input type="reset" name="Reset"></td>

			</tr>



		</table>


	</form:form>
</body>
</html>