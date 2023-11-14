package br.com.fpimentel.productapi.resources.impl;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fpimentel.productapi.domain.Product;
import br.com.fpimentel.productapi.resources.ProductResource;
import br.com.fpimentel.productapi.services.ProductService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/product")
public class ProductResourceImpl implements ProductResource {

	
	private final ProductService service;
	
	@Override
	public ResponseEntity<Product> findById(Long id) {
		Product prod = service.findById(id);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(prod);
	}

	@Override
	public ResponseEntity<List<Product>> findAll() {
		List<Product> prod = service.findAll();
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(prod);
	}

	@Override
	public ResponseEntity<List<Product>> orderUpdate(List<Product> prod) {
			List<Product> prodUp = service.orderUpdate(prod);
		return ResponseEntity.ok().body(prodUp);
		
	}

	@Override
	public ResponseEntity<List<Product>> findAllById(List<Product> prod) {
		List<Product> prodUp = service.findAllById(prod);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(prodUp); 
	}

	}

