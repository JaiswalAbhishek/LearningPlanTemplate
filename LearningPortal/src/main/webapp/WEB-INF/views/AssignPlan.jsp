<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page language = "java" %>
<%@ page import  ="java.sql.*" %>
<%@ page import  ="java.util.List" %>

<%@ page import = "org.learning.dao.impl.*" %>

<%@ page import = "org.learning.model.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="learningTemplateStyle.css"/>
<title>Insert title here</title>
<style>
*{
margin:0px;
padding:0px;
}

body{
background-color: lightskyblue;
}
.assignBlock{
width:40%;
margin:2% auto;
}
.inner-Block{
width:100%;

background-color:white;

border:1px solid black;
border-radius:5px;


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
input#assignToEmployeeBtn{
width:25%;
heigth:3%;
background-color:red;
border-radius:10px;
padding:10px;
margin-bottom:5%;
margin-left:35%;
}

input#assignToEmployeeBtn:hover{
border:1px solid red;
background-color:white;
color:red;
}
h3{
width:99%;
background-color:#EBF5FB;
display:block;
padding:1%;
font-family: Arial, Helvetica, sans-serif;
font-size: 18px;
}
input[type="text"]{
display:block;
margin:2% 50px;
  width:80%;
    
    padding:10px;
     font-family: Arial, Helvetica, sans-serif;


}
input[type="date"]{
 width:80%;
    margin:10px;
    padding:10px;
    display:block;
    
margin-left:50px;
     font-family: Arial, Helvetica, sans-serif;
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


}
input#logoutBtn{
text-decoration:none;
bordr:none;

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
label{
padding:10px;
color:green;
}#welExit{
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
           Assign Learning Plan Templates
</div>

	

	<!-- private Date startDate;
	private Date endDate; -->
	
	<div class="assignBlock">
	
	<div class="inner-Block">
	<br/>
	<pre>	Enter Details:
		</pre>

	<!-- *******************	DISPLAY	LEARNING PLAN TEMPLATE	********************************** -->
			  <form:form modelAttribute="assignPlan" action="assignPlan" method="POST">
			               			<form:input placeholder="Enter Empoloyee User ID:" path="empUserId" />
									
									<form:input placeholder="Enter Learning Plan ID:" path="learningPlanId" />
								<!-- 
									<form:input placeholder="Start Date: YYYY-MM-DD" path="startDate" />
									
								 -->	
									 
			
					<input type="submit" id="assignToEmployeeBtn" name="assignToEmployee" value="Assign"/>
			 
			
			 </form:form>
</div>
</div>

</body>
</html>



