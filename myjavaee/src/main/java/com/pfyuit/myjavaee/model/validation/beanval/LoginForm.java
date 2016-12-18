package com.pfyuit.myjavaee.model.validation.beanval;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Login form with bean validation (JSR-303).
 * @author yupengfei
 */
public class LoginForm {

	@NotEmpty
	private String username;

	@NotEmpty
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
