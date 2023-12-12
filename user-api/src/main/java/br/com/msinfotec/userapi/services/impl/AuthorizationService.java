package br.com.msinfotec.userapi.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.msinfotec.userapi.domain.User;
import br.com.msinfotec.userapi.repositories.UserRepository;

@Service
public class AuthorizationService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = (User) userRepository.findByEmail(username);
		if(user == null) {
			throw new UsernameNotFoundException("User not found");
		}
		
		return user;
	}
}
