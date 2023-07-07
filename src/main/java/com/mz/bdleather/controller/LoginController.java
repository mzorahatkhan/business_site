package com.mz.bdleather.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class LoginController {
    @GetMapping("/loginForm")
	public String displayLoginForm()
	{
		return"customer-login";
	}
    @PostMapping("/customer_login")
    public String submittLoginData()
    {
    	return"redirect:";
    }
}
