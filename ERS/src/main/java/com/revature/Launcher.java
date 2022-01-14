package com.revature;

import java.sql.Connection;
import java.sql.SQLException;

import com.revature.controllers.AuthController;
import com.revature.controllers.ReimbursementController;
import com.revature.controllers.UserController;
import com.revature.repositories.ReimbursementDAO;
import com.revature.util.ConnectionFactory;

import io.javalin.Javalin;

public class Launcher {

	public static void main(String[] args) {
		

		UserController uc = new UserController();
		AuthController ac = new AuthController();
		ReimbursementController rc = new ReimbursementController();
		
		//Testing Database Connectivity - just testing whether our Connection (from ConnectionFactory) is successful
		try(Connection conn = ConnectionFactory.getConnection()){
			System.out.println("Connection Successful :)");
		} catch(SQLException e) {
			System.out.println("Connection failed");
			e.printStackTrace();
		}
//		ReimbursementDAO rDAO = new ReimbursementDAO();
//		System.out.println(rDAO.getReimbursements());
//		System.out.println("hi");
		//Here is the actual functionality of our application-------------------
		
		//spoiler alert... there will only be two lines of codes here
		
		
		//Instantiate a menu object
		// Menu menu = new Menu();
		
		//Use the Menu Class's displayMenu() method to give the user the menu
		// menu.displayMenu();
		
		
		//this^ was our entire main method, but now we're using Javalin below-------------------------

		Javalin app = Javalin.create(
					config -> {
						config.enableCorsForAllOrigins(); // allows the server to process JS requests from anywhere
					}
				).start(3000);
		
		
		app.get("/reimbursements", rc.getReimbursementsHandler);
		
		app.put("/reimbursements", rc.updateReimbursementHandler);
		
		app.post("/reimbursements", rc.insertReimbursementHandler);
		
		app.get("/reimbursements/{id}", rc.getReimbursementsByAuthorHandler);
		
		app.post("/users", uc.insertUserHandler);
		
		app.post("/login", ac.loginHandler);
		
		app.post("/login/getID", ac.getUserIDhandler);
		
	}

}