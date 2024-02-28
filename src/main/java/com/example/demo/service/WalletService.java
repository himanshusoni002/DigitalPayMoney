package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.entity.userWallet;
import com.example.demo.repository.walletRepository;

@Service
public class WalletService {
	
	@Autowired 
	private walletRepository walletrepository;

	public userWallet addAmount(String userName, @RequestBody userWallet userwallet) {
		return walletrepository.save(userwallet);
	}

	public userWallet removeAmount(String userName, userWallet userwallet) {
		return walletrepository.save(userwallet);		
	}

	public userWallet updateBalance(String userName, @RequestBody userWallet userwallet) {
		return walletrepository.save(userwallet);
	}	
}
