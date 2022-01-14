package com.revature.services;

import com.revature.models.User;
import com.revature.repositories.AuthDAO;

public class AuthService {
	AuthDAO aDAO = new AuthDAO();
	
public int login(String username, String password) {
	try {
		User user = aDAO.getUser(username,password);
		String checkUsername = user.getUsername();
		String checkPassword = user.getUserpassword();
		int role = user.getRole_id();
		if(username.equals(checkUsername)&& password.equals(checkPassword)&& role == 1){
			return 1;
		}else if (username.equals(checkUsername)&& password.equals(checkPassword)&& role == 2) {
			return 2;
		}
		else {
			return 0;
		}
	}
	catch(IndexOutOfBoundsException e){
		System.out.println("The username or password did not match the system.");
		return 0;
	}
}

public int getID(String username, String password) {
	
	return aDAO.getID(username, password);
}
}
