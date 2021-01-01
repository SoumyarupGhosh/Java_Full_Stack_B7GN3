package com.wellsfargo.batch7.group3.ibs.model;

import java.time.LocalDate;
public class CustomerAccountDto{
	
	private Long id;
//	private Long custAcctNum;
	private String uci;
	private String custName;
	private String gender;
	private LocalDate dob;
	private String emailId;
	private String mobileNum;
	private String address;
	private String city;
	private String pincode;	
	private LocalDate acctStartDate;
	private LocalDate acctCloseDate;
	private String branchName;
	private String branchIFSC;
	private String custAcctStatus;
	private Long regId;

	public CustomerAccountDto() {
		
	}

	public CustomerAccountDto(Long id,  String uci, String custName, String gender, LocalDate dob,
			String emailId, String mobileNum, String address, String city, String pincode, LocalDate acctStartDate,
			LocalDate acctCloseDate, String branchName, String branchIFSC, String custAcctStatus, Long regId) {
		super();
		this.id = id;
//		this.custAcctNum = custAcctNum;
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

//	public Long getCustAcctNum() {
//		return custAcctNum;
//	}
//
//	public void setCustAcctNum(Long custAcctNum) {
//		this.custAcctNum = custAcctNum;
//	}

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
