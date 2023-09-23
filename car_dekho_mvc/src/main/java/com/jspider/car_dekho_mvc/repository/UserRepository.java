package com.jspider.car_dekho_mvc.repository;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.jspider.car_dekho_mvc.pojo.UserPOJO;

@Repository
public class UserRepository {
	
	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;
	private static Query query;
	
	private static void openConnection() {
		factory = Persistence.createEntityManagerFactory("Car");
		manager = factory.createEntityManager();
		transaction = manager.getTransaction();
	}
	
	private static void closeConnection() {
		if (factory != null) {
			factory.close();
		}
		if (manager != null) {
			manager.close();
		}
		
		if (transaction != null) {
			if (transaction.isActive()) {
				transaction.rollback();
			}
		}
	}

	public UserPOJO checkLogin(String username, String password) {
		openConnection();
		transaction.begin();
		
		UserPOJO user = manager.find(UserPOJO.class, username);
		
		if (user != null) {
			if ((user.getPassword()).equals(password)) {
				transaction.commit();
				closeConnection();
				return user;
			}
		}
		transaction.commit();
		closeConnection();
		
		return null;
	}

	public UserPOJO createNewAccount(String username, String password) {
		openConnection();
		transaction.begin();
		
		UserPOJO user = new UserPOJO();
		user.setUsername(username);
		user.setPassword(password);
		
		try {
			manager.persist(user);
			transaction.commit();
			closeConnection();
			return user;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		closeConnection();
		return null;
	}


}
