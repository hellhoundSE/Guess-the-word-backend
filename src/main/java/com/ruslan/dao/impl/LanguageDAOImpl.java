package com.ruslan.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ruslan.dao.LanguageDAO;
import com.ruslan.model.Language;

@Component
public class LanguageDAOImpl implements LanguageDAO {

	@Autowired
	private EntityManager entityManager;
	

	
	@Override
	public void save(Language language) {
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(language);
	}

	@Override
	public Language findById(int id) {
		Session session = entityManager.unwrap(Session.class);
		Language language = session.get(Language.class, id);
		return language;
	}

	@Override
	public List<Language> findAll() {
		Session session = entityManager.unwrap(Session.class);
		Query<Language> query = session.createQuery("from Language", Language.class);
		List<Language> list = query.getResultList();
		return list;
	}

}
