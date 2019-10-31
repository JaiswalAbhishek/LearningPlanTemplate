package org.learning.dao;

import org.learning.model.Login;

public interface LoginDAO {
	public Login getLoginDetails(String userid);
	public String getRole(String userid);

}
