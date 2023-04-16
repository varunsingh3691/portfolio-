package com.tap.springmvc.dao;

import org.springframework.stereotype.Component;

//importing the User class here such that data members and
//methods are accessed here
import com.tap.springmvc.model.User;

@Component
public interface UserDao {
	
	public abstract void saveUser(User un); 
	
}
