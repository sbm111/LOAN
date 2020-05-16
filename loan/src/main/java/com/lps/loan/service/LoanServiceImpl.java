package com.lps.loan.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lps.loan.controller.model.CustomerLoanData;
import com.lps.loan.dao.CustomerRepository;
import com.lps.loan.dao.LoanRepository;
import com.lps.loan.entity.Customer;
import com.lps.loan.entity.Loan;

@Service
public class LoanServiceImpl implements LoanService{
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private LoanRepository loanRepository;
	
	/**
	 * This service method will insert first customer data and then its loan detail. 
	 */
	@Transactional
	public Map<String,Object> createCustomerLoan(CustomerLoanData customerLoanData){
		
		Customer customer = customerRepository.save(customerLoanData.getCustomerdetail());
		System.out.println("Customer data saved");
		
		Loan loan = customerLoanData.getLoandetail();
		loan.setLoanNumber(generateLoanNumber());
		loan.setCustomer(customer);
		loan = loanRepository.save(loan);
		System.out.println("Loan data saved");
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("success", "You have successfully applied for loan. Your loan number is "+loan.getLoanNumber());
		
		System.out.println("You have successfully applied for loan. Your loan number is "+loan.getLoanNumber());
		return map;
	}
	
	/**
	 * Generate unique loan number.
	 * @return
	 */
	public String generateLoanNumber() {
		int random1 = new Random().nextInt(900) + 100;
		int random2 = new Random().nextInt(900) + 100;
		int random3 = new Random().nextInt(900) + 100;
		System.currentTimeMillis();
		return "L"+random1+random2+random3;
	}

}
