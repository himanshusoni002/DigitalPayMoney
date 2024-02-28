package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;


@Controller
public class userController {
	
	@Autowired 
	private UserService userservice;
	
	@RequestMapping("/")
	public String indexpage() {
		return "index";
	}
	@RequestMapping("/about")
	public String aboutpage() {
		return "about";
	}
	@RequestMapping("/blog")
	public String blogpage() {
		return "blog";
	}
	@RequestMapping("/contact")
	public String contactpage() {
		return "contact";
	}
	@RequestMapping("/detail")
	public String detailpage() {
		return "detail";
	}
	@RequestMapping("/feature")
	public String featurepage() {
		return "feature";
	}
	@RequestMapping("/login")
	public String loginpage() {
		return "/LoginUser/emailverify";
	}
	@RequestMapping("/passwordverify")
	public String loginpasspage() {
		return "/LoginUser/passwordverify";
	}
	@RequestMapping("/loginotp")
	public String loginotppage() {
		return "/LoginUser/otpverify";
	}
	@RequestMapping("/price")
	public String pricepage() {
		return "price";
	}
	@RequestMapping("/quote")
	public String quotepage() {
		return "quote";
	}
	@RequestMapping("/service")
	public String servicepage() {
		return "service";
	}
	@RequestMapping("/team")
	public String teampage() {
		return "team";
	}
	@RequestMapping("/testimonial")
	public String testimonialpage() {
		return "testimonial";
	}
	@RequestMapping("/wallet")
	public String walletpage() {
		return "wallet";
	}
	@RequestMapping("/register")
	public String registerpage() {
		return "register";
	}
	@RequestMapping("/otp")
	public String otppage() {
		return "otp";
	}
	@RequestMapping("/home")
	public String homepage() {
		return "home";
	}
	@RequestMapping("/withdraw")
	public String withdrawpage() {
		return "withdraw";
	}
	@RequestMapping("/deposit")
	public String depositpage() {
		return "deposit";
	}
	
	@RequestMapping("/payment")
	public String paymentpage() {
		return "payment";
	}
	
	@RequestMapping("/withdrawdetails")
	public String withdrawdetails() {
		return "withdrawdetails";
	}
	
	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public User UserDetails(@RequestBody User user) {
		return userservice.addDetails(user);
	}
	
	@RequestMapping(value = "/updateUser", method = RequestMethod.PUT)
	public void updateUserData(String email, String otp) {
		userservice.updateUser(email, otp);
	}
}
