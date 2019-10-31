package org.learning.service.impl;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import org.learning.dao.LoginDAO;
import org.learning.model.Login;
import org.learning.service.LoginService;

@Component
public class DefaultLoginService implements LoginService {

	@Autowired
	LoginDAO defaultLoginDAO;
	@Override
	public boolean validateLogin(String userid, String password) {
		Login login = defaultLoginDAO.getLoginDetails(userid);
		if (login.getPassword().equals(password))
			return true;
		else return false;
	}

}
