package br.com.fpimentel.payrollapi.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fpimentel.payrollapi.domain.Payroll;
import br.com.fpimentel.payrollapi.domain.User;
import br.com.fpimentel.payrollapi.feignClients.UserFeign;

@RestController
@RequestMapping(value = "/api/payments")
public class PayrollResource {
	
	@Autowired
	private UserFeign userFeign;

	@GetMapping(value = "/{workerId}")
	public ResponseEntity<Payroll> getPayments(@PathVariable Long workerId, @RequestBody Payroll payment) {
		
		User user = userFeign.findById(workerId).getBody();
		
		return ResponseEntity
				.ok()
				.body(new Payroll(user.getName(), payment.getDescription(),
						user.getHourlyPrice(),
						payment.getWorkerHours(),
						user.getHourlyPrice() * payment.getWorkerHours()));
	}
	
}
