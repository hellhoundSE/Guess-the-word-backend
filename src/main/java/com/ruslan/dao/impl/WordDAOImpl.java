package com.ruslan.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ruslan.dao.WordDAO;
import com.ruslan.model.Language;
import com.ruslan.model.Word;

@Component
public class WordDAOImpl implements WordDAO {

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public void save(Word word) {
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(word);
	}

	@Override
	public Word findWordByLanguage(Language language) {
		Session session = entityManager.unwrap(Session.class);
		Query<Word> query = session.createQuery("from Word where Language_language_id = :languageId ", Word.class);
		query.setParameter("languageId", language.getId());
		List<Word> list = query.getResultList();
		return list.get((int)(Math.random()*list.size()));
	}
	@Override
	public List<Word> findAll() {
		Session session = entityManager.unwrap(Session.class);
		Query<Word> query = session.createQuery("from Word", Word.class);
		List<Word> list = query.getResultList();
		return list;
	}

	@Override
	public Word findWordByText(String text) {
		Session session = entityManager.unwrap(Session.class);
		Query<Word> query = session.createQuery("from Word where word = :text ", Word.class);
		query.setParameter("text", text);
		Word word = query.getSingleResult();
		return word;
	}

}
