package com.wellsfargo.batch7.group3.ibs.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="CUST_BNFCRY")
public class CustomerBeneficiary{
	
	@Id
	@Column(name="BNFCRY_ID")
	@GeneratedValue
	private Long bnfcryId;
	
	@Column(name="CUST_ACCT_NUM")
	private Long custAcctNum;
	
	@Column(name="BNFCRY_ACCT_NUM")
	private Long bnfcryAcctNum;
	
	@Column(name="BNFCRY_ACCT_NAME")
	private String bnfcryAcctName; 
	
	@Column(name="BNFCRY_BANK_NAME")
	private String bnfcryBankName;

	@Column(name="BNFCRY_ACCT_IFSC")
	private String bnfcryBankIfsc;

	@Column(name="BNFCRY_TXN_TYP")
	private String bnfcryTxnType;
	
	@Column(name="BNFCRY_MOBILE_NUM")
	private String bnfcryMblNum;
	
	private String bnfcryStatus;
	private String uci;

	public CustomerBeneficiary() {
		super();
	}

	

	public CustomerBeneficiary(Long bnfcryId, Long custAcctNum, Long bnfcryAcctNum, String bnfcryAcctName,
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
