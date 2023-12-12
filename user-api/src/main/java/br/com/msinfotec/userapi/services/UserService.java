package br.com.msinfotec.userapi.services;

import java.util.List;

import br.com.msinfotec.userapi.domain.User;
import br.com.msinfotec.userapi.domain.DTO.UserDTO;

public interface UserService {
	
	User findById(Long id);
	
	List<UserDTO> findall();

}
