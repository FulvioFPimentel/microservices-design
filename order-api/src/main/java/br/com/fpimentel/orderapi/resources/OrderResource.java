package br.com.fpimentel.orderapi.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fpimentel.orderapi.domain.Order;
import br.com.fpimentel.orderapi.domain.RequestOrder;
import br.com.fpimentel.orderapi.services.OrderService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/orders")
public class OrderResource {
	
	private final OrderService service;
	
	@GetMapping(value = "/{id}") @Async
	public ResponseEntity<Order> getOrders(@PathVariable Long id, @RequestBody RequestOrder order){
		return ResponseEntity.ok().body(service.getOrder(id, order.getClient_id(), order.getProducts()));
		
	}
		
}
