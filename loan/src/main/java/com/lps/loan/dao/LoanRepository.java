package com.lps.loan.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lps.loan.entity.Loan;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long>{

}
