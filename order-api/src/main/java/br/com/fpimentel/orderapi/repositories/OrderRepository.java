package br.com.fpimentel.orderapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fpimentel.orderapi.domain.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
