package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Reimbursement;
import com.revature.util.ConnectionFactory;

public class ReimbursementDAO {

	public List<Reimbursement> getReimbursements() { //This will use SQL SELECT functionality
		
		try(Connection conn = ConnectionFactory.getConnection()){ //all of my SQL stuff will be within this try block
			
			//Initialize an empty ResultSet object that will store the results of our SQL query
			ResultSet rs = null;
			
			//write the query that we want to send to the database, and assign it to a String
			String sql = "SELECT * FROM reimbursements;";
			
			//Put the SQL query into a Statement object (The Connection object has a method for this!!)
			Statement statement = conn.createStatement();
			
			//EXECUTE THE QUERY, by putting the results of the query into our ResultSet object
			//The Statement object has a method that takes Strings to execute as a SQL query
			rs = statement.executeQuery(sql);
			
			//All the code above makes a call to your database... Now we need to store the data in an ArrayList.
			
			//create an empty ArrayList to be filled with the data from the database
			List<Reimbursement> reimbursementList = new ArrayList<>();
			
			//while there are results in the resultset...
			while(rs.next()) {
				
				//Use the all args constructor to create a new Employee object from each returned row from the DB
				Reimbursement r = new Reimbursement(
						//we want to use rs.get for each column in the record
						rs.getInt("id"),
						rs.getInt("author"),
						rs.getInt("amount"),
						rs.getInt("reimb_type"),
						rs.getInt("status"),
						rs.getInt("resolver")
						);
				
				//and populate the ArrayList with each new Employee object
				reimbursementList.add(r); //e is the new Employee object we created above
		
			}
						
			//when there are no more results in rs, the while loop will break
			//then, return the populated ArrayList of Employees
			return reimbursementList;
			
		} catch (SQLException e) {
			System.out.println("Something went wrong selecting Reimbursements!");
			e.printStackTrace();
		}
		
		return null; //we add this after the try/catch block, so Java won't yell
		//(Since there's no guarantee that the try will run)
		
	}
	
	
	
	public void insertReimbursement(Reimbursement newReimbursement) { //This is INSERT functionality 
		
		try(Connection conn = ConnectionFactory.getConnection()){
			
			//we'll create a SQL statement using parameters to insert a new Reimbursement
			String sql = "INSERT INTO reimbursements (author, amount, type, status, resolver) " //creating a line break for readability
					    + "VALUES (?, ?, ?, ?, ?); "; //these are parameters!! We have to specify the value of each "?"
			
			PreparedStatement ps = conn.prepareStatement(sql); //we use PreparedStatements for SQL commands with variables
			
			//use the PreparedStatement objects' methods to insert values into the query's ?s
			//the values will come from the Employee object we send in.
			ps.setInt(1, newReimbursement.getAuthor()); //1 is the first ?, 2 is the second, etc.
			ps.setInt(2, newReimbursement.getAmount());
			ps.setInt(3, newReimbursement.getReimb_type());
			ps.setInt(4, newReimbursement.getStatus());
			ps.setInt(5, newReimbursement.getResolver());
			
			
			//this executeUpdate() method actually sends and executes the SQL command we built
			ps.executeUpdate(); //we use executeUpdate() for inserts, updates, and deletes. 
			//we use executeQuery() for selects
			
			//send confirmation to the console if successful.
			System.out.println("Reimbursement " + " created.");
			
			
		} catch(SQLException e) {
			System.out.println("Add Reimbursement failed! :(");
			e.printStackTrace();
		}
		
	}



	
}
