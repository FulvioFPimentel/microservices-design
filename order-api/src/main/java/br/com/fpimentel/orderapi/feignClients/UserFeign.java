package br.com.fpimentel.orderapi.feignClients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.fpimentel.orderapi.domain.User;

@FeignClient(name = "user-api")
public interface UserFeign {
	
	@GetMapping(value = "/api/users/user/{id}")
	ResponseEntity<User> userFindById(@PathVariable Long id);

}
