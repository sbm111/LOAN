package com.lps.loan.service;

import java.util.Map;

import com.lps.loan.controller.model.CustomerLoanData;

public interface LoanService {
	public Map<String,Object> createCustomerLoan(CustomerLoanData customerLoanData);
}
