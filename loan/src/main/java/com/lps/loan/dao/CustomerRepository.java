package com.lps.loan.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lps.loan.entity.Borrower;

@Repository
public interface CustomerRepository extends JpaRepository<Borrower, Long>{

}
