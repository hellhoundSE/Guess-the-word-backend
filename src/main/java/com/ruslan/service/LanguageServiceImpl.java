package com.ruslan.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruslan.dao.LanguageDAO;
import com.ruslan.model.Language;

@Service
public class LanguageServiceImpl implements LanguageService {
	
	@Autowired
	LanguageDAO languageDAO;

	@Override
	@Transactional
	public void save(Language language) {
		languageDAO.save(language);
	}

	@Override
	@Transactional
	public Language findById(int id) {
		return languageDAO.findById(id);
	}

	@Override
	@Transactional
	public List<Language> findAll() {
		return languageDAO.findAll();
	}

}
