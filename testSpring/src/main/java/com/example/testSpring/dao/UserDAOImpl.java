package com.example.testSpring.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.testSpring.model.MyUser;

@Repository
public class UserDAOImpl implements UserDAO{
	
	@Autowired
	private EntityManager entityManager;

	@Override
	public List<MyUser> findAll() {
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<MyUser> theQuery = currentSession.createQuery("from MyUser", MyUser.class);
		
		List<MyUser> users = theQuery.getResultList();
		
		return users;
	}

	@Override
	public MyUser findById(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		MyUser user = currentSession.get(MyUser.class, id);
		
		return user;
	}
	
	@Transactional
	@Override
	public void save(MyUser user) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(user);
	}
	
	@Transactional
	@Override
	public void update(MyUser user) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.merge(user);
	}

	@Transactional
	@Override
	public void deleteById(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<MyUser> theQuery = currentSession.createQuery("delete from MyUser where id=:idUser");
		
		theQuery.setParameter("idUser", id);
		theQuery.executeUpdate();
		
	}

}
