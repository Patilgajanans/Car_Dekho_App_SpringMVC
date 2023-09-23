package com.jspider.car_dekho_mvc.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jspider.car_dekho_mvc.pojo.UserPOJO;
import com.jspider.car_dekho_mvc.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService service;
	
	
	@GetMapping("/logout")
	public String login(HttpSession session,ModelMap map) {
		session.invalidate();
		map.addAttribute("msg","Logout successfully !");
		return "Login";
	}
	
	@PostMapping("/login")
	public String checkLogin(@RequestParam String username ,HttpSession session, @RequestParam String password,ModelMap map) {
		
		UserPOJO user = service.checkLogin(username,password);
		
		if (user!=null) {
			session.setAttribute("login", user);
			
			map.addAttribute("msg", "Login Successfull !");
			return "Home";
		}
		
		map.addAttribute("msg", "Login Failed Plese Try Again !");
		return "Login";
	}
	
	@GetMapping("/createAccount")
	public String createAccount()
	{
		return "CreateAccount";
	}
	
	@PostMapping("/createAccount")
	public String createNewAccount(@RequestParam String username, @RequestParam String password,ModelMap map) {
		UserPOJO user = service.createNewAccount(username, password);
		
		if (user != null) {
			map.addAttribute("msg","Account Created Successfully !");
			return "Login";
		}
		map.addAttribute("msg","Account Not Created Please Try Again !");
		return "CreateAccount";
	}
	
}
