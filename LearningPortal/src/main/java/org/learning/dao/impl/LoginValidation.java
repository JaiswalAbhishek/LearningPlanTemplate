package org.learning.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.learning.dao.DBConnection;
import org.learning.model.User;
/**/
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.springframework.stereotype.Component;
@Component
public class LoginValidation {
	
	
	public int validateUser(String id,String password){
		int flag = 0;
		DBConnection db = new DBConnection();
		
			try{
				Statement st = db.getConnection().createStatement();
			String queryString = "select * from User";
				//String queryString = "select * from User where employeeUserID="+id;
				ResultSet results = st.executeQuery(queryString);

				while (results.next()) 
				{
					                String userID = results.getString("employeeUserID");
					                String key = results.getString("password");
					                String userRole = results.getString("role");
				
					        
					                if(userID.equalsIgnoreCase(id) && key.equalsIgnoreCase(password))
					                {
					                	if(userRole.equalsIgnoreCase("Manager"))
					                	{
							                
						                	flag=1;
						                	System.out.println(userID+"	"+key);
					                	}
					                	else if(userRole.equalsIgnoreCase("Trainer"))
					                	{
						                	
						                	flag=2;
						                	System.out.println(userID+"	"+key);
					                	}
					                	else{
					                	
					                	}
					                }
					             
					                System.out.println(userID);
				}
			db.closeConnection();				 
			}catch(SQLException e){System.out.println(e);}
	return flag;
			}

}
