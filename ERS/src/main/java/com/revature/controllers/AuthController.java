package com.revature.controllers;

import com.google.gson.Gson;
import com.revature.models.LoginDTO;
import com.revature.models.User;
import com.revature.services.AuthService;

import io.javalin.http.Handler;

public class AuthController {

	AuthService as = new AuthService();

	public Handler loginHandler = (ctx) -> {
		
		//what's the request body? (which we get from ctx.body) it's the data that gets sent in with a request
		//GET requests will have empty request bodies, but POST requests, which send data, will have some data.
		String body = ctx.body(); //turn the body (data) of the POST request into a Java String
		
		Gson gson = new Gson(); //create a new Gson object to make Java <-> JSON conversions
		
		User user = gson.fromJson(body, User.class); //turn that JSON String into a LoginDTO object
		
		
		//control flow to determine what happens in the event of successful/unsuccessful login
		//invoke the login() method of the AuthService using the username and password from the LoginDTO
		if(as.login(user.getUsername(), user.getUserpassword()) == 2) {
			
		
			//create a user session so that they can access the applications other functionalities
			ctx.req.getSession(); //req is a "Request Object", we establish sessions through it
			
			//return a successful status code 
			ctx.status(202); //202 - accepted. (but you could use any 200 level status code)
			
			//send a message relaying the success
			ctx.result("Login Success!");
			
		}else if (as.login(user.getUsername(), user.getUserpassword()) == 1){
			
			//create a user session so that they can access the applications other functionalities
			ctx.req.getSession(); //req is a "Request Object", we establish sessions through it
			
			//return a successful status code 
			ctx.status(201); 
			
			//send a message relaying the success
			ctx.result("Login Success!");
		}
		
		else {
			
			ctx.status(401); //"unauthorized" status code
			ctx.result("Login Failed! :(");
			
		}
		
	};

	public Handler getUserIDhandler = (ctx) -> {
		
		if(ctx.req.getSession() != null) {


		String body = ctx.body(); //turn the body (data) of the POST request into a Java String

		Gson gson = new Gson(); //create a new Gson object to make Java <-> JSON conversions
		
		User user = gson.fromJson(body, User.class); //turn that JSON String into a LoginDTO object
		@SuppressWarnings("deprecation")
		Integer intid = new Integer(as.getID(user.getUsername(), user.getUserpassword()));
		
		String id = intid.toString();
		//control flow to determine what happens in the event of successful/unsuccessful login
		//invoke the login() method of the AuthService using the username and password from the LoginDTO
		ctx.result(id);
		ctx.status(200);
		}else {
			ctx.result("UserName/Password pair not found");
			ctx.status(404);
		}
	};
}
