package com.ruslan.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ruslan.dao.UserDAO;
import com.ruslan.model.User;
import com.ruslan.model.Word;

@Component
public class UserDAOImpl implements UserDAO{

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public User findUserById(int id) {
		Session session = entityManager.unwrap(Session.class);
		User user = session.get(User.class, id);
		return user;
	}

	@Override
	public void save(User user) {
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(user);
	}

	@Override
	public void deleteById(int theID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> findAll() {
		Session session = entityManager.unwrap(Session.class);
		Query<User> query = session.createQuery("from User", User.class);
		List<User> list = query.getResultList();
		return list;
	}

	@Override
	public User findUserByName(String name) {
		Session session = entityManager.unwrap(Session.class);
		Query<User> query = session.createQuery("from User where name = :name ", User.class);
		query.setParameter("name", name);
		List<User> list = query.getResultList();
		if(list.size() > 0)
			return list.get(0);
		return null;
	}

}
