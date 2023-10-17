package br.com.msinfotec.userapi.domain;

import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.EqualsAndHashCode.Include;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity(name = "TB_USER")
public class User {
	
	@Include
	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Long id;
	private String name;
	private String email;
	private String password;
	private Double hourlyPrice;

	
}
