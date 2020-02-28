package com.xworkz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.dto.LoginDTO;
import com.xworkz.service.LoginService;
import com.xworkz.service.ModuleService;

@Controller
@RequestMapping
public class LoginController {
	@Autowired
	private ModuleService moduleService;
	@Autowired
	private LoginService service;
	public LoginController() {
		System.out.println("created\t"+this.getClass().getSimpleName());
	}
	
	@RequestMapping("signin.do")
	public String onLogin(LoginDTO dto, ModelMap map) {
		try {
			System.out.println("Invoked onRegister method");
			System.out.println(dto);
			
			boolean check = this.service.validateLogin(dto);
			if(check) {
				ModelMap email = map.addAttribute("successMessage", dto.getEmail());
				return "Success";
				
			}else {
				ModelMap failure = map.addAttribute("failureMessage", "Login unsuccessfull");
				return "Signin";
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Info:" + e.getMessage());
		}
		return "Signup";
		
		}
	
	}

