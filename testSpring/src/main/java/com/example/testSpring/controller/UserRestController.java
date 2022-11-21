package com.example.testSpring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.testSpring.model.MyUser;
import com.example.testSpring.service.UserService;

@RestController //Controlador REST
@RequestMapping("/api") //raíz de la URL. http://127.0.0.1:8080/api/

public class UserRestController {
	
	@Autowired
	private UserService userService;
	
	//GET
	//http://127.0.0.1:8080/api/users
	@GetMapping("/users")
	public List<MyUser> findAll(){
		return userService.findAll();
	}
	
	//GET
	//http://127.0.0.1:8080/api/users/1
	@GetMapping("/users/{userId}")
	public MyUser getUser(@PathVariable int userId) {
		MyUser user = userService.findById(userId);
		return user;
	}
	
	//POST
	//http://127.0.0.1:8080/api/users
	@PostMapping("/users")
	public MyUser addUser(@RequestBody MyUser user) {
		userService.save(user);
		return user;
	}
	
	//PUT
	//http://127.0.0.1:8080/api/users
	@PutMapping("/users")
	public MyUser updateUser(@RequestBody MyUser user) {
		userService.update(user);
		return user;
	}
	
	//DELETE
	//http://127.0.0.1:8080/api/users/1
	@DeleteMapping("users/{userId}")
	public String deleteUser(@PathVariable int userId) {
		MyUser user = userService.findById(userId);
		userService.deleteById(userId);
		return "Deleted user id - "+userId;
	}
}
