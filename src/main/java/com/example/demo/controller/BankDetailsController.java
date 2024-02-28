package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.entity.BankDetails;
import com.example.demo.service.BankDetailsService;

@Controller
public class BankDetailsController {
	
	@Autowired
	private BankDetailsService bankdetailsservice;
	
	@RequestMapping(value = "/addbankdetails", method = RequestMethod.POST)
	public BankDetails addBankDetails(@PathVariable String email, @RequestBody BankDetails bankdetails) {
		return bankdetailsservice.addBankDetails(email, bankdetails);
	}
}
