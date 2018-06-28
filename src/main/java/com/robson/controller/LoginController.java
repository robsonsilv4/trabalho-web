package com.robson.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	@GetMapping("/login")
//	public String login(Principal principal) {
//		if (principal.getName() != null) {
//			return "redirect:/inicio";
//		}
//		return "/login";
//	}
	
	@RequestMapping("/login")
    public String login() {
        return "/login";
    }
}