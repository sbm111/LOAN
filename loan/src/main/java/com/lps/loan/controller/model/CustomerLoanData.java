package com.lps.loan.controller.model;

import javax.validation.constraints.NotNull;


public class CustomerLoanData {
	@NotNull
	private String name;
	@NotNull
	private String address;
	@NotNull
	private String contact;
	
	@NotNull
	private String loanAmount;
	@NotNull
	private String interestRate;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	
	public String getLoanAmount() {
		return loanAmount;
	}
	public void setLoanAmount(String loanAmount) {
		this.loanAmount = loanAmount;
	}
	public String getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(String interestRate) {
		this.interestRate = interestRate;
	}
	@Override
	public String toString() {
		return "CustomerLoanData [name=" + name + ", address=" + address + ", contact=" + contact + ", loanAmount="
				+ loanAmount + ", interestRate=" + interestRate + "]";
	}
	
}
