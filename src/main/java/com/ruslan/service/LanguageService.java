package com.ruslan.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ruslan.model.Language;

@Service
public interface LanguageService {
	
	public void save(Language language);
	
	public Language findById(int id);
	
	public List<Language> findAll();
	
}
