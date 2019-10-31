package org.learning.dao;

import java.util.List;

import org.learning.model.User;

public interface UserDAO {

	public boolean createUser(User user);
	public boolean updateUser(Object object);

	public boolean changePassword(String userID,String newPassword);
	public boolean deleteUser(String userId);
	public User getUser(String userId);
	public List<User> getAllUsers();

	public List<User> getAllUsers(String role);
	
	
	
}
