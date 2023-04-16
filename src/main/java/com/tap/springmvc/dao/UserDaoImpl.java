package com.tap.springmvc.dao;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.tap.springmvc.model.User;


//note control from controller comes here creates and object
//of StudentDaoImpl class and can use methods inside it

//spring mvc will manage the life cycle of this class now
@Component
public class UserDaoImpl implements UserDao {
	

	//spring will automatically create object of HibernateTemplate 
	//and inject it here such that we get a reference to that
	//object
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	//save user

	
	@Transactional  //so basically to create and read data
	public void saveUser(User un) {
		
		//for inserting data we take help of hibernate template
		this.hibernateTemplate.save(un);
	
	}

	//note the User class(model class) object is equivalent to
	//the row inside database
	
	
}
