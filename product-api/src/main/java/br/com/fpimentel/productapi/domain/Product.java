package br.com.fpimentel.productapi.domain;

import static jakarta.persistence.GenerationType.IDENTITY;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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
	@GeneratedValue(strategy = IDENTITY)
	private Long id;
	
	private String product;
	private String model;
	private String manufacturer;
	
	private Double productValue;
	private Integer quantity;
	private StateEnum status;

}
