package br.com.fpimentel.orderapi.domain;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class RequestOrder {

	private Long client_id;
	List<ProductsOrder>  products = new ArrayList<>();
	
}
