package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.BankDetails;
import com.example.demo.repository.BankDetailsRepository;

@Service
public class BankDetailsService {

	@Autowired
	private BankDetailsRepository bankdetailsrepo;

	public BankDetails addBankDetails(String email, BankDetails bankdetails) {
		return bankdetailsrepo.save(bankdetails);
	}	
}
