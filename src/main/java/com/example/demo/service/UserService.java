package com.example.demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;

	public User addDetails(User user) {
		return userRepo.save(user);
	}

	public void updateUser(String email, String otp) {

		User user = userRepo.findByEmail(email);
		
		if(user !=  null) {
			user.setLoginOtp(otp);
			userRepo.save(user);
		}
	}
}
