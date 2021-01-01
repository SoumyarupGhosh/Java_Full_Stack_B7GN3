package com.wellsfargo.batch7.group3.ibs.model;

	import java.time.LocalDate;
	import java.util.List;

	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.Id;
	import javax.persistence.JoinColumn;
	import javax.persistence.ManyToOne;
	import javax.persistence.OneToMany;
	import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.wellsfargo.batch7.group3.ibs.entities.CustomerAccount;

	
	//@Table(name="customer_accounttypeInfo")
	public class CustomerAccountTypesInfoDto {
		
		
		private Long custAcctTypeId;
		
		private String custAcctType;
		private Double monthlyInstallment;
		private Double availableBalance;		
		private Long tenure;
		private Double interestRate;	
		@DateTimeFormat(iso=ISO.DATE)
		private LocalDate custAccountCreatedOn;
		@DateTimeFormat(iso=ISO.DATE)
		
		private LocalDate custAccountClosedOn;		
		private String accountStatus;
		
		private Long customerAcctNum;
		private String uci;
		private String branchName;
		private String branchIFSC;
		private Double maturityAmount;
		
		private CustomerAccount custMapAcctNum;
		
		
		public CustomerAccountTypesInfoDto() {
			
			// TODO Auto-generated constructor stub
		}


		public CustomerAccountTypesInfoDto(Long custAcctTypeId, String custAcctType, Double monthlyInstallment,
				Double availableBalance, Long tenure, Double interestRate, LocalDate custAccountCreatedOn,
				LocalDate custAccountClosedOn, String accountStatus, Long customerAcctNum, String uci, String branchName,
				String branchIFSC, Double maturityAmount, CustomerAccount custMapAcctNum) {
			super();
			this.custAcctTypeId = custAcctTypeId;
			this.custAcctType = custAcctType;
			this.monthlyInstallment = monthlyInstallment;
			this.availableBalance = availableBalance;
			this.tenure = tenure;
			this.interestRate = interestRate;
			this.custAccountCreatedOn = custAccountCreatedOn;
			this.custAccountClosedOn = custAccountClosedOn;
			this.accountStatus = accountStatus;
			this.customerAcctNum = customerAcctNum;
			this.uci = uci;
			this.branchName = branchName;
			this.branchIFSC = branchIFSC;
			this.maturityAmount = maturityAmount;
			this.custMapAcctNum = custMapAcctNum;
		}


		public Long getCustAcctTypeId() {
			return custAcctTypeId;
		}


		public void setCustAcctTypeId(Long custAcctTypeId) {
			this.custAcctTypeId = custAcctTypeId;
		}


		public String getCustAcctType() {
			return custAcctType;
		}


		public void setCustAcctType(String custAcctType) {
			this.custAcctType = custAcctType;
		}


		public Double getMonthlyInstallment() {
			return monthlyInstallment;
		}


		public void setMonthlyInstallment(Double monthlyInstallment) {
			this.monthlyInstallment = monthlyInstallment;
		}


		public Double getAvailableBalance() {
			return availableBalance;
		}


		public void setAvailableBalance(Double availableBalance) {
			this.availableBalance = availableBalance;
		}


		public Long getTenure() {
			return tenure;
		}


		public void setTenure(Long tenure) {
			this.tenure = tenure;
		}


		public Double getInterestRate() {
			return interestRate;
		}


		public void setInterestRate(Double interestRate) {
			this.interestRate = interestRate;
		}


		public LocalDate getCustAccountCreatedOn() {
			return custAccountCreatedOn;
		}


		public void setCustAccountCreatedOn(LocalDate custAccountCreatedOn) {
			this.custAccountCreatedOn = custAccountCreatedOn;
		}


		public LocalDate getCustAccountClosedOn() {
			return custAccountClosedOn;
		}


		public void setCustAccountClosedOn(LocalDate custAccountClosedOn) {
			this.custAccountClosedOn = custAccountClosedOn;
		}


		public String getAccountStatus() {
			return accountStatus;
		}


		public void setAccountStatus(String accountStatus) {
			this.accountStatus = accountStatus;
		}


		public Long getCustomerAcctNum() {
			return customerAcctNum;
		}


		public void setCustomerAcctNum(Long customerAcctNum) {
			this.customerAcctNum = customerAcctNum;
		}


		public String getUci() {
			return uci;
		}


		public void setUci(String uci) {
			this.uci = uci;
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


		public Double getMaturityAmount() {
			return maturityAmount;
		}


		public void setMaturityAmount(Double maturityAmount) {
			this.maturityAmount = maturityAmount;
		}


		public CustomerAccount getCustMapAcctNum() {
			return custMapAcctNum;
		}


		public void setCustMapAcctNum(CustomerAccount custMapAcctNum) {
			this.custMapAcctNum = custMapAcctNum;
		}	
		
		
		
	}
