package com.xworkz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.dto.ModuleDTO;
import com.xworkz.service.ModuleService;

@Controller
@RequestMapping("/")
public class ModuleController {
	

	@Autowired
	private ModuleService moduleService;

	public ModuleController() {
		System.out.println("Created \t " + this.getClass().getSimpleName());
	}

	@RequestMapping("Submit.do")
	public String onSignup(ModuleDTO moduleDTO, ModelMap map) {
		
		try {
			System.out.println("invoked onSubmit");
			boolean check = this.moduleService.validateAndSave(moduleDTO);
			if (check) {
				//map.addAttribute("name",ModuleDTO.getuserName());
				map.addAttribute("Signup.jsp", "Data saved");
			} else {
				map.addAttribute("Signin.jsp", "Data not saved");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Signin";

	}

}
