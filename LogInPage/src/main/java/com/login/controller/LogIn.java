package com.login.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.login.model.RegistrationDetails;
import com.login.service.RegistratinService;

@RestController
public class LogIn {

	static {
		System.out.println("class is loading");
	}
	@Autowired
	private RegistratinService rgs;
	@PostMapping("/registerUser")
	@CrossOrigin(origins="*")
	public RegistrationDetails registerSave(@Valid @RequestBody RegistrationDetails res) throws Exception {
		
		String emailId=res.getEmail();
		if(emailId!=null && !"".equals(emailId)) {
		RegistrationDetails details=rgs.fetchEmailId(emailId);
		
		if(details!=null) {
			throw new Exception("user with"+emailId+"already exists");
		}
			
		}
		
		
		RegistrationDetails rebs=null;
		rebs=rgs.registerRepo(res);
		return rebs;
	}
	@PostMapping("/logInPage")
	@CrossOrigin(origins="*")
	public RegistrationDetails logIn(@Valid @RequestBody RegistrationDetails res) throws Exception {
		String email=res.getEmail();
		String password=res.getPassword();
		RegistrationDetails details=null;
		if(email !=null && password !=null) {
		
			details=rgs.fetchEmailAndPassword(email, password);
			System.out.println(email+" "+details.getEmail());
			if(!email.equals(details.getEmail())&&!password.equals(details.getPassword())) {
				
				throw new Exception("Bad Credencials");

			}
			else {
				return details;
			}
			
		}
		else if(email==null || password==null ){
			throw new Exception("Bad Credencials");

		}
		else {
			throw new Exception("Bad Credencials");

		} 
		
		
	}
	
	
}
