package br.com.fpimentel.productapi.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.fpimentel.productapi.domain.Product;
import br.com.fpimentel.productapi.domain.StateEnum;
import br.com.fpimentel.productapi.repositories.ProductRepository;
import br.com.fpimentel.productapi.services.ProductService;
import br.com.fpimentel.productapi.services.impl.exceptions.InsufficientStockException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
	
	private final ProductRepository repository;

	@Override
	public Product findById(Long id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public List<Product> findAll() {
		return repository.findAll();
	}

	@Override
	public List<Product> orderUpdate(List<Product> prod) {
		List<Product> product = new ArrayList<>();
		
		for (Product p : prod) {
			Product prodUp = repository.findById(p.getId()).orElse(null);
			
			if(prodUp.getQuantity() < p.getQuantity()) {
				throw new InsufficientStockException("Insufficient product in stock");				
			} else {
				Integer quantityUp = prodUp.getQuantity() - p.getQuantity();
				if(quantityUp.equals(0)) {
					prodUp.setStatus(StateEnum.UNAVAILABLE);
					prodUp.setQuantity(quantityUp);
					repository.save(prodUp);
				} else {
					prodUp.setQuantity(quantityUp);
					repository.save(prodUp);
				}					
			}
			product.add(productResponse(p, prodUp));
		}
		return product;
	}
	
	public Product productResponse(Product prodQuantity, Product prod) {
		Product p = new Product();
		
		p.setId(prod.getId());
		p.setProduct(prod.getProduct());
		p.setModel(prod.getModel());
		p.setManufacturer(prod.getManufacturer());
		p.setProductValue(prod.getProductValue());
		p.setQuantity(prodQuantity.getQuantity());
		p.setStatus(prod.getStatus());
		return p;
	}

	@Override
	public List<Product> findAllById(List<Product> prod) {
	
		List<Product> product = new ArrayList<>();
		for(Product p : prod) {
			Product getProd = repository.findById(p.getId()).orElse(p);
			product.add(getProd);
		}
		return product;
	}
}


