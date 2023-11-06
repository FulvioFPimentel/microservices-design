package br.com.fpimentel.productapi.services;

import java.util.List;

import br.com.fpimentel.productapi.domain.Product;

public interface ProductService {
	
	Product findById(Long id);
	
	List<Product> findAll();
	
	List<Product> purchaseUpdate(List<Product> prod);

}
