package com.example.demo.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.service.UserService;
import com.example.demo.userRepositoryDto.UserRegistrationDto;

@Controller
public class UserRegistrationController {
	
	@Autowired
	private UserService userService;
	
	/* To chance the default mapping given by the spring security feature */
	@GetMapping("/login")
	public String redirectUrl() {
		
		return "redirect:/registrationForm";
	}
	
	@GetMapping("/registrationForm")
	public String registrationForm(Model model) {
		
		model.addAttribute("user", new UserRegistrationDto());
		return "registration";
	}
	
	@PostMapping("/registration")
	public String  processForm(@ModelAttribute("user") UserRegistrationDto userRegistrationDto ) {
		
		userService.save(userRegistrationDto);
		return "redirect:/registrationForm?Success";
	}
	
	@GetMapping("/showLoginForm")
	public String login() {
		return "login";
	}
}
