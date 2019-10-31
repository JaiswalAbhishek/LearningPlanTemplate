package org.learning.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import org.learning.dao.DBConnection;
import org.learning.dao.UserDAO;
import org.learning.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.stereotype.Component;
@Component
public class DefaultUserDAO implements UserDAO{

	 int row = 0;
	 
	 @Autowired
	 DBConnection db;// = new DBConnection();
	
	 // CREATE User
	
	public boolean createUser(User user) {

		try{
			//User usr = (User)object;							
			PreparedStatement cs = db.getConnection().prepareStatement("insert into User values(?,?,?,?,?)");
			
			cs.setInt(1,user.getEmpId());
			cs.setString(2,user.getEmpName());
			cs.setString(3,user.getEmpUserId());
			cs.setString(4,user.getEmployeeRole());
			cs.setString(5,user.getPassword());
			
			row = cs.executeUpdate();
			db.closeConnection();
			 
		}catch(SQLException e){System.out.println(e);}
		if(row ==1) {
			return true;
		}else {
			return false;
		}		

	}
	
	

	// UPDATE User
	
	@Override
	public boolean updateUser(Object object) {
		try {
			User user = (User)object;
			
		PreparedStatement ps = db.getConnection().prepareStatement("update user set password= ? where empId = ? ");
		ps.setString(5,user.getPassword());
		ps.setInt(1,user.getEmpId());
		row = ps.executeUpdate();
		db.closeConnection();
		 
	}catch(SQLException e2){System.out.println(e2);}
	if(row ==1) {
		return true;
	}else {
		return false;
	}
	}

	
	// Delete Specific User
	
	@Override
	public boolean deleteUser(String userId) {
		// TODO Auto-generated method stub
		try {
			//User user = (User)object;							
			PreparedStatement ps = db.getConnection().prepareStatement("delete from user where empID = ? ");
			
			
			ps.setString(1, userId);
			
			row = ps.executeUpdate();
			db.closeConnection();
			 
		}catch(SQLException e3){System.out.println(e3);}
		if(row ==1) {
			return true;
		}else {
			return false;
		}
		
	}
	
	//Retrieve User by ID

	@Override
	public User getUser(String userId) {
		User u1 =new User();
	//	LinkedList<User> list = new LinkedList<User>();
		   try{
			   PreparedStatement ps = db.getConnection().prepareStatement("select * from user where employeeUserID = ?");
			   ps.setString(1,userId);
			   ResultSet rs = ps.executeQuery();
			  

			   while (rs.next()) {
			
				   
					u1.setEmpId(rs.getInt(1));
					u1.setEmpName(rs.getString(2));
					u1.setEmpUserId(rs.getString(3));
					u1.setEmployeeRole(rs.getString(4));
					u1.setPassword(rs.getString(5));
				//	list.add(u1);
				}
			  
			 }catch(SQLException e5){e5.printStackTrace();}
		   return u1;
		
	
	}

	//  RETRIEVE All Users
	
	
	public List<User> getAllUsers() {
			
			LinkedList<User> list = new LinkedList<User>();
		   try{
			   PreparedStatement ps = db.getConnection().prepareStatement("select * from user");
			   ResultSet rs = ps.executeQuery();
			  
	
			   while (rs.next()) {
				 //  @Autowired
				   User u1 =new User();
					u1.setEmpId(rs.getInt(1));
					u1.setEmpName(rs.getString(2));
					u1.setEmpUserId(rs.getString(3));
					u1.setEmployeeRole(rs.getString(4));
					u1.setPassword(rs.getString(5));
					list.add(u1);
				}
			  
			 }catch(SQLException e4){e4.printStackTrace();}
		   return list;
	}
	
//	//User by Role
public List<User> getAllUsers(String role) {
		
		LinkedList<User> list = new LinkedList<User>();
	   try{
		   PreparedStatement ps = db.getConnection().prepareStatement("select * from user where role = ?");
		   ps.setString(1, role);
		   ResultSet rs = ps.executeQuery();
		  

		   while (rs.next()) {
			 //  @Autowired
			   User u1 =new User();
				u1.setEmpId(rs.getInt(1));
				u1.setEmpName(rs.getString(2));
				u1.setEmpUserId(rs.getString(3));
				u1.setEmployeeRole(rs.getString(4));
				u1.setPassword(rs.getString(5));
				list.add(u1);
			}
		  
		 }catch(SQLException e4){e4.printStackTrace();}
	   return list;
}

//Change Password

	@Override
	public boolean changePassword(String userID,String newPassword) {
		try {
				//	User user = (User)object;
					
				PreparedStatement ps = db.getConnection().prepareStatement("update user set password= ? where empId = ? ");
				ps.setString(1,newPassword);
				
				ps.setString(2, userID);
				
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
