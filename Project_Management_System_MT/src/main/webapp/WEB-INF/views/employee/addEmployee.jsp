<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="true"%>

<%-- <%@ taglib uri="http://htmlcompressor.googlecode.com/taglib/compressor" prefix="compress" %> --%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<link rel="stylesheet" href="/resources/loginForm/css/style.css">
	
	<center>

<%-- 		<c:import url="home.jsp" /> --%>
				<c:import url="home.jsp"/><br>
				<div class="login">
		<div class="login-header">
			<h4>ADD EMPLOYEE</h4>
			<a href="/employee/home"><b>Home</b></a>
			<a href="/employee/logout"><b>Logout</b></a>
			
		</div><br><br>


		<spring:url value="/employee/add" var="userAddUrl" />
		<form:form modelAttribute="emp" action="${ userAddUrl }" method="POST" onSubmit="return addUser()">
			<table border="1" align="center" cellpadding="5" cellspacing="5">
				<tr>
					<td><label>Employee Name </label></td>
					<td><form:input path="employeeName" value="" id="firstname"
							type="text" size="25" maxlength="50" class="field" onblur="addUser()" /> <span
						id="fnerror" style="color: red"></span></td>
				</tr>
		
				<tr>
					<td><label>Email ID</label></td>
					<td><form:input path="emailId" value="" id="employeeid"
							type="email" size="25" maxlength="50" class="field" onblur="addUser()"/>
					 <span id="emperror" style="color: red"></span></td>
				</tr>
				
				<tr>
					<td>Password</td>
					<td><form:input type="password" path="password" id="password" onblur="addUser()"/>
					<span id="pwd" style="color: red"></span></td>
				</tr>

				<tr>
					<td>Role</td>
					<td><form:select id="designation" path="designation.designation">
							
							<form:options items="${designations}"/>
							
 						</form:select></td>
				</tr>
				
				<tr>
				<td>Company Name</td>
				<%-- <td><form:input path="company" type="text" id="companyName" onblur="addUser()" />  --%>
				<td><input type="text" value="${ sessionScope.company.companyName }" readonly="readonly">
				 <span
						id="cmp" style="color: red"></span></td>
				</tr>

				<tr>
					<td></td><td align="center"><input type="submit" value="Add" /> 
					<input type="reset" value="Reset" /> 
					</td>
				</tr>


			


			</table>
			<%-- <center>
				<a href="/user/searchUser">search user</a>
			</center> --%>
				</form:form>
</body>

<script type="text/javascript">
function addUser()
{
	 var Firstname=document.getElementById("firstname").value;
	 var Lastname=document.getElementById("lastname").value;
	 var EmployeeId=document.getElementById("employeeid").value;
	 var password=document.getElementById("password").value;
	var companyName=document.getElementById("companyName").value;

	 if (Firstname =="") {
			document.getElementById("fnerror").innerHTML = "Please Enter First Name!!!";
			
		} else {
			document.getElementById("fnerror").innerHTML = " ";
		}
		
	 if (Lastname =="") {
			document.getElementById("lnerror").innerHTML = "Please Enter Last Name!!!";
			
		} else {
			document.getElementById("lnerror").innerHTML = " ";
		}
		
	 if (EmployeeId =="") {
			document.getElementById("emperror").innerHTML = "Please Enter EmployeeId!!!";
			
		} else {
			document.getElementById("emperror").innerHTML = " ";
		}
		
	 if (password=="")
		{
			document.getElementById("pwd").innerHTML="Please Enter Password!!!";
		}
		else
			{
				document.getElementById("pwd").innerHTML="";
			}

		if(companyName=="")
			{
				document.getElemetById("cmp").innerHTML="Please Enter Company Name!!!";
			}
		else
			{
				document.getElementById("cmp").innerHTML="";
			}
	 


	 if(Firstname=="" || Lastname=="" || EmployeeId=="" || password=="" )
		{
		return false;
		}
	
	 
	 return true;
		
}


</script>
</html>