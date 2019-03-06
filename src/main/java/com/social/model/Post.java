package com.social.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class Post {

	@Id
	@GeneratedValue
	private Integer pid;
	private String comment;
	
	@JsonIgnore
	@ManyToOne
	private User user;

}
