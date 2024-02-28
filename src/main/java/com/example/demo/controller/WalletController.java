package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.entity.userWallet;
import com.example.demo.service.WalletService;


@Controller
public class WalletController {
	
	@Autowired
	private WalletService walletService;
	
	
	@RequestMapping(value = "/depositAmount", method = RequestMethod.POST)
	public userWallet addAmount(@PathVariable String userName, @RequestBody userWallet userwallet) {
		return walletService.addAmount(userName, userwallet);
	}


	@RequestMapping(value = "/withdrawAmount", method = RequestMethod.POST)
	public userWallet removeAmount(@PathVariable String userName,@RequestBody userWallet userwallet) {
		return walletService.removeAmount(userName, userwallet);
	}
	
	
	@RequestMapping(value = "/updateBalance", method = RequestMethod.POST)
	public userWallet updateBalance(@PathVariable String userName, @RequestBody userWallet userwallet) {
		return walletService.updateBalance(userName, userwallet);
	}
	
	
}