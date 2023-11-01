package br.com.fpimentel.clientapi.resources.impl;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.fpimentel.clientapi.domain.Client;
import br.com.fpimentel.clientapi.resources.ClientResource;
import br.com.fpimentel.clientapi.services.ClientService;

@RestController
@RequestMapping(value = "/api/clients")
public class ClientResourceImpl implements ClientResource {
	
	@Autowired
	private ClientService service;

	@Override
	public ResponseEntity<Client> Save(Client client) {
		Client cli = service.Save(client);
		
		URI uri = ServletUriComponentsBuilder.
				fromCurrentRequest().path("/{id}").
				buildAndExpand(cli.getId()).toUri(); 
		return ResponseEntity.created(uri).body(cli);
	}

	@Override
	public ResponseEntity<Client> findById(Long id) {
		Client cli = service.findById(id);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(cli);
	}

	@Override
	public ResponseEntity<List<Client>> findAll() {
		List<Client> cli = service.findAll();
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(cli);
	}


}
