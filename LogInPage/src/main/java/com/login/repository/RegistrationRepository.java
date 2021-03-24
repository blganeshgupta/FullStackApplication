package com.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.login.model.RegistrationDetails;
import com.login.service.RegistratinService;

public interface RegistrationRepository extends JpaRepository<RegistrationDetails, Integer>{

	public RegistrationDetails findByEmail(String email);
	public RegistrationDetails findByEmailAndPassword(String email, String Password);

}
