package br.com.fpimentel.productapi.resources;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.fpimentel.productapi.domain.Product;

public interface ProductResource {
	
	@GetMapping(value = "/{id}")
	ResponseEntity<Product> findById(@PathVariable Long id);
	
	@GetMapping
	ResponseEntity<List<Product>> findAll();
	
	@PutMapping(value = "/purchased")
	ResponseEntity<List<Product>> purchaseUpdate(@RequestBody List<Product> prod);

}
