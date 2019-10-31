<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page language = "java" %>
<%@ page import  ="java.sql.*" %>
<%@ page import = "org.learning.dao.impl.*" %>
<%@ page import = "org.learning.dao.DBConnection" %>

 
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- <META HTTP-EQUIV="refresh" CONTENT="4"> -->
<link rel="stylesheet" type="text/css" href="learningTemplateStyle.css"/>
<title>Insert title here</title>
<style>

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
input#assignToEmployee{
width:20%;
float:right;
background-color:red;
}

input#assignToEmployee:hover{
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



</style>

</head>
<body>

<div id="createTemplateBlock" >
           Assign Learning Plan Templates
</div>

<%
try{
	
    DBConnection db = new DBConnection();
     
     PreparedStatement cs = db.getConnection().prepareStatement("select * from learningPlanTemplate");    
     
     ResultSet rs = cs.executeQuery();
%>
<h3>Learning Plans Created By Manager(s)</h3>
<% 
          out.println("<div class='tableblk'>");
		                   out.println("<table border = 1>");
		                   out.println("<tr><th>Learning Plan Name</th>"
		                  +" <th>Creation Date</th><th>Skills</th><th>Check to Assign</th></tr>");                   
		                
		                   while(rs.next()){
		                                                
		                        out.println("<th>" + rs.getString(2) + "</th>");  
		                        out.println("<th>" + rs.getDate(3)+"</th>");
		                        
		                        out.println("<th>" + rs.getString(5) + "</th>");
		                        
		                        //how to assign value to checkbox
		                        //assign learningPlanID as values to this checkbox
		                        out.println("<th><input type='checkbox' name='assignTemplate' value=''/></th>");
		                        out.println("</tr>");  
            				}
		     out.println("</div>");                
    }catch(SQLException e1){ out.println("due to sql " + e1);}
       out.println("</table></body></html>");
%>








<h3>Select the Employee to Assign Learning Plan</h3>

<%
DBConnection db = new DBConnection();

try{
	
	       
	       PreparedStatement cs = db.getConnection().prepareStatement("select * from User where role='Employee'");    
	       
           ResultSet rs = cs.executeQuery();
   
                out.println("<div class='tableblk'>");
			                   out.println("<table border = 1>");
			                   out.println("<tr><th>Employee ID</th><th>Employee Name</th>"
			                  +" <th>Employee User ID</th><th>Assign</th></tr>");                   
			                
			                   while(rs.next()){
			                         out.println("<tr><th> " + rs.getInt(1) + "</th>");                        
			                        out.println("<th>" + rs.getString(2) + "</th>");                        
			                        out.println("<th>" + rs.getString(3) + "</th>");
			                        
			                        
			                        //how to assign value to checkbox
			                        //assign employeeID as values to this checkbox
			                        out.println("<th><input type='checkbox' name='assignToEmployee' value=''/></th>");
			                        
			                        out.println("</tr>");  
                  				}
			     out.println("</div>");                
          }catch(SQLException e1){ out.println("due to sql " + e1);}
             out.println("</table></body></html>");
 %>
<input type="text" name="employeeToAssignPlan" placeholder="Enter employee name to assign Plan"/>
		                    

<input type="submit" id="assignToEmployee" name="assignToEmployee" value="Assign"/>
 
 <script type="text/javascript">
        
        
        
        

        document.getElementById('createTemplate').addEventListener('click',function(){
            document.querySelector('.bg-model').style.display='flex';
        });
        
         document.querySelector(".close").addEventListener('click',function(){
            document.querySelector('.bg-model').style.display='none';
        });
        
    
    </script>
 
</body>
</html>