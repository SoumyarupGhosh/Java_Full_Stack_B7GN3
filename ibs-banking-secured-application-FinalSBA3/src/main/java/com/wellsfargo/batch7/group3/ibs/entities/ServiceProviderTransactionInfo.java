package com.wellsfargo.batch7.group3.ibs.entities;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;


@Entity
//@Table(name="service_provider")

public class ServiceProviderTransactionInfo {

	
	@Id
	//@GeneratedValue
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long txnId;	
	private String serviceProviderId;
	private Long serviceProvideraccountId;	
	private Long fromCustomerAccount; //Added
	private String fromCustomerName; //Added
	private String txnType;	
	private Double paymentAmt;
	private Double currentBalance;	//Added	
//	private Long txnNumber;	
	private LocalDate txnDateTime;
	private String txnCmnts;
	
	public ServiceProviderTransactionInfo() {
		
		// TODO Auto-generated constructor stub
	}

	public ServiceProviderTransactionInfo(Long txnId, String serviceProviderId, Long serviceProvideraccountId,
			Long fromCustomerAccount, String fromCustomerName, String txnType, Double paymentAmt, Double currentBalance,
			LocalDate txnDateTime, String txnCmnts) {
		super();
		this.txnId = txnId;
		this.serviceProviderId = serviceProviderId;
		this.serviceProvideraccountId = serviceProvideraccountId;
		this.fromCustomerAccount = fromCustomerAccount;
		this.fromCustomerName = fromCustomerName;
		this.txnType = txnType;
		this.paymentAmt = paymentAmt;
		this.currentBalance = currentBalance;
		this.txnDateTime = txnDateTime;
		this.txnCmnts = txnCmnts;
	}

	public Long getTxnId() {
		return txnId;
	}

	public void setTxnId(Long txnId) {
		this.txnId = txnId;
	}

	public String getServiceProviderId() {
		return serviceProviderId;
	}

	public void setServiceProviderId(String serviceProviderId) {
		this.serviceProviderId = serviceProviderId;
	}

	public Long getServiceProvideraccountId() {
		return serviceProvideraccountId;
	}

	public void setServiceProvideraccountId(Long serviceProvideraccountId) {
		this.serviceProvideraccountId = serviceProvideraccountId;
	}

	public Long getFromCustomerAccount() {
		return fromCustomerAccount;
	}

	public void setFromCustomerAccount(Long fromCustomerAccount) {
		this.fromCustomerAccount = fromCustomerAccount;
	}

	public String getFromCustomerName() {
		return fromCustomerName;
	}

	public void setFromCustomerName(String fromCustomerName) {
		this.fromCustomerName = fromCustomerName;
	}

	public String getTxnType() {
		return txnType;
	}

	public void setTxnType(String txnType) {
		this.txnType = txnType;
	}

	public Double getPaymentAmt() {
		return paymentAmt;
	}

	public void setPaymentAmt(Double paymentAmt) {
		this.paymentAmt = paymentAmt;
	}

	public Double getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(Double currentBalance) {
		this.currentBalance = currentBalance;
	}

	public LocalDate getTxnDateTime() {
		return txnDateTime;
	}

	public void setTxnDateTime(LocalDate txnDateTime) {
		this.txnDateTime = txnDateTime;
	}

	public String getTxnCmnts() {
		return txnCmnts;
	}

	public void setTxnCmnts(String txnCmnts) {
		this.txnCmnts = txnCmnts;
	}
	
	


}