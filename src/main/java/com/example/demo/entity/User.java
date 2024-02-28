package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_data")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String email;

    private String password;
    
    private String confirmPassword;
    
    private String registerOtp;
    
    private String loginOtp;
        

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
		
	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getRegisterOtp() {
		return registerOtp;
	}

	public void setRegisterOtp(String registerOtp) {
		this.registerOtp = registerOtp;
	}

	public String getLoginOtp() {
		return loginOtp;
	}

	public void setLoginOtp(String loginOtp) {
		this.loginOtp = loginOtp;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", password=" + password + ", confirmPassword=" + confirmPassword
				+ ", registerOtp=" + registerOtp + ", loginOtp=" + loginOtp + "]";
	}
	
}