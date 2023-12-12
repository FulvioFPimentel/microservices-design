package br.com.msinfotec.userapi.resources.impl;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.msinfotec.userapi.domain.User;
import br.com.msinfotec.userapi.domain.DTO.UserDTO;
import br.com.msinfotec.userapi.resources.UserResource;
import br.com.msinfotec.userapi.services.UserService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/users") 
public class UserResourceImpl implements UserResource {
	
	private final UserService service;

	@Override
	public ResponseEntity<User> findById(Long id) {
		return ResponseEntity.ok().body(service.findById(id));
	} 
	
	@Override
	public ResponseEntity<List<UserDTO>> findAll() {
		return ResponseEntity.ok().body(service.findall());
	}

}
