package br.com.fpimentel.orderapi.feignClients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.fpimentel.orderapi.domain.Product;
import br.com.fpimentel.orderapi.domain.ProductsOrder;

@FeignClient(name = "product-api")
public interface ProductFeign {
	
	@PutMapping(value = "/api/product/purchased")
	ResponseEntity<List<Product>> getProducts(@RequestBody List<ProductsOrder> products);

}
