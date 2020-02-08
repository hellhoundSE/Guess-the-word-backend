package com.ruslan.dao;

import java.util.List;

import com.ruslan.model.Game;
import com.ruslan.model.User;

public interface GameDAO {

	public void save(Game game);
	
	public List<Game> findAll();
	
	public List<Game> findByUser(User user);
	
	public Game findById(int id);
}
