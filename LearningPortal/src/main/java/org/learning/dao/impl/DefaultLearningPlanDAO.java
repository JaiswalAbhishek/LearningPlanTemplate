package org.learning.dao.impl;

import java.util.Calendar;
//import java.sql.Date;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import org.learning.dao.DBConnection;
import org.learning.dao.LearningPlanDAO;
import org.learning.dao.LearningPlanTemplateDAO;
import org.learning.model.LearningPlan;
import org.learning.model.LearningPlanTemplate;
import org.learning.model.Skill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.stereotype.Component;
@Component
public class DefaultLearningPlanDAO implements LearningPlanDAO{

 int row = 0;
	 
	 @Autowired
	 DBConnection db;
	
	@Override
	public boolean createLearningPlan(LearningPlan learningPlan) {
		try{
								
			PreparedStatement ps = db.getConnection().prepareStatement("insert into learningPlan(employeeUserID,learningPlanID,startDate,endDate) values(?,?,SYSDATE(),SYSDATE())");
		
			// find how to make it auto-increment
			
			ps.setString(1,learningPlan.getEmpUserId());
			ps.setInt(2, learningPlan.getLearningPlanId());
			//ps.setDate(3, (Date)learningPlan.getStartDate());
			row = ps.executeUpdate();
			db.closeConnection();
			 
		}catch(SQLException e){System.out.println(e);}
		if(row == 1) {
			return true;
		}
		else {
			return false;
		}
	}

	
	@Override
	public boolean updateLearningPlan(LearningPlan learningPlan) {
		
		try {
				//User user = (User)object;
				
			PreparedStatement ps = db.getConnection().prepareStatement("update learningPlan set endDate= ? where employeeuserID = ? ");
		//	ps.setDate(1,(Date) learningPlan.getEndDate());
			
			ps.setString(2,learningPlan.getEmpUserId());
			
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
	public boolean deleteLearningPlan(int learningPlanId) {

		try {
			//User user = (User)object;							
			PreparedStatement ps = db.getConnection().prepareStatement("delete from learningPlan where learningPlanID = ? ");
			
			ps.setInt(1, learningPlanId);
			
			
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
	public LearningPlan getLearningPlan(int learningPlanId) {
		LearningPlan u1 =new LearningPlan();
		//	LinkedList<User> list = new LinkedList<User>();
		   try{
			   PreparedStatement ps = db.getConnection().prepareStatement("select * from LearningPlan where learningPlanID = ?");
			   ps.setInt(1,learningPlanId);
			   
			   ResultSet rs = ps.executeQuery();
			  

			  // while (rs.next()) {
			
					u1.setLearningPlanId(rs.getInt(3));
					u1.setEmpUserId(rs.getString(2));
					u1.setStartDate(rs.getDate(4));
					u1.setEndDate(rs.getDate(5));
				
					
				//	list.add(u1);
			//	}
			  
			 }catch(SQLException e5){e5.printStackTrace();}
		   return u1;
	}

	@Override
	public List<LearningPlan> getAllLearningPlan() {


		LinkedList<LearningPlan> list = new LinkedList<LearningPlan>();
		
	   try{
		   PreparedStatement ps = db.getConnection().prepareStatement("select * from LearningPlan");
		   ResultSet rs = ps.executeQuery();
		  

		   while (rs.next()) {
			 //  @Autowired
				LearningPlan u1 =new LearningPlan();
			   u1.setLearningPlanId(rs.getInt(3));
			   u1.setEmpUserId(rs.getString(2));			   
				u1.setStartDate(rs.getDate(4));
				u1.setEndDate(rs.getDate(5));
				list.add(u1);
			}
		  
		 }catch(SQLException e4){e4.printStackTrace();}
	   return list;	}




public List<LearningPlan> getAllLearningPlanAssignedToEmployee(String userID) {


	LinkedList<LearningPlan> list = new LinkedList<LearningPlan>();
	
   try{
	   PreparedStatement ps = db.getConnection().prepareStatement("select * from LearningPlan where employeeUserID=?");
	   ps.setString(1, userID);
	   ResultSet rs = ps.executeQuery();
	  

	   while (rs.next()) {
		 //  @Autowired
			LearningPlan u1 =new LearningPlan();
		   u1.setLearningPlanId(rs.getInt(3));
		   u1.setEmpUserId(rs.getString(2));			   
			u1.setStartDate(rs.getDate(4));
			u1.setEndDate(rs.getDate(5));
			list.add(u1);
		}
	  
	 }catch(SQLException e4){e4.printStackTrace();}
   return list;	}

public boolean updateLearningPlanById(int id) {
	
	try {
			//User user = (User)object;
			
		PreparedStatement ps = db.getConnection().prepareStatement("update learningPlan set status= ? where employeeuserID = ? ");
	//	ps.setDate(1,(Date) learningPlan.getEndDate());
		ps.setInt(1, 1);
		//ps.setString(2,id);\
		ps.setInt(2, id);
		
		row = ps.executeUpdate();
		db.closeConnection();
		 
	}catch(SQLException e2){System.out.println(e2);}
	
	if(row ==1) {
		return true;
	}else {
		return false;
	}
}
}
