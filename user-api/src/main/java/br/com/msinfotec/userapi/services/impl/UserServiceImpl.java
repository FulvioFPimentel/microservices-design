	package br.com.msinfotec.userapi.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import br.com.msinfotec.userapi.domain.User;
import br.com.msinfotec.userapi.domain.DTO.UserDTO;
import br.com.msinfotec.userapi.repositories.UserRepository;
import br.com.msinfotec.userapi.services.UserService;
import br.com.msinfotec.userapi.services.exceptions.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

	private final UserRepository repository;
	private final Environment env;

	@Override
	public User findById(Long id) {
		log.info("PAYROLL_SERVICE ::: Get request on " + env.getProperty("local.server.port") + " port");
		return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Object not found"));
	}

	@Override
	public List<UserDTO> findall() {
		
		List<User> user = repository.findAll();

		return user.stream().map(x -> 
		new UserDTO(x.getName(), x.getEmail(), x.getRoles(), x.getHourlyPrice()))
				.collect(Collectors.toList());
	}
	
}
