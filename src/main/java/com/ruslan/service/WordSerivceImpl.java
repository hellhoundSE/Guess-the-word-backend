package com.ruslan.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruslan.dao.WordDAO;
import com.ruslan.model.Language;
import com.ruslan.model.Word;

@Service
public class WordSerivceImpl implements WordService{

	
	@Autowired
	WordDAO wordDAO;
	
	@Override
	@Transactional
	public void save(Word word) {
		wordDAO.save(word);
		
	}
	@Transactional
	@Override
	public Word findWordByLanguage(Language lang) {
		return wordDAO.findWordByLanguage(lang);
	}

	@Transactional
	@Override
	public List<Word> findAll() {
		return wordDAO.findAll();
	}
	@Override
	public Word findWordByText(String text) {
		return wordDAO.findWordByText(text);
	}

}
