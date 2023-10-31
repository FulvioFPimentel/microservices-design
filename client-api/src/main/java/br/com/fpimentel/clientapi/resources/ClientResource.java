package br.com.fpimentel.clientapi.resources;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.fpimentel.clientapi.domain.Client;

public interface ClientResource {
	
	@PostMapping
	ResponseEntity<Client> Save(@RequestBody Client client);
	
	@GetMapping(value = "/{id}")
	ResponseEntity<Client> findById(@PathVariable Long id);
	
	@GetMapping
	ResponseEntity<List<Client>> findAll();
}
