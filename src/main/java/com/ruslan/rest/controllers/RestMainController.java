package com.ruslan.rest.controllers;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ruslan.model.Game;
import com.ruslan.model.Language;
import com.ruslan.model.User;
import com.ruslan.model.Word;
import com.ruslan.service.MainService;

@RestController
@RequestMapping("/api")
public class RestMainController {
	
	@Autowired
	MainService mainService;

	@PostMapping("/player/{name}")
	public void postPlayer(@PathVariable String name){
		User user = mainService.getUserService().findUserByName(name);
		if(user == null) {
			user = new User(name);
			mainService.getUserService().save(user);
			System.out.println("new user added");
		}
		System.out.println(user);
	}
	
	@GetMapping("/player/{name}")
	public List<Game> getPlayerGames(@PathVariable String name){
		User user = mainService.getUserService().findUserByName(name);
		if(user != null) {
			return mainService.getGameService().findByUser(user);
		}
		return null;
	}
	
	
	@GetMapping("/languages")
	public List<Language> allLanguages(){
		System.out.println("i");
		return mainService.getLanguageService().findAll();
	}
	
	@PostMapping("/result")
	public void gameFinished(@RequestParam String name,@RequestParam String word,@RequestParam String win) {		
		Word wrd = mainService.getWordService().findWordByText(word);
		User user = mainService.getUserService().findUserByName(name);
		boolean isWin = win.equals("true")?true:false;
		Game game = new Game(user, wrd, isWin);
		mainService.getGameService().save(game);
		System.out.println("Game saved, "+name+" with word "+word +" result "+win);
	}
	
	@GetMapping("/languages/{languageCode}")
	public String wordByLanguage(@PathVariable String languageCode,HttpServletResponse response) {
		response.addHeader("Access-Control-Allow-Origin", "*");
		Language lang = null;
		for(Language language : mainService.getLanguageService().findAll()) {
			if(language.getCode().equals(languageCode)) {
				lang = language;
			}
		}
		if(lang == null) return "default";
		Word word = mainService.getWordService().findWordByLanguage(lang);
		return word.getWord();
	}
}
