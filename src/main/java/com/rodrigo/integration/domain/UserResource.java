package com.rodrigo.integration.domain;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@GetMapping
	public String listar() {
		return "Testando o REST";
	}
	
}
