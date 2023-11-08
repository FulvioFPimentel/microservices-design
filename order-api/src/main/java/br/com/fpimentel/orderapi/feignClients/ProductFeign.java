package br.com.fpimentel.orderapi.feignClients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.fpimentel.orderapi.domain.Product;

@FeignClient(name = "product-api")
public interface ProductFeign {
	
	@GetMapping(value = "/api/product/{id}")
	ResponseEntity<List<Product>> productFindAllById(@RequestBody List<Product> prod);

}
