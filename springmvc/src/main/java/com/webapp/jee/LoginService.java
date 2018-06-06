package com.webapp.jee;

public class LoginService {
	public boolean validateUser(String user, String password) {
		return user.equalsIgnoreCase("AMAN") && password.equals("123456");
	}

}