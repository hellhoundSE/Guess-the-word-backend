package com.ruslan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Getter;

@Getter
@Service
public class MainService {

	@Autowired
	private LanguageService languageService;
	@Autowired
	private GameService gameService;
	@Autowired
	private WordService wordService;
	@Autowired
	private UserService userService;
}
