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
    margin:0;
    padding: 0;
}


body{
    background-color: lightskyblue;
}
.skillBlock{
    width: 500px;
    height: auto;
   /* background-color: greenyellow;*/
    margin:10% auto;
    background-color: white;
    border-radius:5px;
}

#heading{
    width: 100%;
    padding: 2% 0;
    text-align: center;
    margin:4% 0;
    color: #DC143C;
    
    font-family: Arial, Helvetica, sans-serif;
    font-size: 22px;
    font-weight: bolder;
    border-bottom: 2px solid #800000;
    

}

.inner-block{
    width: 440px;
    margin:auto 30px;
}

input[type="text"]{
    
    width:70%;
    height: 8%;
    margin:1% auto;
    padding: 2%;
}
button#saveTemplate{
    
    width:30%;
    height: 40px;
    
    
    font-family: Arial, Helvetica, sans-serif;
    font-size: 18px;
    font-weight: lighter;
    
background-color:red;
    border: none;
    
    color:white;
    
    margin:8% 35%;
    border-radius: 15px;
}
button#saveTemplate:hover{
border:1px solid red;
background-color:white;
color:red;}


</style>

</head>
<body>


        <div class="skillBlock">
            <div id="heading">Create a Skill and Course Related</div>
            
            <div class="inner-block">
            
            <form:form modelAttribute="skill" action="skill" method="POST">
				
					<p>
						<form:label for="skillId" path="skillId" cssErrorClass="error">Skill ID</form:label>
						<br />
						<form:input path="skillId" />
						<form:errors path="skillId" />	
					</p>
					
					<p>
						<form:label for="skillName" path="skillName" cssErrorClass="error">Skill Name</form:label>
						<br />
						<form:input path="skillName" />
						<form:errors path="skillName" />	
					</p>
					
					<p>
						<form:label for="CourseAttachedToTheSkill" path="CourseAttachedToTheSkill" cssErrorClass="error">Course URL:</form:label>
						<br />
						<form:input path="CourseAttachedToTheSkill" />
						<form:errors path="CourseAttachedToTheSkill" />
					</p>
					
                    <button name="saveTemplate" id="saveTemplate"type="submit" value="Save">Save</button>

				
			</form:form>
            

                
            
            </div>
         
        
        </div>
        
    



</body>
</html>