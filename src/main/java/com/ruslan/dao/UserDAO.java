package com.ruslan.dao;

import java.util.List;

import com.ruslan.model.User;

public interface UserDAO {

	public User findUserById(int id);
	
	public void save(User user);
	
	public void deleteById(int theID);

	public List<User> findAll();
	
	public User findUserByName(String name);
}
