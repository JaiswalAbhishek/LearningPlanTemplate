package org.learning.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import org.learning.dao.DBConnection;
import org.learning.dao.LoginDAO;
import org.learning.model.Login;

@Component
public class DefaultLoginDAO implements LoginDAO {

	@Autowired
	DBConnection dBConnection;
	
	@Override
	public Login getLoginDetails(String userid)  {
			Connection con = dBConnection.getConnection();
			Login login = new Login();
			try {
				PreparedStatement ps = dBConnection.getConnection().prepareStatement("select * from user where employeeUserID = ?");
				ps.setString(1,userid);
				ResultSet rs = ps.executeQuery();

				while (rs.next()) {
					login.setUserid(rs.getString("employeeUserID"));
					login.setPassword(rs.getString("password"));
					//login.setRole(rs.getString("role"));
				}
			}catch (SQLException sqle) {}
			finally {try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}}
			
			return login;

	}

	@Override
	public String getRole(String userid) {
		Connection con = dBConnection.getConnection();
		String role = null;
		try {
			PreparedStatement ps = dBConnection.getConnection().prepareStatement("select role from user where employeeUserID = ?");
			ps.setString(1,userid);
			ResultSet rs = ps.executeQuery();
			 
			while (rs.next()) {
				role = rs.getString("role");
			}
		}catch (SQLException sqle) {}
		finally {try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}
		return role;
	}
	
	

}
