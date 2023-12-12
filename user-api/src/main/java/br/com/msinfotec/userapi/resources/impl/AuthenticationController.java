package br.com.msinfotec.userapi.resources.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.msinfotec.userapi.domain.User;
import br.com.msinfotec.userapi.repositories.UserRepository;

@RestController
@RequestMapping(value = "auth")
public class AuthenticationController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("/login")
	public ResponseEntity<User> login(@RequestBody User data) {
		
		UsernamePasswordAuthenticationToken usernamePassword = 
				new UsernamePasswordAuthenticationToken(data.getEmail(), data.getPassword());
				this.authenticationManager.authenticate(usernamePassword);
				
		return ResponseEntity.ok().build();
	}
	
	@PostMapping("/register")
	public ResponseEntity<User> regiter(@RequestBody User data) {
		if(this.userRepository.findByEmail(data.getEmail()) != null) return ResponseEntity.badRequest().build();
		
		String encryptedPassword = new BCryptPasswordEncoder().encode(data.getPassword());
		
		User newUser = new User(
				data.getName(), 
				data.getEmail(), 
				encryptedPassword, 
				data.getRoles(), 
				data.getHourlyPrice());
		
		userRepository.save(newUser);
		
		return ResponseEntity.ok().build();
	}
}
