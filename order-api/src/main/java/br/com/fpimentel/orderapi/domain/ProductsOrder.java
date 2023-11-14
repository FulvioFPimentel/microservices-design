package br.com.fpimentel.orderapi.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductsOrder {
	
	private Long id;
	private Integer quantity;

}
