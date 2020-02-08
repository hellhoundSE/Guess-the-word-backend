package com.ruslan.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ruslan.model.Game;
import com.ruslan.model.User;

@Service
public interface GameService {
	
	public void save(Game game);
	
	public List<Game> findAll();
	
	public List<Game> findByUser(User user);
	
	public Game findById(int id);
	
}
