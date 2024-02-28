package com.example.demo.servlet;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class Logout{
	
	@GetMapping("/logout")
	public void logOut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("Check Logout method");
		HttpSession session = req.getSession();
		session.invalidate();
		
		resp.sendRedirect("/");
		
	}
}
