package com.test.jpa.jpain10steps;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.test.jpa.jpain10steps.entity.User;
import com.test.jpa.jpain10steps.entity.UserRepository;
import com.test.jpa.jpain10steps.service.UserDAOService;

@Component
public class UserRepositoryServiceCommandLineRunner implements CommandLineRunner{
	private static final Logger log = LoggerFactory.getLogger(UserDAOServiceCommandLineRunner.class);
	
	@Autowired
	private UserRepository service;
	
	@Override
	public void run(String... args) throws Exception {
		User user = new User("Jack", "Admin");
		service.save(user);
		log.info("New User is created :" + user);
		
		Optional<User> userWithIdOne = service.findById(1L);
		log.info("User is retrieved:" + userWithIdOne);
		
		List<User> users = service.findAll();
		log.info("New User is created :" + users);
		
		service.deleteById(1L);
		log.info("User by Id: 1 is deleted");
	}
}