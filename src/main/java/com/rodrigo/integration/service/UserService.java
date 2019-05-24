package com.rodrigo.integration.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rodrigo.integration.domain.User;
import com.rodrigo.integration.domain.UserDTO;
import com.rodrigo.integration.repository.UserRepository;
import com.rodrigo.integration.service.Exceptions.ObjectNotFoundException;


@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepo;
	
	public User findById(String id) {
		Optional<User> user = userRepo.findById(id);
		return user.orElseThrow(() -> new ObjectNotFoundException("User ID is invalid!"));
	}
	
	public List<User> findAll() {
		return userRepo.findAll();
	}
	
	public User insert(User user) {
		return userRepo.insert(user);
	}
	
	public User update(User user) {
		User newUser = findById(user.getId());
		updateUser(newUser, user);
		return userRepo.save(newUser);
	}
	
	public void delete(String id) {
		findById(id);
		userRepo.deleteById(id);
	}
	
	public User fromDto(UserDTO userDto) {
		return new User(userDto.getId(), userDto.getUsername(), userDto.getEmail());
	}
	
	private void updateUser(User newUser, User user) {
		newUser.setUsername(user.getUsername());
		newUser.setEmail(user.getEmail());
	}
	
}
