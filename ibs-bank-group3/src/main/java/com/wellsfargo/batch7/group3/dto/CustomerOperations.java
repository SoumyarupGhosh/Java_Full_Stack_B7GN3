package com.wellsfargo.batch7.group3.dto;

import java.time.LocalDate;

public class CustomerOperations {
	
	private Integer uci;
	private Integer custAcctNum;
	private String custName; 
	private double availableBalance;
	private LocalDate acctStartDate;
	private LocalDate acctCloseDate;
	private String branchName;
	private String branchIFSC;
	private double interestRate;
	private String custAcctStatus;
	
	public CustomerOperations() {
		super();
	}

	public CustomerOperations(Integer uci, Integer custAcctNum, String custName, double availableBalance,
			LocalDate acctStartDate, LocalDate acctCloseDate, String branchName, String branchIFSC, double interestRate,
			String custAcctStatus) {
		super();
		this.uci = uci;
		this.custAcctNum = custAcctNum;
		this.custName = custName;
		this.availableBalance = availableBalance;
		this.acctStartDate = acctStartDate;
		this.acctCloseDate = acctCloseDate;
		this.branchName = branchName;
		this.branchIFSC = branchIFSC;
		this.interestRate = interestRate;
		this.custAcctStatus = custAcctStatus;
	}

	public Integer getUci() {
		return uci;
	}

	public void setUci(Integer uci) {
		this.uci = uci;
	}

	public Integer getCustAcctNum() {
		return custAcctNum;
	}

	public void setCustAcctNum(Integer custAcctNum) {
		this.custAcctNum = custAcctNum;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public double getAvailableBalance() {
		return availableBalance;
	}

	public void setAvailableBalance(double availableBalance) {
		this.availableBalance = availableBalance;
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

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	public String getCustAcctStatus() {
		return custAcctStatus;
	}

	public void setCustAcctStatus(String custAcctStatus) {
		this.custAcctStatus = custAcctStatus;
	}

	
}
