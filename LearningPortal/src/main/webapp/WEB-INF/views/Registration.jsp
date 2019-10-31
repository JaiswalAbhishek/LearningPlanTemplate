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
</head>
<style>
*{
    margin:0;
    padding:0;
}
body{background-color: lightskyblue;

}
#userRegistrationForm{
 width:500px;
    height:auto;
    background-color:white;
    margin:0 auto;
    
    margin-top: 60px;
     border-radius: 4px;
    
 }
 
    
input[type="text"]{
     width:460px;
    margin:10px;
    padding:10px;
     font-family: Arial, Helvetica, sans-serif;

/*    padding: 5px;*/
}

input[type="submit"]{
    
    width:80%;
    height: 8%;
padding:1%;
    margin:5% 10%;
    
    font-weight: bold;
    font-size: 24px;
    
    background-color: #008CBA;
    border: none;
    color: white;
    text-align: center;
    text-decoration: none;
    cursor: pointer;
    border-radius: 20px;
    
}

#roleBlock{
 
    width:460px;
    margin:5px 10px ;
    padding:10px;
    display: block;

}
.empRole{
    
    width:130px;
    display: inline-block;
    margin:0px 10px;
     font-family: Arial, Helvetica, sans-serif;
}

#role{
    width:440px;
    font-weight: bold;
    margin: 15px 0px;

    
}
#mainHead{
    text-align: center;
    margin-top: 20px;
    padding:10px 0px;
    color: #DC143C;
}
#descHead{
    text-align: center;
margin-bottom: 5%;
    font-size: 18px;
        color: #C71585;
}

</style>
<body>
<h2>${msg}</h2>



<div id="userRegistrationForm">
            <h1  id="mainHead">CREATE USER ACCOUNT</h1>
            <h5 id="descHead">Sign up for your Learning Platform</h5>
            
    <form:form modelAttribute="registration" action="register" method="POST">
        			
        				<form:input placeholder="Enter your  ID" path="empId" />
					
						<form:input placeholder="Enter your  name" path="empName" />
					
						<form:input placeholder="Enter your  user ID" path="empUserId" />
					
						<form:input placeholder="Enter your role" path="employeeRole" />
					
						<form:input placeholder="Enter your password" path="password" />
						
					
				      <input type="Submit" name="saveUser" value="Register"/>
          
    </form:form>
</div>
</body>
</html>