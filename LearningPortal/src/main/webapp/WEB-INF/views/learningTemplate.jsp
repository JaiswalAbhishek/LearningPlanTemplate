<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 <%@taglib prefix='spring' uri='http://www.springframework.org/tags'%>
 
<%@ page language = "java" %>
<%@ page import  ="java.sql.*" %>
<%@ page import = "org.learning.dao.impl.*" %>
 
<%@ page import = "org.learning.dao.DBConnection" %>
    
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
#createTemplateBlock{
    width: 100%;
    height: 100px;
    
	background-color:#F8F9F9;
}
#myInput{
display:block;
width:52%;
margin:2% auto;
}
#heading{
    height: 50px;
    width: 70%;
    float:left;
    margin:2%;
    text-align: center;
     font-family: Arial, Helvetica, sans-serif;
font-size: 36px;
    color:#DC143C;
}
#createButton{
    height: 50px;
    width: 20%;
    float: right;
    margin:2%;
   /* background-color: yellow;*/
}
input[type="submit"]{
    height: 50px;
    width: 100%;
}
.bg-model{
    width:100%;
    height: 100%;
    border-radius: 5px;
    background-color: rgba(0,0,0,0.7);
    position: absolute;
    top: 0;
    display: flex;
    justify-content: center;
    align-items: center;
    display: none; /*  hide the model */
    border-radius: 5px;
}
.model-content{
     border-radius: 5px;
    width:500px;
    height: 500px;
    background-color: white;
    position: relative;
}
.close{
    position: absolute;
    top:0;
    right: 15px;
    font-size: 40px;
    transform: rotate(45deg);
    cursor: pointer;
}
#templateInput{
    position: absolute;
    top:80px;
    margin:50px;
    margin-left:70px;
 }
#head{
    text-align: center;
    position: absolute;
    top:50px;
    width: 500px;
    font-size: 30px;
    color: #DC143C;      
}
input[type="text"]{

width:85%;  
  margin:10px;
    padding:10px;
     font-family: Arial, Helvetica, sans-serif;
}
input[type="submit"]{   
    width:100%;
    height: 40px;
    margin:2% 0;
    font-weight: bold;
    font-size: 20px;
    background-color: #008CBA;
    border: none;
    color: white;
    text-align: center;
    text-decoration: none;
    cursor: pointer;
    border-radius: 20px;   
}
.tempCreate:hover{
    background-color: white;
    border: 1px solid #008CBA;
    color: #008CBA;
    
}

.tableblk{
	width:850px;
	height:auto;
	
	margin:1% auto;
	
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
width:92%;
font-family: Arial, Helvetica, sans-serif;
font-size: 14px;
padding:2%;

}

button#saveTemplate{
  width:40%;
  height:auto;
    margin:10% 30%;
    padding:2%;
    font-weight: bold;
    font-size: 20px;
    background-color: #008CBA;
    border: none;
    color: white;
    text-align: center;
    text-decoration: none;
    cursor: pointer;
    border-radius: 20px;   

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
<div id="createTemplateBlock">
            <div id="heading">CREATE A LEARNING PLAN TEMPLATE</div>
            <div id="createButton"> <input type="submit" class="tempCreate" name="createTemplate" id="createTemplate" value="Create Template"/></div>
        </div>
        
        <div class="bg-model">
            <div class="model-content">
            
                <div class="close">+</div>
                <span id="head">Create Learning Plan Template</span>
                
                <div id="templateInput">
			                
			                
			                <form:form modelAttribute="createTemplate" action="createTemplate" method="POST">
							
									<form:input placeholder=" Enter Learning Plan ID" path="LearningPlanId"/>
									<form:input placeholder=" Enter Learning Plan name" path="LearningPlanName" />
								
									<form:select path="ListOfSkills" multiple="false">
									<form:option value="NONE" label="- Select Skill(s) -"/>
									    <form:options items="${skill}" />
									</form:select>
									<form:input placeholder=" Enter creater ID" path="CreatorUserId" />
								
								 <button id="saveTemplate"name="saveTemplate" type="submit" value="Save">SAVE</button>
                       
							
						</form:form>
			                
                   </div>
                
            </div>
        </div>


<input type="text" id="myInput" onkeyup="myFunction()" placeholder="Search for Learning Plan.." title="Type in a name">



<%

try{

DBConnection db2 = new DBConnection();
	       
	       PreparedStatement cs = db2.getConnection().prepareStatement("select * from learningPlanTemplate");    
	       
           ResultSet rs = cs.executeQuery();
   
                out.println("<div class='tableblk' id='myTable'>");
			                   out.println("<table border = 1>");
			                   out.println("<tr><th>Learning Plan ID</th><th>Learning Plan Name</th>"
			                  +" <th>Creation Date</th><th>Last Modified Date</th><th>Skills</th><th>Creater of Template</th></tr>");                   
			                
			                   while(rs.next()){
			                         out.println("<tr><td> " + rs.getInt(1) + "</td>");                        
			                        out.println("<td>" + rs.getString(2) + "</td>");  
			                        out.println("<td>" + rs.getDate(3)+"</td>");
			                        out.println("<td>" + rs.getDate(4)+"</td>");
			                        
			                        out.println("<td>" + rs.getString(5) + "</td>");                        
			                        out.println("<td>" + rs.getString(6) + "</td>");
			                        //out.println("<th><input type='checkbox' name='assignTemplate' value=''/></th>");
			                        out.println("</tr>");  
                  				}
			     out.println("</div>");                
          }catch(SQLException e1){ out.println("due to sql " + e1);}
             out.println("</table></body></html>");
 %>
 
 <script type="text/javascript">
        
        
        
        

        document.getElementById('createTemplate').addEventListener('click',function(){
            document.querySelector('.bg-model').style.display='flex';
        });
        
         document.querySelector(".close").addEventListener('click',function(){
            document.querySelector('.bg-model').style.display='none';
        });
        
         function myFunction() 
         {
	           var input, filter, table, tr, td, i;
	           input = document.getElementById("myInput");
	           filter = input.value.toUpperCase();
	           table = document.getElementById("myTable");
	           tr = table.getElementsByTagName("tr");
	           for (i = 0; i < tr.length; i++) 
	           {
		             td = tr[i].getElementsByTagName("td")[1];
		             if (td)
		             {
			               if (td.innerHTML.toUpperCase().indexOf(filter) > -1) 
			               {
			                 tr[i].style.display = "";
			               } 
			               else
			               {
			                 tr[i].style.display = "none";
			               }
		             }       
	           }
         }
             
    </script>
 
</body>

</html>