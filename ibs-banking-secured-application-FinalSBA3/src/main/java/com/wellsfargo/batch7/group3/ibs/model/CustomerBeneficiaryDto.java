package com.wellsfargo.batch7.group3.ibs.model;

import javax.validation.constraints.Pattern;

public class CustomerBeneficiaryDto{
	
	private Long bnfcryId;
	private Long custAcctNum;
	private Long bnfcryAcctNum;
	private String bnfcryAcctName; 
	private String bnfcryBankName;
	private String bnfcryBankIfsc;
	private String bnfcryTxnType;
	private String bnfcryMblNum;
	
	private String bnfcryStatus;
	private String uci;

	public CustomerBeneficiaryDto() {
		super();
	}

	

	public CustomerBeneficiaryDto(Long bnfcryId, Long custAcctNum, Long bnfcryAcctNum, String bnfcryAcctName,
			String bnfcryBankName, String bnfcryBankIfsc, String bnfcryTxnType, String bnfcryMblNum,
			String bnfcryStatus, String uci) {
		super();
		this.bnfcryId = bnfcryId;
		this.custAcctNum = custAcctNum;
		this.bnfcryAcctNum = bnfcryAcctNum;
		this.bnfcryAcctName = bnfcryAcctName;
		this.bnfcryBankName = bnfcryBankName;
		this.bnfcryBankIfsc = bnfcryBankIfsc;
		this.bnfcryTxnType = bnfcryTxnType;
		this.bnfcryMblNum = bnfcryMblNum;
		this.bnfcryStatus = bnfcryStatus;
		this.uci = uci;
	}



	public Long getBnfcryId() {
		return bnfcryId;
	}

	public void setBnfcryId(Long bnfcryId) {
		this.bnfcryId = bnfcryId;
	}

	public Long getCustAcctNum() {
		return custAcctNum;
	}

	public void setCustAcctNum(Long custAcctNum) {
		this.custAcctNum = custAcctNum;
	}

	public Long getBnfcryAcctNum() {
		return bnfcryAcctNum;
	}

	public void setBnfcryAcctNum(Long bnfcryAcctNum) {
		this.bnfcryAcctNum = bnfcryAcctNum;
	}

	public String getBnfcryAcctName() {
		return bnfcryAcctName;
	}

	public void setBnfcryAcctName(String bnfcryAcctName) {
		this.bnfcryAcctName = bnfcryAcctName;
	}

	public String getBnfcryBankName() {
		return bnfcryBankName;
	}

	public void setBnfcryBankName(String bnfcryBankName) {
		this.bnfcryBankName = bnfcryBankName;
	}

	public String getBnfcryBankIfsc() {
		return bnfcryBankIfsc;
	}

	public void setBnfcryBankIfsc(String bnfcryBankIfsc) {
		this.bnfcryBankIfsc = bnfcryBankIfsc;
	}

	public String getBnfcryTxnType() {
		return bnfcryTxnType;
	}

	public void setBnfcryTxnType(String bnfcryTxnType) {
		this.bnfcryTxnType = bnfcryTxnType;
	}

	public String getBnfcryMblNum() {
		return bnfcryMblNum;
	}

	public void setBnfcryMblNum(String bnfcryMblNum) {
		this.bnfcryMblNum = bnfcryMblNum;
	}

	public String getBnfcryStatus() {
		return bnfcryStatus;
	}

	public void setBnfcryStatus(String bnfcryStatus) {
		this.bnfcryStatus = bnfcryStatus;
	}



	public String getUci() {
		return uci;
	}



	public void setUci(String uci) {
		this.uci = uci;
	}

	
	
	
	
	
}
