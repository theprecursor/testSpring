package com.example.testSpring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.testSpring.dao.UserDAO;
import com.example.testSpring.model.MyUser;

@Service
public class UserServiceImpl  implements UserService{
	
	@Autowired
	private UserDAO userDAO;

	@Override
	public List<MyUser> findAll() {
		List<MyUser> listUsers = userDAO.findAll();
		return listUsers;
	}

	@Override
	public MyUser findById(int id) {
		MyUser user = userDAO.findById(id);
		return user;
	}

	@Override
	public void save(MyUser user) {
		userDAO.save(user);
	}
	
	@Override
	public void update(MyUser user) {
		userDAO.update(user);
	}

	@Override
	public void deleteById(int id) {
		userDAO.deleteById(id);
	}

}
