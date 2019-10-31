package org.learning.dao.impl;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.learning.dao.DBConnection;
import org.learning.dao.LearningPlanTemplateDAO;
import org.learning.model.LearningPlanTemplate;
import org.learning.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.stereotype.Component;
@Component
public class DefaultLearningPlanTemplateDAO implements LearningPlanTemplateDAO {

	@Autowired
	DBConnection db;// = new DBConnection(); 
	String listSkill="";
	int row=0;
	

	@Override
	public boolean createLearningPlanTemplate(LearningPlanTemplate learningPlanTemplate) {

		/*
		 * using SESSION pass the login user ID to this method as creator ID
		 * 
		 * */
		
		
		try{
			//LearningPlanTemplate template = (LearningPlanTemplate)obj;							
			PreparedStatement ps = 
		db.getConnection().prepareStatement("insert into learningPlanTemplate values(?,?,SYSDATE(),SYSDATE(),?,?)");
			
			ps.setInt(1,learningPlanTemplate.getLearningPlanId());
			ps.setString(2,learningPlanTemplate.getLearningPlanName());
		//	ps.setString(3,learningPlanTemplate.getListOfSkills());
			System.out.println(learningPlanTemplate.getListOfSkills().size());
			for(int i=0;i<learningPlanTemplate.getListOfSkills().size();i++){
				listSkill +=  learningPlanTemplate.getListOfSkills().get(i) +",";
			}
			ps.setString(3,listSkill);
			//System.out.print(listSkill);
			//ps.setString(3,"MongoDB,AWS");
			
			ps.setString(4, learningPlanTemplate.getCreatorUserId());
			
			
			row = ps.executeUpdate();
			db.closeConnection();
			 
		}catch(SQLException e){System.out.println(e);}
		if(row==1)
			return true;
		else
			return false;
		
	}



	@Override
	public boolean updateLearningPlanTemplate(LearningPlanTemplate learningPlanTemplate) {
		
		try {
					//User user = (User)object;
					
				PreparedStatement ps = db.getConnection().prepareStatement("update learningPlanTemplate set planName = ? where learningPlanID = ? ");
		
			ps.setString(1, learningPlanTemplate.getLearningPlanName());
			ps.setInt(2,learningPlanTemplate.getLearningPlanId());
				
				
				row = ps.executeUpdate();
				db.closeConnection();
				 
			}catch(SQLException e2){System.out.println(e2);}
			
			if(row ==1) {
				return true;
			}else {
				return false;
			}
	}



	@Override
	public boolean deleteLearningPlanTemplate(int templateId) {

		try {
			//User user = (User)object;							
			PreparedStatement ps = db.getConnection().prepareStatement("delete from learningPlanTemplate where learningPlanID = ? ");
			
			ps.setInt(1, templateId);
			
			
			row = ps.executeUpdate();
			db.closeConnection();
			 
		}catch(SQLException e3){System.out.println(e3);}
		if(row ==1) {
			return true;
		}else {
			return false;
		}
	}



	@Override
	public LearningPlanTemplate getLearningPlanTemplatel(int templateId) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public List<LearningPlanTemplate> getAllLearningPlanTemplate() {
			LinkedList<LearningPlanTemplate> lpto = new LinkedList<LearningPlanTemplate>();
			
			
			ArrayList<String> al = new ArrayList<String>();
		   try{
			   PreparedStatement ps = db.getConnection().prepareStatement("select * from LearningPlanTemplate");
			   ResultSet rs = ps.executeQuery();
			  
	
			   while (rs.next()) {
				   LearningPlanTemplate lpt =new LearningPlanTemplate();
				lpt.setLearningPlanId(rs.getInt(1));
				lpt.setLearningPlanName(rs.getString(2));
				lpt.setCreationDate(rs.getDate(3));
				lpt.setModifiedDate(rs.getDate(4));
				
				//convert string to List to store in listofSkill property of class
	//			 String[] arrOfStr = str.split("@", 2);
				
				String arr[] = listSkill.split(",");
				for(int i=0;i<arr.length;i++){
					System.out.println(arr[i]);
					al.add(arr[i]);
				}
				
				
				 lpt.setListOfSkills(al);
			//	System.out.println(listSkill);
				 lpt.setCreatorUserId(rs.getString(6));
				 lpto.add(lpt);
			
				   /*e1.setEmpId(rs.getInt(1));
					System.out.println("****************" + rs.getInt(1));
					e1.setEmpName(rs.getString(2));
					e1.setEmpSal(rs.getDouble(3));
					list.add(e1);*/
				}
			  
			 }catch(SQLException e){e.printStackTrace();}
		   return lpto;
	}
	
	
	
	

}
