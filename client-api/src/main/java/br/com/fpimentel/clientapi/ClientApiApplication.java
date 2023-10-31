package br.com.fpimentel.clientapi;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import br.com.fpimentel.clientapi.domain.Client;
import br.com.fpimentel.clientapi.repositories.ClientRepository;

@SpringBootApplication
@EnableDiscoveryClient
public class ClientApiApplication implements CommandLineRunner {
	
	@Autowired
	private ClientRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(ClientApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		List<Client> cli = Arrays.asList(
				new Client(null, "Messias", "Rua da Saudades, 168", "messiasnp@hotmail.com", "18-98544-4524"),
				new Client(null, "Renato", "Rua Wachington luiz, 149", "renatohp@hotmail.com", "18-98547-1235"),
				new Client(null, "Maria Jose", "Rua Antonio almeida padro, 232", "mariajr@gmail.com", "18-98984-2541"));
		
		repository.saveAll(cli);
		
	}

}
