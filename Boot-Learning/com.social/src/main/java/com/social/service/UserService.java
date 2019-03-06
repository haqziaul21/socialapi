package com.social.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.social.exception.UserException;
import com.social.model.User;
import com.social.repository.UserRepo;

@Service
public class UserService {
	
	private UserRepo userRepo;

	public UserService(UserRepo userRepo) {
		this.userRepo = userRepo;
	}

	public User getUser(Integer id) {
		User user=null;
		try {
			user=userRepo.findById(id).get();
		} catch (Exception e) {
			throw new UserException(e.getMessage(),HttpStatus.NOT_FOUND);
		}
		return user;
	}

	public List<User> getAllUser() {
		List<User> list=null;
		try {
			list=userRepo.findAll();
		} catch (Exception e) {
			throw new UserException(e.getCause().getCause().getMessage(),HttpStatus.NOT_FOUND);
		}
		return list;
	}

	public User createResource(User user) {
		return userRepo.save(user);
	}

	public void deleteResource(Integer id) {
			userRepo.deleteById(id);
	}

}
