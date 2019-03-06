package com.social;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.social.model.Post;
import com.social.model.User;
import com.social.repository.PostRepo;
import com.social.repository.UserRepo;

import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class SocialAPI implements CommandLineRunner {

	private static final Set<String> CONSUME_TYPE = new HashSet<>(Arrays.asList("application/json", "application/xml"));
	@Autowired
	UserRepo userRepo;
	@Autowired
	PostRepo postRepo;

	public static void main(String[] args) {
		SpringApplication.run(SocialAPI.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User user = new User();
		user.setName("Ziaul Haq");
		user.setBirtDate(LocalDate.now());
		
		Post post=new Post();
		post.setComment("thos os for test");
		post.setUser(user);
		userRepo.save(user);
		postRepo.save(post);
		

	}

	@Bean
	public Docket docket() {
		return new Docket(DocumentationType.SWAGGER_2).consumes(CONSUME_TYPE);
	}

}
