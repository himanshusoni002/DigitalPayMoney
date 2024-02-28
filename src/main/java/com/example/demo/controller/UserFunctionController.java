package com.example.demo.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.EmailRequest;
import com.example.demo.entity.User;
import com.example.demo.entity.BankDetails;
import com.example.demo.entity.userWallet;
import com.example.demo.service.EmailService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class UserFunctionController {
	
	@Autowired
	private userController usercontroller;
	
	@Autowired
	private WalletController walletcontroller;
			
	@Autowired
	private EmailService emailService;
	
	@Autowired
	private BankDetailsController bankDetailsController;

	String fetchotp;
	
	@RequestMapping(path = "/registration", method = RequestMethod.POST)
	public void userRegistration(@RequestParam String email,HttpServletRequest request, @ModelAttribute User user, @ModelAttribute EmailRequest emailrequest, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		session.setAttribute("email", email);
	try {
			
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/paymoney","root","root");
		PreparedStatement ps = con.prepareStatement("select * from user_data where email = ?");
		ps.setString(1,email);
		ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				response.sendRedirect("/register");
			}else {
				String otp = generateOtp();
				emailrequest.setTo(email);
				emailrequest.setMessage(otp);
				
				session.setAttribute("one", email);
				
				this.fetchotp = (String) session.getAttribute("one");
				
				user.setRegisterOtp(otp);
				
				usercontroller.UserDetails(user);
				
				boolean result = this.emailService.sendEmail(emailrequest.getSubject(), emailrequest.getMessage(), emailrequest.getTo());
				
				if(result) {
					System.out.println("Email sent successfully...");
				}
				else {
					System.out.println("Email not sent....");
				}		
				response.sendRedirect("/otp");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	String checkOtp;
	
	@RequestMapping(path = "/verification", method = RequestMethod.POST)
	public void userVerification(@ModelAttribute User user,@RequestParam String enterOtp, HttpServletResponse response, HttpSession session){
		
		this.checkOtp = enterOtp;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/paymoney","root","root");
			PreparedStatement ps = con.prepareStatement("Select register_otp from user_data where email = ?");
			ps.setString(1,fetchotp);
			ResultSet rs = ps.executeQuery();
			 
			while(rs.next()) {
				String generateOtp = rs.getString("register_otp");
			
				if(generateOtp.equals(enterOtp)) {
					System.out.println("Otp Verification Successfully");
					session.setAttribute("useremail",fetchotp);
					response.sendRedirect("/home");
				}else {
					System.out.println("Otp Not Verify");
					response.sendRedirect("/otp");
				}
			}
			con.close();
		} catch(Exception e ) {
			System.out.println(e);
		}
	}
	
	@GetMapping("/resendOtp")
	public void resendOtpFunction(@ModelAttribute User user, HttpServletResponse response, @ModelAttribute EmailRequest emailrequest) {
		
		
		String otp = generateOtp();
		emailrequest.setTo(fetchotp);
		emailrequest.setMessage(otp);
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/paymoney","root","root");
			PreparedStatement ps1 = con.prepareStatement("Select register_otp from user_data where email = ?");
			ps1.setString(1,fetchotp);
			ResultSet rs1 = ps1.executeQuery();
			PreparedStatement ps2 = con.prepareStatement("Update user_data set register_otp = ? where email = ?");
			ps2.setString(1,otp);
			ps2.setString(2, fetchotp);
			int rs2 = ps2.executeUpdate();
				
			if(rs2 > 0) {
				while (rs1.next()) {
				String generateOtp = rs1.getString("register_otp");	
					if(generateOtp.equals(checkOtp)) {
						System.out.println("Otp Verification Successfully");
						response.sendRedirect("/");
					}else {
						System.out.println("Otp Not Verify");
						response.sendRedirect("/otp");
					}
				}	
			}
			con.close();
		} catch(Exception e ) {
			System.out.println(e);
		}
		
		boolean result = this.emailService.sendEmail(emailrequest.getSubject(), emailrequest.getMessage(), emailrequest.getTo());
		
		if(result) {
			System.out.println("Otp sent successfully...");
		}
		else {
			System.out.println("Otp not sent....");
		}
		
	}
		
	@RequestMapping(value = "/emailverify", method = RequestMethod.POST)
	public void loginverify(@RequestParam String email, HttpServletResponse response, HttpSession session) {
		
		
		session.setAttribute("One", email);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/paymoney","root","root");
			PreparedStatement ps = con.prepareStatement("Select * from user_data where email = ?");
			ps.setString(1, (String) session.getAttribute("One"));
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				System.out.println("Email verify successfully");
				response.sendRedirect("/passwordverify");
			}else {
				response.sendRedirect("/register");
				System.out.println("The email you entered isn't connected to an account Click here to sign up.");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	String mail;
	@RequestMapping(value = "/passwordverify", method = RequestMethod.POST)
	public void loginpassverify(@RequestParam String password,HttpSession session,@ModelAttribute User user, HttpServletResponse response) {
		
		mail = (String) session.getAttribute("One");
		System.out.println("Check Password Verify");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/paymoney","root","root");
			PreparedStatement ps = con.prepareStatement("Select * from user_data where email = ? And password = ?");
			ps.setString(1, mail);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				System.out.println("password verify successfully");
				session.setAttribute("useremail",mail);
				response.sendRedirect("/home");
			}else {
				response.sendRedirect("/passwordverify");
				System.out.println("The passowrd you entered isn't correct Please enter correct password");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "/otpforLogin", method = RequestMethod.POST)
	public void sendOtpLogin(HttpServletResponse response,HttpSession session, @ModelAttribute EmailRequest emailrequest) throws IOException {
		String otp = generateOtp();
		System.out.println("Check Send Otp");
		String email = (String) session.getAttribute("One");
		session.setAttribute("otp", otp);
		emailrequest.setTo(email);
		emailrequest.setMessage(otp);
				
		boolean result = this.emailService.sendEmail(emailrequest.getSubject(), emailrequest.getMessage(), emailrequest.getTo());

		if(result) {
			System.out.println("Otp sent successfully...");
			response.sendRedirect("/loginotp");
		}
		else {
			System.out.println("Otp not sent....");
		}
		usercontroller.updateUserData(email, otp);
	}
	
	@RequestMapping(value = "/otpverify", method = RequestMethod.POST)
	public void loginotpverify(@RequestParam String otp,HttpSession session,@ModelAttribute User user, HttpServletResponse response) {
			System.out.println("Check LoginOtpVerify");
			
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/paymoney","root","root");
			PreparedStatement ps = con.prepareStatement("Select login_otp from user_data where email = ?");
			ps.setString(1, (String) session.getAttribute("One"));
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				String generateLoginOtp = rs.getString("login_otp");
				if(generateLoginOtp.equals(session.getAttribute("otp"))) {
					response.sendRedirect("/home");
					session.setAttribute("useremail",mail);
					System.out.println("Otp verify successfully");
				}
				else {
				response.sendRedirect("/register");
				System.out.println("The OTP you entered isn't correct");
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "deposit", method = RequestMethod.POST)
	public void depositAmount(@ModelAttribute userWallet userwallet, HttpSession session, HttpServletResponse response) throws IOException {
		
		String useremail = (String) session.getAttribute("useremail");
		userwallet.setUserName(useremail);

		if(userwallet.getDeposit() < 250) {
			response.sendRedirect("/deposit");
		}else {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/paymoney","root","root");
				PreparedStatement ps = con.prepareStatement("select wallet from user_wallet where user_name = ? Order By id desc Limit 1;");
				ps.setString(1, useremail);	
				System.out.println("Check This Method");
				try (ResultSet rs = ps.executeQuery()){
					if(rs.next()) {
						double walletBalance = rs.getDouble("wallet");
						walletBalance = walletBalance + userwallet.getDeposit();
						userwallet.setWallet(walletBalance);
						walletcontroller.updateBalance(useremail, userwallet);
						walletcontroller.addAmount(useremail, userwallet);
					}
					else {
						double walletBalance = 0;
						walletBalance = walletBalance + userwallet.getDeposit();
			            userwallet.setWallet(walletBalance);
						walletcontroller.updateBalance(useremail, userwallet);
						walletcontroller.addAmount(useremail, userwallet);
					}
				}
			}catch(Exception e) {
				System.out.println(e);
			}
			response.sendRedirect("/payment");
		}
	}
	
	@RequestMapping(value = "withdraw", method = RequestMethod.POST)
	public void withdrawAmount(@ModelAttribute userWallet userwallet, HttpSession session, HttpServletResponse response) throws IOException {
		String useremail = (String) session.getAttribute("useremail");
		userwallet.setUserName(useremail);
				
		if(userwallet.getWithdraw() < 500) {
			response.sendRedirect("/withdraw");
		} else {			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/paymoney","root","root");
				PreparedStatement ps = con.prepareStatement("select wallet from user_wallet where user_name = ? Order By id desc Limit 1;");
				ps.setString(1, useremail);
				
				try(ResultSet rs = ps.executeQuery()){
				
					if(rs.next()) {
						double walletbalance = rs.getDouble("wallet");
						walletbalance = walletbalance - userwallet.getWithdraw();
						userwallet.setWallet(walletbalance);
						walletcontroller.removeAmount(useremail, userwallet);
						response.sendRedirect("/home");
					}else {
						response.sendRedirect("/withdraw");
						System.out.println("Insufficient Balance");
					}
				}
			} catch(Exception e) {
				System.out.println(e);
			}
		}
	}
	
	@RequestMapping(value = "/bankDetails", method = RequestMethod.POST)
	public void withdrawDetails(@ModelAttribute BankDetails bankdetails, HttpSession session, HttpServletResponse response) throws IOException {
		String useremail = (String) session.getAttribute("useremail");
		bankdetails.setEmail(useremail);
		bankDetailsController.addBankDetails(useremail, bankdetails);
		response.sendRedirect("/withdrawdetails");
	}
	
	
	public String generateOtp() {
		int otpLength = 6;
		StringBuilder otp = new StringBuilder();
		
		Random random = new Random();
		
		for(int i = 0; i<otpLength; i++) {
			int digit = random.nextInt(10);
			otp.append(digit);
		}
		return otp.toString();
	}
}
