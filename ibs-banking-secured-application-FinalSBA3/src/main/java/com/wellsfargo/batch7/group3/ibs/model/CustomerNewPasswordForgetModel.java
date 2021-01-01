package com.wellsfargo.batch7.group3.ibs.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CustomerNewPasswordForgetModel extends CustomerAccountDto{
	
	private String userId;
	@NotNull(message="Password is mandate")
	@NotBlank(message="Password is mandate")
	@Size(min=5,max=100,message="Email must be 5 to 100 chars in length")
	private String password;
	@NotNull(message="Confirm Password is mandate")
	@NotBlank(message="Confirm Password mandate")
	@Size(min=5,max=100,message="Confirm Password must be 5 to 100 chars in length")
	private String confirmPassword;
	
	private String securityQuestion;
	
	private String securityAnswer;
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getSecurityQuestion() {
		return securityQuestion;
	}
	public void setSecurityQuestion(String securityQuestion) {
		this.securityQuestion = securityQuestion;
	}
	public String getSecurityAnswer() {
		return securityAnswer;
	}
	public void setSecurityAnswer(String securityAnswer) {
		this.securityAnswer = securityAnswer;
	}
	
	
	
	
	
}
