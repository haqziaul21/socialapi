package com.social.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Entity
@ApiModel(description = "All info about User")
@Data
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Size(min = 2, message = "Atleast must be of two character")
	@ApiModelProperty(notes = "Atleast must be of two character")
	private String name;

	@NotNull
	@PastOrPresent(message = "Future LocalDate is not allowed")
	@ApiModelProperty(notes = "Future LocalDate is not allowed")
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private LocalDate birtDate;
	@OneToMany(mappedBy = "user")
	private List<Post> posts = new ArrayList<Post>();
}
