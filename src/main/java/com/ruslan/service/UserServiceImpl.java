package com.ruslan.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruslan.dao.UserDAO;
import com.ruslan.model.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDAO userDAO;
	
	@Override
	@Transactional
	public User findUserById(int id) {
		return userDAO.findUserById(id);
	}

	@Override
	@Transactional
	public void save(User user) {
		userDAO.save(user);
	}

	@Override
	@Transactional
	public void deleteById(int theID) {
		userDAO.deleteById(theID);
	}

	@Override
	@Transactional
	public List<User> findAll() {
		return userDAO.findAll();
	}

	@Override
	@Transactional
	public User findUserByName(String name) {
		return userDAO.findUserByName(name);
	}

}
