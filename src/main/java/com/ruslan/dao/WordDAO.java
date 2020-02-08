package com.ruslan.dao;

import java.util.List;

import com.ruslan.model.Language;
import com.ruslan.model.Word;

public interface WordDAO {
	
	public void save(Word word);
	
	public Word findWordByLanguage(Language lang);
	
	public List<Word> findAll();
	
	public Word findWordByText(String text);
}
