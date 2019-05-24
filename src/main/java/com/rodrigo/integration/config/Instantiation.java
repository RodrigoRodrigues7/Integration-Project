package com.rodrigo.integration.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.rodrigo.integration.domain.User;
import com.rodrigo.integration.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepo;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		userRepo.deleteAll();
		
		User cheif = new User(null, "Master Cheif", "sierra177@gmail.com");
		User johnson = new User(null, "Sergeant Johnson", "Johnson@gmail.com");
		User arbiter = new User(null, "Thel Vadamee", "Sangheili@gmail.com");		
		
		userRepo.saveAll(Arrays.asList(cheif, johnson, arbiter));

	}
	
	
	
}
