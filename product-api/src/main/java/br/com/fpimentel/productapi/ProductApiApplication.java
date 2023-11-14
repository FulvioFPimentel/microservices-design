package br.com.fpimentel.productapi;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import br.com.fpimentel.productapi.domain.Product;
import br.com.fpimentel.productapi.domain.StateEnum;
import br.com.fpimentel.productapi.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;

@SpringBootApplication
@RequiredArgsConstructor
@EnableDiscoveryClient
public class ProductApiApplication implements CommandLineRunner {

	private final ProductRepository repository;
		
	public static void main(String[] args) {
		SpringApplication.run(ProductApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		List<Product> product = Arrays.asList(
				new Product(null, "Televisão", "Smart TV 50 Polegada", "LG", 3700.00, 12, StateEnum.AVAILABLE),
				new Product(null, "Home Theater", "HTP-076, 5.1, 4K", "Pioneer", 2500.00, 0, StateEnum.UNAVAILABLE),
				new Product(null, "Smartphone", "Galaxy A04e, 64GB, 3GB RAM", "Samsung ", 750.00, 20, StateEnum.AVAILABLE),
				new Product(null, "Fone de Ouvido", "Galaxy Buds 2", "Samsung ", 450.00, 35, StateEnum.AVAILABLE),
				new Product(null, "Notebook", "Gamer NITRO 5", " Acer", 4199.00, 9, StateEnum.AVAILABLE),
				new Product(null, "Monitor", "Gamer Storm 27' LED", " Husky", 899.00, 15, StateEnum.AVAILABLE),
				new Product(null, "Cadeira", "Gaming Tempest 700 Preto", "Husky", 790.00, 18, StateEnum.AVAILABLE)
				);
		
		repository.saveAll(product);
		
	}

}
