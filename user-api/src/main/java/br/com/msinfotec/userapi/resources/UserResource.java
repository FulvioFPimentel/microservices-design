package br.com.msinfotec.userapi.resources;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.msinfotec.userapi.domain.User;
import br.com.msinfotec.userapi.domain.DTO.UserDTO;

public interface UserResource {
	
	@GetMapping(value = "/user/{id}")
	ResponseEntity<User> findById(@PathVariable Long id);
	
	@GetMapping
	ResponseEntity<List<UserDTO>> findAll();

}
