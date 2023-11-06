package br.com.fpimentel.productapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fpimentel.productapi.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	
}
