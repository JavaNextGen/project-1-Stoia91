package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.revature.models.User;
import com.revature.util.ConnectionFactory;

public class UserDAO {
public void insertUser(User newUser) { //This is INSERT functionality 
        
        try(Connection conn = ConnectionFactory.getConnection()){

            //we'll create a SQL statement using parameters to insert a new Reimbursement
            String sql = "INSERT INTO users (username, userpassword, f_name, l_name, email, role_id) " //creating a line break for readability
                        + "VALUES (?, ?, ?, ?, ?, ?); "; //these are parameters!! We have to specify the value of each "?"
            
            PreparedStatement ps = conn.prepareStatement(sql); //we use PreparedStatements for SQL commands with variables
            
                ps.setString(1, newUser.getUsername());
                ps.setString(2, newUser.getUserpassword());
                ps.setString(3, newUser.getF_name());
                ps.setString(4, newUser.getL_name());
                ps.setString(5, newUser.getEmail());
                ps.setInt(6, newUser.getRole_id());
                  
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
