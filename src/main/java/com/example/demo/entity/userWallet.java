package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "userWallet")
public class userWallet {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	int id;
	String userName;
	double deposit = 0;
	double withdraw = 0;
	double wallet = 0;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public double getDeposit() {
		return deposit;
	}
	public void setDeposit(double deposit) {
		this.deposit = deposit;
	}
	public double getWithdraw() {
		return withdraw;
	}
	public void setWithdraw(double withdraw) {
		this.withdraw = withdraw;
	}
	public double getWallet() {
		return wallet;
	}
	public void setWallet(double wallet) {
		this.wallet = wallet;
	}
	
}
