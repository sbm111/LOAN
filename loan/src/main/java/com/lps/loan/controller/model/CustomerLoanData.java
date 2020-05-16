package com.lps.loan.controller.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.lps.loan.entity.Customer;
import com.lps.loan.entity.Loan;

public class CustomerLoanData {
	
	@NotNull
	@NotEmpty
	private Customer customerdetail;
	
	@NotNull
	@NotEmpty
	private Loan loandetail;
	
	public Customer getCustomerdetail() {
		return customerdetail;
	}

	public void setCustomerdetail(Customer customerdetail) {
		this.customerdetail = customerdetail;
	}

	public Loan getLoandetail() {
		return loandetail;
	}

	public void setLoandetail(Loan loandetail) {
		this.loandetail = loandetail;
	}

}
