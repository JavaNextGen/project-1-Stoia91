package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Reimbursement;
import com.revature.models.User;
import com.revature.util.ConnectionFactory;

public class AuthDAO {
public User getUser(String username, String password) { //This will use SQL SELECT functionality
	
	try(Connection conn = ConnectionFactory.getConnection()){ //all of my SQL stuff will be within this try block
		
		//Initialize an empty ResultSet object that will store the results of our SQL query
		ResultSet rs = null;
		
		//write the query that we want to send to the database, and assign it to a String
		String sql = "SELECT * FROM users WHERE username = ?;";
		
		//Put the SQL query into a Statement object (The Connection object has a method for this!!)
		PreparedStatement ps = conn.prepareStatement(sql); //we use PreparedStatements for SQL commands with variables
		
		//use the PreparedStatement objects' methods to insert values into the query's ?s
		//the values will come from the Employee object we send in.
		 //1 is the first ?, 2 is the second, etc.
		ps.setString(1, username);
		
		
		//this executeUpdate() method actually sends and executes the SQL command we built
		
		
		//EXECUTE THE QUERY, by putting the results of the query into our ResultSet object
		//The Statement object has a method that takes Strings to execute as a SQL query
		rs = ps.executeQuery();
		
		//All the code above makes a call to your database... Now we need to store the data in an ArrayList.
		
		//create an empty ArrayList to be filled with the data from the database;
		
		//while there are results in the resultset...
		rs.next();
			
			//Use the all args constructor to create a new Employee object from each returned row from the DB
			User u = new User(
					//we want to use rs.get for each column in the record
					rs.getInt("user_id"),
					rs.getString("username"),
					rs.getString("userpassword"),
					rs.getString("f_name"),
					rs.getString("l_name"),
					rs.getString("email"),
					rs.getInt("role_id")
					);
			
			
//			private int user_id;
//			private String username;
//			private String userpassword;
//			private String f_name;
//			private String l_name;
//			private String email;
//			private int role_id;
			//and populate the ArrayList with each new Employee object
			 //e is the new Employee object we created above
	
		
					
		//when there are no more results in rs, the while loop will break
		//then, return the populated ArrayList of Employees
		return u;
		
	} catch (SQLException e) {
		System.out.println("Something went wrong logging in!");
		e.printStackTrace();
	}
	
	return null; //we add this after the try/catch block, so Java won't yell
	//(Since there's no guarantee that the try will run)
}

}
