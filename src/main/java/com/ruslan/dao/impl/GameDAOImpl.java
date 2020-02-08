package com.ruslan.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ruslan.dao.GameDAO;
import com.ruslan.model.Game;
import com.ruslan.model.User;

@Component
public class GameDAOImpl implements GameDAO {
	
	@Autowired
	private EntityManager entityManager;
	


	@Override
	public void save(Game game) {
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(game);
		
	}

	@Override
	public List<Game> findAll() {
		Session session = entityManager.unwrap(Session.class);
		Query<Game> query = session.createQuery("from Game", Game.class);
		List<Game> list = query.getResultList();
		return list;
	}

	@Override
	public List<Game> findByUser(User user) {
		Session session = entityManager.unwrap(Session.class);
		Query<Game> query = session.createQuery("from Game where User_user_id = :userId", Game.class);
		query.setParameter("userId", user.getId());
		List<Game> list = query.getResultList();
		return list;
	}

	@Override
	public Game findById(int id) {
		Session session = entityManager.unwrap(Session.class);
		Game game = session.get(Game.class, id);
		return game;
	}

	

}
