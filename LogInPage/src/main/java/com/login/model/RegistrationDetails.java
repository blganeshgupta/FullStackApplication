package com.login.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.ISBN;

import net.bytebuddy.implementation.bind.annotation.Empty;

@Entity
public class RegistrationDetails {
@Id
@GeneratedValue
private int id;
@NotNull
@Size(min=4, message="Email Atleast have four characters")
@Email
@NotBlank
private String email;
private String userName;
@NotNull
@NotEmpty
@Size(min=4, message="Email Atleast have four characters")

private String password;

public RegistrationDetails(int id, String email, String userName, String password) {
	super();
	this.id = id;
	this.email = email;
	this.userName = userName;
	this.password = password;
}

public RegistrationDetails() {
	}

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}

}
