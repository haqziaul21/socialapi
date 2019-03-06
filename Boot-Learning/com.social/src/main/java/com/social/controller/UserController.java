package com.social.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.social.model.Post;
import com.social.model.User;
import com.social.repository.PostRepo;
import com.social.service.UserService;

@RestController
public class UserController {

	private UserService userService;

	@Autowired
	private PostRepo postRepo;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping(value = "/")
	public List<Post> geUsers() {
		List<Post> list = postRepo.findAll();
		return list;
	}

	@GetMapping(value = "/users")
	public ResponseEntity<List<User>> getAllUsers() {
		return new ResponseEntity<>(userService.getAllUser(), HttpStatus.OK);
	}

	@GetMapping("/users/{id}")
	public ResponseEntity<User> getUser(@PathVariable Integer id) {
		return new ResponseEntity<>(userService.getUser(id), HttpStatus.OK);

	}

	@PostMapping("/user")
	public ResponseEntity<String> createUser(@Valid @RequestBody User user) {
		User savedUser = userService.createResource(user);
		return new ResponseEntity<>(String.format("User Created with ID %s", savedUser.getId()), HttpStatus.CREATED);
	}

	@DeleteMapping("/user/{id}")
	public ResponseEntity<Void> delete(@Valid @PathVariable("id") Integer id) {
		userService.deleteResource(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

}
