//package com.wellsfargo.batch7.group3.ibs.model;
//
//import java.util.Date;
//import java.util.List;
//
//import javax.persistence.CascadeType;
//import javax.persistence.Column;
//import javax.persistence.DiscriminatorColumn;
//import javax.persistence.DiscriminatorType;
//import javax.persistence.DiscriminatorValue;
//import javax.persistence.Embeddable;
//import javax.persistence.Embedded;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Inheritance;
//import javax.persistence.InheritanceType;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.OneToMany;
//import javax.persistence.OneToOne;
//import javax.persistence.Table;
//
//import org.springframework.format.annotation.DateTimeFormat;
//import org.springframework.format.annotation.DateTimeFormat.ISO;
//
//
//
//
//public class CustomerAccountModel  {	
//	
//	private String uci;
//	private Integer custAcctNum;
//	private String custName;
//	private String gender;
//	@DateTimeFormat(iso=ISO.DATE)
//	private Date dob;
//	private String emailId;
//	private String mobileNum;
//	private String address;
//	private String city;
//	private String pincode;	
//	@DateTimeFormat(iso=ISO.DATE)	
//	private Date acctOpenDate;
//	@DateTimeFormat(iso=ISO.DATE)
//	private Date acctCloseDate;
//	private String branchName;
//	private String branchIfsc;
//	private String custAcctStatus;
//	
////	private List<CustomerBeneficiaryModel> BeneficiaryList;	
////	private List<CustomerTransactionsInfoModel> TransactionList;	
////	private List<CustomerAccountTypesInfoModel> AccountTypesList;	
////	private KycDetailsModel CustomerInfo;	
//
//	public CustomerAccountModel() {
//		
//	}
//
//
//	public CustomerAccountModel(String uci, Integer custAcctNum, String custName, String gender, Date dob, String emailId,
//			String mobileNum, String address, String city, String pincode, Date acctOpenDate, Date acctCloseDate,
//			String branchName, String branchIfsc, String custAcctStatus, List<CustomerBeneficiaryModel> beneficiaryList,
//			List<CustomerTransactionsInfoModel> transactionList, List<CustomerAccountTypesInfoModel> accountTypesList, KycDetailsModel customerInfo) {
//		super();
//		this.uci = uci;
//		this.custAcctNum = custAcctNum;
//		this.custName = custName;
//		this.gender = gender;
//		this.dob = dob;
//		this.emailId = emailId;
//		this.mobileNum = mobileNum;
//		this.address = address;
//		this.city = city;
//		this.pincode = pincode;
//		this.acctOpenDate = acctOpenDate;
//		this.acctCloseDate = acctCloseDate;
//		this.branchName = branchName;
//		this.branchIfsc = branchIfsc;
//		this.custAcctStatus = custAcctStatus;
//		BeneficiaryList = beneficiaryList;
//		TransactionList = transactionList;
//		AccountTypesList = accountTypesList;
//		CustomerInfo = customerInfo;
//		
//	}
//
//
//	public Long getUci() {
//		return uci;
//	}
//
//
//	public void setUci(String uci) {
//		this.uci = uci;
//	}
//
//
//	public Integer getCustAcctNum() {
//		return custAcctNum;
//	}
//
//
//	public void setCustAcctNum(Integer custAcctNum) {
//		this.custAcctNum = custAcctNum;
//	}
//
//
//	public String getCustName() {
//		return custName;
//	}
//
//
//	public void setCustName(String custName) {
//		this.custName = custName;
//	}
//
//
//	public String getGender() {
//		return gender;
//	}
//
//
//	public void setGender(String gender) {
//		this.gender = gender;
//	}
//
//
//	public Date getDob() {
//		return dob;
//	}
//
//
//	public void setDob(Date dob) {
//		this.dob = dob;
//	}
//
//
//	public String getEmailId() {
//		return emailId;
//	}
//
//
//	public void setEmailId(String emailId) {
//		this.emailId = emailId;
//	}
//
//
//	public String getMobileNum() {
//		return mobileNum;
//	}
//
//
//	public void setMobileNum(String mobileNum) {
//		this.mobileNum = mobileNum;
//	}
//
//
//	public String getAddress() {
//		return address;
//	}
//
//
//	public void setAddress(String address) {
//		this.address = address;
//	}
//
//
//	public String getCity() {
//		return city;
//	}
//
//
//	public void setCity(String city) {
//		this.city = city;
//	}
//
//
//	public String getPincode() {
//		return pincode;
//	}
//
//
//	public void setPincode(String pincode) {
//		this.pincode = pincode;
//	}
//
//
//	public Date getAcctOpenDate() {
//		return acctOpenDate;
//	}
//
//
//	public void setAcctOpenDate(Date acctOpenDate) {
//		this.acctOpenDate = acctOpenDate;
//	}
//
//
//	public Date getAcctCloseDate() {
//		return acctCloseDate;
//	}
//
//
//	public void setAcctCloseDate(Date acctCloseDate) {
//		this.acctCloseDate = acctCloseDate;
//	}
//
//
//	public String getBranchName() {
//		return branchName;
//	}
//
//
//	public void setBranchName(String branchName) {
//		this.branchName = branchName;
//	}
//
//
//	public String getBranchIfsc() {
//		return branchIfsc;
//	}
//
//
//	public void setBranchIfsc(String branchIfsc) {
//		this.branchIfsc = branchIfsc;
//	}
//
//
//	public String getCustAcctStatus() {
//		return custAcctStatus;
//	}
//
//
//	public void setCustAcctStatus(String custAcctStatus) {
//		this.custAcctStatus = custAcctStatus;
//	}
//
//
//	
//
//	public List<CustomerBeneficiaryModel> getBeneficiaryList() {
//		return BeneficiaryList;
//	}
//
//
//	public void setBeneficiaryList(List<CustomerBeneficiaryModel> beneficiaryList) {
//		BeneficiaryList = beneficiaryList;
//	}
//
//
//	public List<CustomerTransactionsInfoModel> getTransactionList() {
//		return TransactionList;
//	}
//
//
//	public void setTransactionList(List<CustomerTransactionsInfoModel> transactionList) {
//		TransactionList = transactionList;
//	}
//
//
//	public List<CustomerAccountTypesInfoModel> getAccountTypesList() {
//		return AccountTypesList;
//	}
//
//
//	public void setAccountTypesList(List<CustomerAccountTypesInfoModel> accountTypesList) {
//		AccountTypesList = accountTypesList;
//	}
//
//
//	public KycDetailsModel getCustomerInfo() {
//		return CustomerInfo;
//	}
//
//
//	public void setCustomerInfo(KycDetailsModel customerInfo) {
//		CustomerInfo = customerInfo;
//	}
//
//
//	
//	
//	
//
//
//}