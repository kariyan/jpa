package kr.or.kosta.edu.provider.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import kr.or.kosta.edu.domain.User;
import kr.or.kosta.edu.domain.UserPk;
import kr.or.kosta.edu.provider.UserProvider;
import kr.or.kosta.edu.util.JpaUtil;

public class UserProviderImpl implements UserProvider {

	public User findUserByUserId(UserPk userId) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		User foundUser = em.find(User.class,  userId);
		
		tx.commit();
		em.clear();
		
		return foundUser;
	}

	public List<User> findAllUsers() {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		List<User> users = em.createQuery("from User u order by u.userName asc", User.class).getResultList();
		
		tx.commit();
		em.clear();
		
		return users;
	}

	public void insertUser(User user) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		em.persist(user);
		
		tx.commit();
		em.clear();
	}

	public void updateUser(User user) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		em.merge(user);
		
		tx.commit();
		em.clear();
	}
	
	public void deleteUserByUserId(UserPk userId) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		User foundUser = em.find(User.class, userId);
		em.remove(foundUser);
		
		tx.commit();
		em.clear();
	}
}
