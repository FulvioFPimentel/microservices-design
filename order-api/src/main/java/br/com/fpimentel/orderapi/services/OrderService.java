package br.com.fpimentel.orderapi.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.fpimentel.orderapi.domain.Client;
import br.com.fpimentel.orderapi.domain.Order;
import br.com.fpimentel.orderapi.domain.Product;
import br.com.fpimentel.orderapi.domain.ProductsOrder;
import br.com.fpimentel.orderapi.feignClients.ClientFeign;
import br.com.fpimentel.orderapi.feignClients.ProductFeign;
import br.com.fpimentel.orderapi.feignClients.UserFeign;
import feign.FeignException;
import jakarta.ws.rs.NotFoundException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class OrderService {
	
	private final UserFeign userFeign;
	private final ClientFeign clientFeign;
	private final ProductFeign productFeign;
	
	public Order getOrder(Long userId, Long clientId, List<ProductsOrder> products) {
		try {
			var user = userFeign.userFindById(userId).getBody();
			var client = clientFeign.clientFindById(clientId).getBody();		
			var product = productFeign.getProducts(products).getBody();
			List<Product> prod = new ArrayList<>();
						
			product.forEach(a -> prod.add(new Product(
					a.getId(), a.getProduct(), a.getModel(), 
					a.getManufacturer(), a.getProductValue(),
					a.getQuantity(), a.getProductValue() * a.getQuantity())));
			
							
			return new Order(
					user.getId(),
					user.getName(),
					user.getEmail(),
					new Client(client.getId(), client.getName(), 
							client.getAddress(), client.getEmail(), 
							client.getCellNumber(), client.getOrder()), 
					getTotalvalue(prod)
					, prod
					);
			
		} catch(FeignException.NotFound ex) {
			throw new NotFoundException(ex);
		}	
	}
	
	public Double getTotalvalue(List<Product> prod) {
		Double total = 0.0;
		
		for(Product p : prod) {
			total += p.getTotal();
		}
		return total;
	}
}
