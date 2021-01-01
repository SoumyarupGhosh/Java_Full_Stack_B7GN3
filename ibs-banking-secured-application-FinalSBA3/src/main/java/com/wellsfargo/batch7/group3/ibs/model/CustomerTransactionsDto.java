package com.wellsfargo.batch7.group3.ibs.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class CustomerTransactionsDto{
	
	private Long txnId;	
	private String uci;
	private String txnType;
	private String txnMode;
	private Long fromAcctNum;	
	private Long toAcctNum;
	private Double txnAmt;
	
	private Long effAcctNum;
	private Double currentBalanceEffAcctNum;
	
	
	private String txnCmnts;
	private LocalDate txnDate;
	
	public CustomerTransactionsDto() {
		super();
	}

	public CustomerTransactionsDto(Long txnId, String uci, String txnType, String txnMode, Long fromAcctNum,
			Long toAcctNum, Double txnAmt, Long effAcctNum, Double currentBalanceEffAcctNum, 
			String txnCmnts, LocalDate txnDate) {
		super();
		this.txnId = txnId;
		this.uci = uci;
		this.txnType = txnType;
		this.txnMode = txnMode;
		this.fromAcctNum = fromAcctNum;
		this.toAcctNum = toAcctNum;
		this.txnAmt = txnAmt;
		this.effAcctNum = effAcctNum;
		this.currentBalanceEffAcctNum = currentBalanceEffAcctNum;
		
		this.txnCmnts = txnCmnts;
		this.txnDate = txnDate;
	}

	public Long getTxnId() {
		return txnId;
	}

	public void setTxnId(Long txnId) {
		this.txnId = txnId;
	}

	public String getUci() {
		return uci;
	}

	public void setUci(String uci) {
		this.uci = uci;
	}

	public String getTxnType() {
		return txnType;
	}

	public void setTxnType(String txnType) {
		this.txnType = txnType;
	}

	public String getTxnMode() {
		return txnMode;
	}

	public void setTxnMode(String txnMode) {
		this.txnMode = txnMode;
	}

	public Long getFromAcctNum() {
		return fromAcctNum;
	}

	public void setFromAcctNum(Long fromAcctNum) {
		this.fromAcctNum = fromAcctNum;
	}

	public Long getToAcctNum() {
		return toAcctNum;
	}

	public void setToAcctNum(Long toAcctNum) {
		this.toAcctNum = toAcctNum;
	}

	public Double getTxnAmt() {
		return txnAmt;
	}

	public void setTxnAmt(Double txnAmt) {
		this.txnAmt = txnAmt;
	}

	public Long getEffAcctNum() {
		return effAcctNum;
	}

	public void setEffAcctNum(Long effAcctNum) {
		this.effAcctNum = effAcctNum;
	}

	public Double getCurrentBalanceEffAcctNum() {
		return currentBalanceEffAcctNum;
	}

	public void setCurrentBalanceEffAcctNum(Double currentBalanceEffAcctNum) {
		this.currentBalanceEffAcctNum = currentBalanceEffAcctNum;
	}


	public String getTxnCmnts() {
		return txnCmnts;
	}

	public void setTxnCmnts(String txnCmnts) {
		this.txnCmnts = txnCmnts;
	}

	public LocalDate getTxnDate() {
		return txnDate;
	}

	public void setTxnDate(LocalDate txnDate) {
		this.txnDate = txnDate;
	}

	
}