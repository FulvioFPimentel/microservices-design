package br.com.fpimentel.orderapi.feignClients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.fpimentel.orderapi.domain.Client;

@FeignClient(name = "client-api")
public interface ClientFeign {
	
		@GetMapping(value = "/api/clients/{id}")
		ResponseEntity<Client> clientFindById(@PathVariable Long id);
			
}
