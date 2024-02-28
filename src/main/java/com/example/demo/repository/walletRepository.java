package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.userWallet;

public interface walletRepository extends JpaRepository<userWallet, String>{
	public userWallet findByUserName(String userName);
}
