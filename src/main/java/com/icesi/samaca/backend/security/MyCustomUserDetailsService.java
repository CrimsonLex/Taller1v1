package com.icesi.samaca.backend.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.icesi.samaca.backend.model.person.UserApp;
import com.icesi.samaca.backend.repositories.UserRepository;

@Service
public class MyCustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserApp userApp = userRepo.findByUsername(username);
		
		if (userApp != null) {
			User.UserBuilder builder = User.withUsername(username).password(userApp.getPassword()).roles(userApp.getType().toString());
			return builder.build();
			
		} else {	
			throw new UsernameNotFoundException("User not found.");
		}
		
	}
}