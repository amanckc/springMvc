package com.webapp.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.webapp.jee.LoginService;

@Controller
public class LoginController {

	LoginService service=new LoginService();
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String sayLoginPage()
	{
		return "login";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String handleLoginRequest(@RequestParam String name,@RequestParam String password,ModelMap model)
	{	//System.out.println(name);
		
		if(!service.validateUser(name, password))
		{
			model.put("errorMessage","Invalid Login credentials!!");
			return "login";
			
		}
		
		model.put("name", name);
		model.put("password", password);
		return "welcome";
		
	}
}
