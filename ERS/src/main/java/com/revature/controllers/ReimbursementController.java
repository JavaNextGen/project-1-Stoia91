package com.revature.controllers;

import java.util.List;

import com.google.gson.Gson;
import com.revature.models.Reimbursement;
import com.revature.services.ReimbursementService;

import io.javalin.http.Handler;

public class ReimbursementController {
	ReimbursementService rs = new ReimbursementService();

	// *****This layer is where we'll parse our JSON into Java objects and vice vera*****
	// Sits between the Javalin Front Controller and the Service Layer
	// We'll either be getting data from the service layer (which is our DAO)
	// ORR sending data to the service layer (will probably return some response that it was successful)
	
	public Handler getReimbursementsHandler = (ctx) -> {
		if(ctx.req.getSession() != null) { //if the session exist
			
			List<Reimbursement> allReimbursements = rs.getReimbursements();
			
			// Add the dependency into your pom.xml so it can import the Gson library
			Gson gson = new Gson();
			
			// Use gson library to convert the java object to a JSON string
			String JSONEmployees = gson.toJson(allReimbursements);
			
			// Give a response body with a JSON string 
			ctx.result(JSONEmployees);
			ctx.status(200);
			

		} else {
			ctx.result("Oh no you failed to get the Reimbursements!!!!");
			ctx.status(404);
		}
	};
	
	public Handler insertReimbursementHandler = (ctx) -> {
		
		if(ctx.req.getSession() != null) {
			String body = ctx.body();
			
			Gson gson = new Gson();
			
			Reimbursement reimbursement = gson.fromJson(body, Reimbursement.class);
			
			rs.addReimbursement(reimbursement);
			
			ctx.result("Reimbursement was successfully added!");
			ctx.status(201);
			
		} else {
			ctx.result("Oh no you failed to insert a Reimbursement!!!!");
			ctx.status(404);
		}
		
		
	};
}
