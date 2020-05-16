package com.lps.loan.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lps.loan.controller.model.CustomerLoanData;
import com.lps.loan.service.LoanService;

/**
 * This Controller is handling customer loan operations.
 * @author XLDynamic-40573
 *
 */
@RestController
@RequestMapping("/customer")
public class LoanController {
	
	@Autowired
	LoanService loanService;
	
	/**
	 * Create Loan
	 * @param customerLoanData
	 * @return
	 */
	@PostMapping("/createloan")
	public @ResponseBody Map<String,Object> createCustomerLoan(@RequestBody CustomerLoanData customerLoanData){
		System.out.println("Service call start for create loan");
		System.out.println("Customer Details: "+customerLoanData.getCustomerdetail());
		System.out.println("Loan Details: "+customerLoanData.getLoandetail());
		return loanService.createCustomerLoan(customerLoanData);
	}

}
