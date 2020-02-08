package com.ruslan.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruslan.dao.GameDAO;
import com.ruslan.model.Game;
import com.ruslan.model.User;

@Service
public class GameServiceImpl implements GameService {

	@Autowired
	GameDAO gameDAO;
	
	@Override
	@Transactional
	public void save(Game game) {
		gameDAO.save(game);
	}

	@Override
	@Transactional
	public List<Game> findAll() {
		return gameDAO.findAll();
	}

	@Override
	@Transactional
	public List<Game> findByUser(User user) {
		return gameDAO.findByUser(user);
	}

	@Override
	@Transactional
	public Game findById(int id) {
		return gameDAO.findById(id);
	}

}
