<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page language = "java" %>
<%@ page import  ="java.sql.*" %>
<%@ page import = "org.learning.model.*" %>
<%@ page import = "java.util.*" %>
<%@ page import ="org.learning.dao.impl.*" %>


<%

LearningPlanTemplate e1 = new LearningPlanTemplate();

DefaultLearningPlanTemplateDAO m1 = new DefaultLearningPlanTemplateDAO();

 List<LearningPlanTemplate> al = (List<LearningPlanTemplate>)m1.getAllLearningPlanTemplate();
 
%>

<%
for (LearningPlanTemplate c1 :al ) {
	 out.println(c1.getLearningPlanId());
	 out.println(c1.getLearningPlanName());
	 out.println(c1.getListOfSkills()); 	
	 out.println("<br/>"); 	
	} 
%>
	
<h1>This is example</h1>





