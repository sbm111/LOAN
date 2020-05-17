package com.lps.loan.service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lps.loan.controller.model.CustomerLoanData;
import com.lps.loan.dao.CustomerRepository;
import com.lps.loan.dao.LoanRepository;
import com.lps.loan.entity.Borrower;
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
		
		//Insert Borrower Detail
		Borrower borrower = populateCustomerData(customerLoanData);
		borrower = customerRepository.save(borrower);
		System.out.println("Customer data saved");
		
		Loan loan = populateLoanData(customerLoanData, borrower);
		loan = loanRepository.save(loan);
		System.out.println("Loan data saved");
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("success", "You have successfully applied for loan. Your loan number is "+loan.getLoanNumber());
		
		System.out.println("You have successfully applied for loan. Your loan number is "+loan.getLoanNumber());
		return map;
	}
	
	
	public Borrower populateCustomerData(CustomerLoanData customerLoanData) {
		Borrower borrower = new Borrower();
		borrower.setAddress(customerLoanData.getAddress());
		borrower.setContact(customerLoanData.getContact());
		borrower.setName(customerLoanData.getName());
		return borrower;
	}
	
	public Loan populateLoanData(CustomerLoanData customerLoanData,Borrower customer) {
		Loan loan = new Loan();
		loan.setLoanAmount(Double.parseDouble(customerLoanData.getLoanAmount())); 
		loan.setInterestRate(Double.parseDouble(customerLoanData.getInterestRate()));
		loan.setLoanNumber(generateLoanNumber());
		loan.setCustomer(customer);
		return loan;
	}
	
	/**
	 * Generate unique loan number.
	 * @return
	 */
	public String generateLoanNumber() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		System.out.println(sdf.format(timestamp));
		int random1 = new Random().nextInt(90) + 10;
		return random1+sdf.format(timestamp);
	}

}
