package com.example.login_registration_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class LoginRegistrationProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoginRegistrationProjectApplication.class, args);
	}
}
