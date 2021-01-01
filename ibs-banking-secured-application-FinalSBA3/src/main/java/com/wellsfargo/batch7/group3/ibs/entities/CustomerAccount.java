package com.wellsfargo.batch7.group3.ibs.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;





@Entity
//@Table(name="customer_account")
public class CustomerAccount extends LoginInfo  {
//	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)	
	private Long id;
//	private Long custAcctNum;
	@Column(name="uci",nullable=false,unique=true)
	private String uci;
	private String custName;
	private String gender;
//	@DateTimeFormat(iso=ISO.DATE)
	private LocalDate dob;
	private String emailId;
	private String mobileNum;
	private String address;
	private String city;
	private String pincode;	
//	@DateTimeFormat(iso=ISO.DATE)
	private LocalDate acctStartDate;
//	@DateTimeFormat(iso=ISO.DATE)
	private LocalDate acctCloseDate;
	private String branchName;
	private String branchIFSC;
	private String custAcctStatus;
	
	//from Neeraja addition
	private Long regId;

	
	
	public CustomerAccount() {
		
	}



	public CustomerAccount(Integer slNoLogin, String userName, String password, String firstLoginFlag, String role,
			String securityQuestion, String securityAnswer, Long id, String uci, String custName, String gender,
			LocalDate dob, String emailId, String mobileNum, String address, String city, String pincode,
			LocalDate acctStartDate, LocalDate acctCloseDate, String branchName, String branchIFSC,
			String custAcctStatus, Long regId) {
		super(slNoLogin, userName, password, firstLoginFlag, role, securityQuestion, securityAnswer);
		this.id = id;
		this.uci = uci;
		this.custName = custName;
		this.gender = gender;
		this.dob = dob;
		this.emailId = emailId;
		this.mobileNum = mobileNum;
		this.address = address;
		this.city = city;
		this.pincode = pincode;
		this.acctStartDate = acctStartDate;
		this.acctCloseDate = acctCloseDate;
		this.branchName = branchName;
		this.branchIFSC = branchIFSC;
		this.custAcctStatus = custAcctStatus;
		this.regId = regId;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getUci() {
		return uci;
	}



	public void setUci(String uci) {
		this.uci = uci;
	}



	public String getCustName() {
		return custName;
	}



	public void setCustName(String custName) {
		this.custName = custName;
	}



	public String getGender() {
		return gender;
	}



	public void setGender(String gender) {
		this.gender = gender;
	}



	public LocalDate getDob() {
		return dob;
	}



	public void setDob(LocalDate dob) {
		this.dob = dob;
	}



	public String getEmailId() {
		return emailId;
	}



	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}



	public String getMobileNum() {
		return mobileNum;
	}



	public void setMobileNum(String mobileNum) {
		this.mobileNum = mobileNum;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public String getCity() {
		return city;
	}



	public void setCity(String city) {
		this.city = city;
	}



	public String getPincode() {
		return pincode;
	}



	public void setPincode(String pincode) {
		this.pincode = pincode;
	}



	public LocalDate getAcctStartDate() {
		return acctStartDate;
	}



	public void setAcctStartDate(LocalDate acctStartDate) {
		this.acctStartDate = acctStartDate;
	}



	public LocalDate getAcctCloseDate() {
		return acctCloseDate;
	}



	public void setAcctCloseDate(LocalDate acctCloseDate) {
		this.acctCloseDate = acctCloseDate;
	}



	public String getBranchName() {
		return branchName;
	}



	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}



	public String getBranchIFSC() {
		return branchIFSC;
	}



	public void setBranchIFSC(String branchIFSC) {
		this.branchIFSC = branchIFSC;
	}



	public String getCustAcctStatus() {
		return custAcctStatus;
	}



	public void setCustAcctStatus(String custAcctStatus) {
		this.custAcctStatus = custAcctStatus;
	}



	public Long getRegId() {
		return regId;
	}



	public void setRegId(Long regId) {
		this.regId = regId;
	}
	
	
	

}