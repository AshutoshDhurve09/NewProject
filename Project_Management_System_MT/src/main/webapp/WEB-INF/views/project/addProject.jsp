<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="true"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AddProject</title>
<script type="text/javascript">
function addProject()
{
	 var Projectname=document.getElementById("projectname").value;
	 var StartDate=document.getElementById("startdate").value;
	 var EndDate=document.getElementById("endDate").value;
	 var Priority=document.getElementById("priority").value;
	

	 if ((Date.parse(StartDate) >= Date.parse(EndDate))) {
	        alert("End date should be greater than Start date");
	        document.getElementById("endDate").value = "";
	    }
	

	 
	 if (Projectname =="") {
			document.getElementById("pnerror").innerHTML = "please enter Project_Name";
			
		} else {
			document.getElementById("pnerror").innerHTML = " ";
		}
		
	 if (StartDate =="") {
			document.getElementById("sderror").innerHTML = "please enter Start_Date";
			
		} else {
			document.getElementById("sderror").innerHTML = " ";
		}
		
	 if (EndDate =="") {
			document.getElementById("ederror").innerHTML = "please enter End_Date";
			
		} else {
			document.getElementById("ederror").innerHTML = " ";
		}

	 if (Priority =="") {
			document.getElementById("perror").innerHTML = "please Select Priority";
			
		} else {
			document.getElementById("perror").innerHTML = " ";
		}




	 if(Projectname=="" || StartDate=="" || EndDate=="" || Priority==""  )
		{
		return false;
		}
	
	 
	 return true;
		
}

</script>
</head>
<body>
<jsp:include page="../project/home.jsp"></jsp:include>
<spring:url value="/project/add" var="projectAddUrl" />
		<form:form modelAttribute="proj" action="${ projectAddUrl }"  onSubmit="return addProject()">
		<center><h3>ADD-PROJECT</h3></center>
		<%-- <center>
			<c:import url="home.jsp"/>
			
			<c:if test="${not empty employee.userName}">
				<c:url value="/employee/logout" var="logOutUrl" scope="session"/>
				<a href="${ session.logOutUrl }">Logout</a>
			</c:if>
			</center> --%>
			
				<table border="1" align="center">
			<tr>
				<td><label>Project Name:</label></td>
				<td><form:input type="text" path="projectName" id="projectname" /><span id="pnerror" style="color: red">*</span><br />
			<!-- 	// <span id="pnerror"></span> -->
				 
				</td>
			</tr>
			<%-- <form:checkbox path="checkDate" /> --%>
			<tr>
				<td><label>Start Date</label></td>
				<td><input type="text" id="startdate" name="startDate">
				 <span id="sderror" style="color: red">*</span>
				</td>
			</tr>
			<tr>
				<td><label>End Date</label></td>
				<td><input type="text"  id="endDate" name="endDate"><span id="ederror" style="color: red">*</span><br />
				 
				</td>
			</tr>
			<tr>
				<td><label>Priority</label></td>
				<td><form:input type="range" path="priority" id="priority" maxlength="100" /><br />
				 <span id="perror"></span>
				</td>
			</tr>
			<tr>
				<td><label>Manager</label></td>
				<td><input type="text" name="managerName" value="${ sessionScope.employee.userName }" readonly="readonly"><br />
				
				</td>
			</tr>
			<tr>
				<td><input type="submit" value="ADD"> 
				<input type="reset" value="RESET">
				<input type="submit" name="submit" class="submit" value="Search" />
				</td>
			</tr>


		
	</table>
	<center><a href="/project/searchProject">search project</a></center>
	</form:form>
</body>
</html>