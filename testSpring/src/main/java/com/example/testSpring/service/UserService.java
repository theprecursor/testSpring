package com.example.testSpring.service;

import java.util.List;

import com.example.testSpring.model.MyUser;

public interface UserService {
	public List<MyUser> findAll();

	public MyUser findById(int id);

	public void save(MyUser user);
	
	public void update(MyUser user);

	public void deleteById(int id);
}
