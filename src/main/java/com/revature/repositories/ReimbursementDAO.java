package com.revature.repositories;

import com.revature.models.Reimbursement;
import com.revature.models.Status;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.revature.util.ConnectionFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class ReimbursementDAO {

    /**
     * Should retrieve a Reimbursement from the DB with the corresponding id or an empty optional if there is no match.
     */
    public Optional<Reimbursement> getById(int id) {
        return Optional.empty();
    }

    /**
     * Should retrieve a List of Reimbursements from the DB with the corresponding Status or an empty List if there are no matches.
     */
    public List<Reimbursement> getByStatus(Status status) {
    	try(Connection conn = ConnectionFactory.getConnection()){
			
			ResultSet rs = null;
			
			String sql = "select * from employees inner join roles "
					     + "on employees.role_id = roles.role_id where roles.role_title = ?";
			//we need to join employees to roles in order to access the role_title column and return employees
			//since I want to get employees based on something found in the roles table, we need a join 
			
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, title); //insert the method's argument as the first (and only) variable in the query
			
			rs = ps.executeQuery();	
			
			List<Reimbursement> reimbursementList = new ArrayList<>();
			
			while(rs.next()) { //while there are results in the result set...
				
				Reimbursement e = new Reimbursement( //create a new Employee Object from each returned row..
						rs.getInt("employee_id"),
						rs.getString("f_name"),
						rs.getString("l_name"),
						rs.getInt("role_id")
						);
				
				employeeList.add(e); //and populate the ArrayList with each created Role Object
			}
			
			return employeeList; //Finally, return the populated List of Roles.
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
    }

    /**
     * <ul>
     *     <li>Should Update an existing Reimbursement record in the DB with the provided information.</li>
     *     <li>Should throw an exception if the update is unsuccessful.</li>
     *     <li>Should return a Reimbursement object with updated information.</li>
     * </ul>
     */
    public Reimbursement update(Reimbursement unprocessedReimbursement) {
    	return null;
    }
}
