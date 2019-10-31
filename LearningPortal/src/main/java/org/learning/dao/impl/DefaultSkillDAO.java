package org.learning.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import org.learning.dao.DBConnection;
import org.learning.dao.SkillDAO;
import org.learning.model.Skill;
import org.learning.model.User;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.stereotype.Component;
@Component
public class DefaultSkillDAO implements SkillDAO {
	 int row = 0;
	 
	 @Autowired
	 DBConnection db;// = new DBConnection();
	 
	 LinkedList<Skill> skillList = new LinkedList<Skill>();
		
	 
	public boolean createSkill(Skill skill) {
		
			try{
				//Skill skl = (Skill)object;							
				PreparedStatement ps = db.getConnection().prepareStatement("insert into skill values(?,?,?)");
				
			   ps.setInt(1, skill.getSkillId());
				ps.setString(2, skill.getSkillName());
				ps.setString(3, skill.getCourseAttachedToTheSkill());
				
				row = ps.executeUpdate();
				db.closeConnection();
				 
			}catch(SQLException e){System.out.println(e);}
			if(row==0) {
				return false;
			}
			else{
				return true;
			}
		
	}

	@Override
	public boolean updateSkill(Skill skill) {
			
			try {
					//User user = (User)object;
					
				PreparedStatement ps = db.getConnection().prepareStatement("update skill set skillName= ? where skillID = ? ");
				ps.setString(1,skill.getSkillName());
				ps.setInt(2,skill.getSkillId());
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
	public boolean deleteSkill(int skillId) {
		
				try {
					//User user = (User)object;							
					PreparedStatement ps = db.getConnection().prepareStatement("delete from skill where skillID = ? ");
					
					ps.setInt(1, skillId);
					
					
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
	public Skill getSkill(int skillId) {
		Skill u1 =new Skill();
	//	LinkedList<User> list = new LinkedList<User>();
	   try{
		   PreparedStatement ps = db.getConnection().prepareStatement("select * from Skill where SkillID = ?");
		   ps.setInt(1,skillId);
		   ResultSet rs = ps.executeQuery();
		  

		  // while (rs.next()) {
		
			   
				u1.setSkillId(rs.getInt(1));
				u1.setSkillName(rs.getString(2));
				u1.setCourseAttachedToTheSkill(rs.getString(3));
			//	list.add(u1);
		//	}
		  
		 }catch(SQLException e5){e5.printStackTrace();}
	   return u1;
	
	}

	public List<String> getAllSkillsName(){
		LinkedList<String> list = new LinkedList<String>();
		
		   try{
			   PreparedStatement ps = db.getConnection().prepareStatement("select skillName from Skill");
			   ResultSet rs = ps.executeQuery();
			  

			   while (rs.next()) {
				 //  @Autowired

				   list.add(rs.getString(1));
					}
			  
			 }catch(SQLException e4){e4.printStackTrace();}
		   return list;

	}
	
	@Override
	public List<Skill> getAllSkills() {
		
		LinkedList<Skill> list = new LinkedList<Skill>();
		
		
	   try{
		   PreparedStatement ps = db.getConnection().prepareStatement("select * from Skill");
		   ResultSet rs = ps.executeQuery();
		  

		   while (rs.next()) {
			 //  @Autowired

				Skill u1 =new Skill();
				u1.setSkillId(rs.getInt(1));
				u1.setSkillName(rs.getString(2));
				u1.setCourseAttachedToTheSkill(rs.getString(3));
				
				//global skill List
				
				skillList.add(u1);
				
				list.add(u1);
			}
		  
		 }catch(SQLException e4){e4.printStackTrace();}
	   return list;
	}

	@Override
	public boolean changeCourse(int id,String url) {
				try {
					//User user = (User)object;
					Skill skill = new Skill();
					
				PreparedStatement ps = db.getConnection().prepareStatement("update skill set courseAttached= ? where skillID = ? ");
				ps.setString(1,url);
				ps.setInt(2,skill.getSkillId());
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
