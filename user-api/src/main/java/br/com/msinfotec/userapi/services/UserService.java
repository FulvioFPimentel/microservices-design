package br.com.msinfotec.userapi.services;

import java.util.List;

import br.com.msinfotec.userapi.domain.User;

public interface UserService {
	
	User findById(Long id);
	
	List<User> findall();

}
