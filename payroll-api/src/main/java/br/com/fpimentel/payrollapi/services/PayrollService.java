package br.com.fpimentel.payrollapi.services;

import java.util.Objects;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import br.com.fpimentel.payrollapi.domain.Payroll;
import br.com.fpimentel.payrollapi.feignClients.UserFeign;
import br.com.fpimentel.payrollapi.services.exceptions.ObjectNotFoundException;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Service
public class PayrollService {
	
	private final Environment env;
	private final UserFeign feign;

	public Payroll getPayment(Long workerId, Payroll payroll) {
		log.info("PAYROLL_SERVICE ::: Get request on " + env.getProperty("local.server.port") + " port");
		try {
			var user = feign.findById(workerId).getBody();
			if (Objects.nonNull(user)) {
				return new Payroll(
						user.getName(),
						payroll.getDescription(),
						user.getHourlyPrice(),
						payroll.getWorkerHours(),
						payroll.getWorkerHours() * user.getHourlyPrice()
						);
			}
			
		} catch(FeignException.NotFound ex) {
			throw  new ObjectNotFoundException("Object not found");
		} catch(Exception ex) {
			throw new IllegalArgumentException("Illegal argument exception");
		}
		return null;
	}
	
}
