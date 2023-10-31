package br.com.msinfotec.userapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import br.com.msinfotec.userapi.domain.User;
import br.com.msinfotec.userapi.repositories.UserRepository;

@SpringBootApplication
@EnableDiscoveryClient
public class UserApiApplication implements CommandLineRunner  {
	

	@Autowired
	private UserRepository userRepository;

	
	public static void main(String[] args) {
		SpringApplication.run(UserApiApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		userRepository.saveAll(List.of(
				new User(null, "Fulvio Pimentel", "fulviofp@hotmail.com", "123", 50.0),
				new User(null, "Felipe Pimentel", "felipe@hotmail.com", "123", 50.0),
				new User(null, "Fernando Pimentel", "fernando@hotmail.com", "123", 50.0),
				new User(null, "Fabio Pimentel", "fabio@hotmail.com", "123", 50.0)
				));
		
	}


}
