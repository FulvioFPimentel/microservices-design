package br.com.fpimentel.payrollapi.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class Payroll {
	
	private String workerName;
	private String description;
	private Double hourlyPrice;
	private Double workerHours;
	private Double totalPayment;

}
