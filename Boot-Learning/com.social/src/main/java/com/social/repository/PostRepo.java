package com.social.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.social.model.Post;

public interface PostRepo extends JpaRepository<Post, Integer> {

}
