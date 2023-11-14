package br.com.fpimentel.productapi.services;

import java.util.List;

import br.com.fpimentel.productapi.domain.Product;

public interface ProductService {
	
	Product findById(Long id);
	
	List<Product> findAll();
	
	List<Product> orderUpdate(List<Product> prod);
	
	List<Product> findAllById(List<Product> prod);
	
}
