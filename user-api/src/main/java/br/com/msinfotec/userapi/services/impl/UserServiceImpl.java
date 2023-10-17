package br.com.msinfotec.userapi.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.msinfotec.userapi.domain.User;
import br.com.msinfotec.userapi.repositories.UserRepository;
import br.com.msinfotec.userapi.services.UserService;
import br.com.msinfotec.userapi.services.exceptions.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService{

	private final UserRepository repository;

	@Override
	public User findById(Long id) {		
		return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Object not found"));
	}

	@Override
	public List<User> findall() {
		return repository.findAll();
	}
	
}
