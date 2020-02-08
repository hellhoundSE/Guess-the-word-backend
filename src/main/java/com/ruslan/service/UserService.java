package com.ruslan.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ruslan.model.User;

@Service
public interface UserService {
	public User findUserById(int id);
	
	public void save(User user);
	
	public void deleteById(int theID);

	public List<User> findAll();
	
	public User findUserByName(String name);
}
