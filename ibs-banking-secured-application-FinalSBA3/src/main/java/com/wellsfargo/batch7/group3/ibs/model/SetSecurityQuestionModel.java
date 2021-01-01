package com.wellsfargo.batch7.group3.ibs.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class SetSecurityQuestionModel {
	
	@NotNull(message="oldPassword answer is mandate")
	@NotBlank(message="oldPassword answer mandate")
	private String oldPassword;
	
	@NotNull(message="SecurityQuestion answer is mandate")
	@NotBlank(message="SecurityQuestion answer mandate")
	
	private String securityQuestion;
	@NotNull(message="Confirm answer is mandate")
	@NotBlank(message="Confirm answer mandate")
	@Size(min=5,max=100,message="Answer must be 5 to 100 chars in length")
	private String securityAnswer;
	
	
	
	public SetSecurityQuestionModel(
			@NotNull(message = "oldPassword answer is mandate") @NotBlank(message = "oldPassword answer mandate") String oldPassword,
			@NotNull(message = "SecurityQuestion answer is mandate") @NotBlank(message = "SecurityQuestion answer mandate") String securityQuestion,
			@NotNull(message = "Confirm answer is mandate") @NotBlank(message = "Confirm answer mandate") @Size(min = 5, max = 100, message = "Answer must be 5 to 100 chars in length") String securityAnswer) {
		super();
		this.oldPassword = oldPassword;
		this.securityQuestion = securityQuestion;
		this.securityAnswer = securityAnswer;
	}

	public SetSecurityQuestionModel()
	{
		
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

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}
	
	
	
	
	
	
}
