package br.com.fpimentel.orderapi.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
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
@Table(name = "TB_CLIENT")
public class Client {
	
	@Include
	@Id
	@Column(name = "id")
	private Long id;
	private String name;
	private String address;
	private String email;
	private String cellNumber;
	
	@OneToOne(mappedBy = "client")
	private Order order;

}
