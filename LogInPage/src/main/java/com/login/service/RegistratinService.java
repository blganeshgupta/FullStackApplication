package com.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.login.model.RegistrationDetails;
import com.login.repository.RegistrationRepository;

@Service
public class RegistratinService {
	
	@Autowired
	private RegistrationRepository repo;

	public RegistrationDetails registerRepo(RegistrationDetails res) {
		System.out.println("entered into service");
		
		return repo.save(res);
		
	}
	public RegistrationDetails fetchEmailId(String email) {
		return repo.findByEmail(email);
	}
	public RegistrationDetails fetchEmailAndPassword(String email, String password) {
		return repo.findByEmailAndPassword(email,password);
	}
		
}
