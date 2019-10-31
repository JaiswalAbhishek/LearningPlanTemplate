package org.learning.util.impl;

import org.learning.dao.UserDAO;
import org.learning.model.User;
import org.learning.util.ValidatorUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class DefaultValidatorUtility implements ValidatorUtility {

	@Autowired
	UserDAO  defaultUserDAO;
	
	@Override
	public boolean validatePassword(String username,String password) {
		
		User user = defaultUserDAO.getUser(username);
		if (user.getPassword().equals(password))
			return true;
		else 
			return false;
		
		
	}
	
/*	@Autowired
	LoginDAO defaultLoginDAO;
	@Override
	public boolean validateLogin(String userid, String password) {
		Login login = defaultLoginDAO.getLoginDetails(userid);
		if (login.getPassword().equals(password))
			return true;
		else return false;
	}

	*/
	
	
}


