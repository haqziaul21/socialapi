package com.social.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.social.model.User;

public interface UserRepo  extends JpaRepository<User, Integer>{

}
