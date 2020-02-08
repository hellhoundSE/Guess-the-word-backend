package com.ruslan.dao;

import java.util.List;

import com.ruslan.model.Language;

public interface LanguageDAO {

	public void save(Language language);
	
	public Language findById(int id);
	
	public List<Language> findAll();
}
