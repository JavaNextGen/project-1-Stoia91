package com.revature.models;

public class User {
//declare variables and constructors to match columns in database table
	private int user_id;
	private String username;
	private String userpassword;
	private String f_name;
	private String l_name;
	private String email;
	private int role_id;
	
	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUsername() {
		return username;
	}

	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", username=" + username + ", userpassword=" + userpassword + ", f_name="
				+ f_name + ", l_name=" + l_name + ", email=" + email + ", role_id=" + role_id + "]";
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserpassword() {
		return userpassword;
	}

	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}

	public String getF_name() {
		return f_name;
	}

	public void setF_name(String f_name) {
		this.f_name = f_name;
	}

	public String getL_name() {
		return l_name;
	}

	public void setL_name(String l_name) {
		this.l_name = l_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}


	
	public User(String username, String userpassword, String f_name, String l_name, String email, int role_id) {
		this.username = username;
		this.userpassword = userpassword;
		this.f_name = f_name;
		this.l_name = l_name;
		this.email = email;
		this.role_id = role_id;
	}
	
	public User(int user_id, String username, String userpassword, String f_name, String l_name, String email, int role_id) {
		this.user_id = user_id;
		this.username = username;
		this.userpassword = userpassword;
		this.f_name = f_name;
		this.l_name = l_name;
		this.email = email;
		this.role_id = role_id;
	}
}

