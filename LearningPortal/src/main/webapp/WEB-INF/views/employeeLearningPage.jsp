<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<style>

*{
    margin:0px;
    padding:0px;
}
#welExit{padding:10px;
width:98%;
display:inline-block;
text-align:right;


   
     font-family: Arial, Helvetica, sans-serif;
font-size: 14px;

}
div#welExit>h2{
display:inline;
margin:auto 2%;
padding:4% 0;



}
.tableblk{
	width:800px;
	height:auto;
	
	margin:5% auto;
	
}
table {
    font-family: arial, sans-serif;
    border-collapse: collapse;
    width: 100%;
    margin:3% auto;
}

td, th {
    border: 1px solid #dddddd;
    text-align: left;
    padding: 8px;
     text-align:center;
    
}

tr:nth-child(even) {
    background-color: #dddddd;
 }

select{
backround-color:#EBF5FB;
margin:auto 2%;
display:block;
width:95%;
font-family: Arial, Helvetica, sans-serif;
font-size: 14px;
padding:2%;

}

#createTemplateBlock{
	background-color:#F8F9F9;
	height:auto;
	text-align:center;
    width: 99%;
    padding:1%;
     font-family: Arial, Helvetica, sans-serif;
	font-size: 36px;
    color:#DC143C;
}
#welExit{
padding:5px;
width:100%;
display:inline-block;
text-align:right;
display:inline-block;
     font-family: Arial, Helvetica, sans-serif;
font-size: 14px;

}
div#welExit>h2{
float:left;
}input#logoutBtn{
text-decoration:none;
width:6%;
margin:5px;
padding:5px;
margin-right:10px;
background-color:#0080FF;
border-Radius:10px;
color:white;
float:right;
text-align:center;
font-weight:bold;
font-family: Arial, Helvetica, sans-serif;
font-size: 14px;

}

p#notYet{
color:green;
padding:5%;
text-align:center;
     font-family: Arial, Helvetica, sans-serif;
	font-size: 36px;
}
</style>
</head>
<body>
<%
String n=(String)session.getAttribute("loginUser");  
%>
<div id="welExit">
<h2>Welcome,<% out.println(""+n); %></h2>


<form:form action="logout" method="post">
        <input id="logoutBtn" type="submit" value="Logout" />
</form:form>

</div>
<div id="createTemplateBlock" >
           Assigned Learning Plan By Trainer(s)
</div>

 <c:choose>
  <c:when test="${assignedPlanCount == 'No Records'}">
    <p id="notYet">***NOT yet assigned***</p>
  </c:when>
  
  <c:otherwise>
    
	<table class="tableblk">
		<tr><th>Employee user ID</th><th>LearningPlanID</th><th>Start Date</th><th>End Date</th><th>Status</th></tr>
		<c:forEach var="emp" items="${learninglistForEmployee}">
				<tr>		
					<td>${emp.empUserId }</td>
					<td>${emp.learningPlanId }</td>
					<td>${emp.startDate }</td>
					<td>${emp.endDate }</td>
					<td><input type="submit" value="Done"/></td>
				</tr>
				
		</c:forEach>
	</table>
  </c:otherwise>
</c:choose>
 
</body>
</html>