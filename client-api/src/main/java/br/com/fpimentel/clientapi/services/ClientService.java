package br.com.fpimentel.clientapi.services;

import java.util.List;

import br.com.fpimentel.clientapi.domain.Client;

public interface ClientService {
	
	Client Save(Client client);
	
	Client findById(Long id);
	
	List<Client> findAll();

}
