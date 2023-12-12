package br.com.msinfotec.userapi.domain.DTO;

import java.util.HashSet;
import java.util.Set;

import br.com.msinfotec.userapi.domain.User;
import br.com.msinfotec.userapi.domain.UserRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

	private String name;
	private String email;
	private Set<UserRole> roles = new HashSet<>();
	private Double hourlyPrice;
	
	public UserDTO(User user) {
		this.name = user.getName();
		this.email = user.getEmail();
		user.getRoles().forEach(a ->  this.roles.add(a));
		this.hourlyPrice = user.getHourlyPrice();
	}
	
	
}
