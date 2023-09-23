package com.jspider.car_dekho_mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspider.car_dekho_mvc.pojo.UserPOJO;
import com.jspider.car_dekho_mvc.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;

	public UserPOJO checkLogin(String username, String password) {
		UserPOJO user = repository.checkLogin(username, password);
		return user;
	}

	public UserPOJO createNewAccount(String username, String password) {
		UserPOJO user = repository.createNewAccount(username, password);
		return user;
	}

}
