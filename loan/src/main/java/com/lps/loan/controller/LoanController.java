package com.lps.loan.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
@RequestMapping("/borrower")
public class LoanController {
	
	Logger logger = LoggerFactory.getLogger(LoanController.class);
	
	@Autowired
	LoanService loanService;
	
	/**
	 * Create Loan
	 * @param customerLoanData
	 * @return
	 */
	@PostMapping("/createloan")
	public @ResponseBody Map<String,Object> createCustomerLoan(@RequestBody CustomerLoanData customerLoanData){
		logger.info("Service call start for create loan");
		return loanService.createCustomerLoan(customerLoanData);
	}

}
