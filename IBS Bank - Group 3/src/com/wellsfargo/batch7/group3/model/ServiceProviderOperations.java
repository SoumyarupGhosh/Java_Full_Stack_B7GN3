package com.wellsfargo.batch7.group3.model;

import java.time.LocalDate;

public class ServiceProviderOperations {
	
	private Integer serviceProviderId;
	private String serviceProviderName;
	private String bankName;
	private Integer acctId;
	private String branchName;
	private Integer ifscCode;
	private LocalDate svcStartDate;
	private LocalDate svcEndDate;
	public ServiceProviderOperations() {
		super();
	}
	public ServiceProviderOperations(Integer serviceProviderId, String serviceProviderName, String bankName,
			Integer acctId, String branchName, Integer ifscCode, LocalDate svcStartDate, LocalDate svcEndDate) {
		super();
		this.serviceProviderId = serviceProviderId;
		this.serviceProviderName = serviceProviderName;
		this.bankName = bankName;
		this.acctId = acctId;
		this.branchName = branchName;
		this.ifscCode = ifscCode;
		this.svcStartDate = svcStartDate;
		this.svcEndDate = svcEndDate;
	}
	public Integer getServiceProviderId() {
		return serviceProviderId;
	}
	public void setServiceProviderId(Integer serviceProviderId) {
		this.serviceProviderId = serviceProviderId;
	}
	public String getServiceProviderName() {
		return serviceProviderName;
	}
	public void setServiceProviderName(String serviceProviderName) {
		this.serviceProviderName = serviceProviderName;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public Integer getAcctId() {
		return acctId;
	}
	public void setAcctId(Integer acctId) {
		this.acctId = acctId;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public Integer getIfscCode() {
		return ifscCode;
	}
	public void setIfscCode(Integer ifscCode) {
		this.ifscCode = ifscCode;
	}
	public LocalDate getSvcStartDate() {
		return svcStartDate;
	}
	public void setSvcStartDate(LocalDate svcStartDate) {
		this.svcStartDate = svcStartDate;
	}
	public LocalDate getSvcEndDate() {
		return svcEndDate;
	}
	public void setSvcEndDate(LocalDate svcEndDate) {
		this.svcEndDate = svcEndDate;
	}
	


	
}
