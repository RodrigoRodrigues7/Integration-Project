package com.rodrigo.integration.domain;

import java.io.Serializable;

public class UserDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;
	private String username;
	private String email;

	public UserDTO() {
	}

	public UserDTO(User user) {
		super();
		this.id = user.getId();
		this.username = user.getUsername();
		this.email = user.getEmail();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
