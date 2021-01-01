package com.wellsfargo.batch7.group3.ibs.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CustomerNewPasswordModel extends CustomerAccountDto{
	
	@NotNull(message="Old Password is mandate")
	@NotBlank(message="Old Password mandate")
	private String oldPassword;
	
	@NotNull(message="Password is mandate")
	@NotBlank(message="Password is mandate")
	@Size(min=5,max=100,message="Password must be 5 to 100 chars in length")
	private String password;
	@NotNull(message="Confirm Password is mandate")
	@NotBlank(message="Confirm Password mandate")
	@Size(min=5,max=100,message="Password must be 5 to 100 chars in length")
	private String confirmPassword;
	
	
	
	public String getOldPassword() {
		return oldPassword;
	}
	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}
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

	
}
