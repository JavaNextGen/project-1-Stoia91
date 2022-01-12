package com.revature.services;

import com.revature.models.User;
import com.revature.repositories.UserDAO;

public class UserService {

    UserDAO uDAO = new UserDAO();
        public void insertUser(User newUser) {
            
            //take in the Employee object sent from the menu and send it to the EmployeeDAO to be inserted into the database
            
            //call the DAO method that inserts the new Employee
            uDAO.insertUser(newUser);
        }
    
    

        
}    
