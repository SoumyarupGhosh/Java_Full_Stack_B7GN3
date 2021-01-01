package com.wellsfargo.batch7.group3.ibs.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class LoginInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer slNoLogin;
	
	@Column(name="unm",nullable=false,unique=true)
	private String userName;
	
	@Column(name="pwd",nullable=false)
	private String password;
	
	private String firstLoginFlag;
	
	@Column(name="role",nullable=false)
	private String role;
	
	private String securityQuestion;
	
	private String securityAnswer;

	public LoginInfo() {
		
	}

	public LoginInfo(Integer slNoLogin, String userName, String password, String firstLoginFlag, String role,
			String securityQuestion, String securityAnswer) {
		super();
		this.slNoLogin = slNoLogin;
		this.userName = userName;
		this.password = password;
		this.firstLoginFlag = firstLoginFlag;
		this.role = role;
		this.securityQuestion = securityQuestion;
		this.securityAnswer = securityAnswer;
	}

	public Integer getSlNoLogin() {
		return slNoLogin;
	}

	public void setSlNoLogin(Integer slNoLogin) {
		this.slNoLogin = slNoLogin;
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

	public String getFirstLoginFlag() {
		return firstLoginFlag;
	}

	public void setFirstLoginFlag(String firstLoginFlag) {
		this.firstLoginFlag = firstLoginFlag;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
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
