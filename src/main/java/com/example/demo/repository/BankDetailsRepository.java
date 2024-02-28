package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.BankDetails;

public interface BankDetailsRepository extends JpaRepository<BankDetails, Integer>{

}
