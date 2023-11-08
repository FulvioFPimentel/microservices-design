package br.com.fpimentel.orderapi.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.EqualsAndHashCode.Include;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "TB_PRODUCT")
public class Product {
	
	@Include
	@Id
	private Long id;
	
	private String product;
	private String model;
	private String manufacturer;
	private Double productValue;
	private Integer quantity;
	
	private Double totalValue;
	
	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order order;
	
	public Double getTotalValue() {
		totalValue = productValue * quantity;
		return totalValue;
	}

}
