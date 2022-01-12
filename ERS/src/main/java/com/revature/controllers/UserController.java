package com.revature.controllers;

import com.google.gson.Gson;
import com.revature.models.User;
import com.revature.services.UserService;

import io.javalin.http.Handler;

public class UserController {
    
    
UserService us = new UserService();
    
public Handler insertUserHandler = (ctx) -> {
    
    if(ctx.req.getSession() != null) {
        String body = ctx.body();
        
        Gson gson = new Gson();
        
        User user = gson.fromJson(body, User.class);
        
        us.insertUser(user);
        
        
        ctx.result("User was successfully added!");
        ctx.status(201);
        
    } else {
        ctx.result("Oh no you failed to insert a user!!!");
        ctx.status(404);
    }
    
    
};
}