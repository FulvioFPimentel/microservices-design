package br.com.fpimentel.clientapi.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.fpimentel.clientapi.domain.Client;
import br.com.fpimentel.clientapi.repositories.ClientRepository;
import br.com.fpimentel.clientapi.services.ClientService;
import br.com.fpimentel.clientapi.services.exceptions.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ClientServiceImpl implements ClientService{

	private final ClientRepository repository;

	@Override
	public Client Save(Client client) {
	
		if(parameterNotNull(client)) {
			throw new ObjectNotFoundException("Required fields!");
		}
		
		Client cli = repository.save(client);
		return cli;
	}

	@Override
	public Client findById(Long id) {
		Optional<Client> cli = repository.findById(id);
		return cli.orElseThrow(() ->  new ObjectNotFoundException("Object not found"));
	}

	@Override
	public List<Client> findAll() {
		List<Client> cli = repository.findAll();
		return cli;
	}
	
	private boolean parameterNotNull (Client c) {
		
		if (c.getName().isBlank()
				|| c.getAddress().isBlank()
				|| c.getCellNumber().isBlank()) {
			return true;
		}
		return false;
	}

}
