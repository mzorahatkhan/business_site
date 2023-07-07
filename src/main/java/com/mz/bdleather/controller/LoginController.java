package com.mz.bdleather.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
    @GetMapping("/customer_loginForm")
	public String displayLoginForm()
	{
		return"customer-login";
	}
    @PostMapping("/customer_login")
    public String submittLoginData()
    {
    	return"index";
    }
}
