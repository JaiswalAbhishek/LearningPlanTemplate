
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> 
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome To GrowExp</title>
<link  type="text/css" rel="stylesheet" href="/resources/css/loginStyle.css" />
<style>
*{
    margin:0;
    padding:0;
}
body{
    background-color: lightskyblue;
   
}
.body-login{
    background-image: url("resources/images/loginPage.jpg");

}

#head{
    padding: 20px 0px;
color: #DC143C;
}
.centerLoginForm{
    
    background-color: white;
    width:450px;
    margin: 0 auto;
    text-align: center;
 padding:2% ;
    margin-top: 150px;
    font-family: Arial, Helvetica, sans-serif;
    font-size: 22px;
    font-weight: lighter;
    //background-color: fuchsia;

    border-radius: 5px;
}
#loginForm{
    width:100%;
    height: 300px;
    //background-color: greenyellow;
    position: relative;
    
}



input[type="text"],input[type="password"]{
    /*width:100%;
    height: 40px;
    margin:5px 0;
    */
     width:90%;
    margin:10px;
    padding:10px;
     font-family: Arial, Helvetica, sans-serif;

/*    padding: 5px;*/
}

input[type="submit"]{
    width:96%;
    height: 20%;
    margin-top: 10%;
    font-weight: bold;
    font-size: 20px;
    padding:2%;
     background-color: #4CAF50; /* Green */
    /*background-color: #008CBA;*/
    border: none;
    color: white;
    text-align: center;
    text-decoration: none;
    cursor: pointer;
    border-radius: 2px;
    
}

#registerLink{
    
 margin-top:4%;
    /*position: absolute;
    bottom: 10px;
    width: 430px;
    padding: 10px;
    */

}

#registerLink>a{
    text-decoration: none;
    color: #C71585;
    
}

</style>
</head>
<body style="background-image: url("resources/images/loginPage.jpg")">
<div class="body-login">
<div class="centerLoginForm">
	           <div id="head">Welcome to GrowExp Learning Platform</div> 
		       
		       <div id="loginForm">
		       
		       
		       <form:form modelAttribute="login" action="login" method="POST">
						<form:input placeholder="Enter your Email ID" path="userid" />
				
						<form:input placeholder="Enter your password"  path="password" />
				
						<input type="submit" value="Login"/>
				
				
			</form:form>
			
			 			<div id="registerLink">
						
		                        First time here? <a href="/LearningPortal/index/register"><span>Create your account.</span></a>
		                  </div>
			
		       </div>
	</div>


</div>
</body>
</html>