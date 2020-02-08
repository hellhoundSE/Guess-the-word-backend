package com.ruslan.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ruslan.model.Language;
import com.ruslan.model.Word;

@Service
public interface WordService {
	
	public void save(Word word);
	
	public Word findWordByLanguage(Language lang);
	
	public List<Word> findAll();
	
	public Word findWordByText(String text);
}
