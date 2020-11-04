package com.wellsfargo.batch7.group3.model;

public class FundsTransfer {
	
	private Integer custAcctNum;
	private String bnfcryName; 
	private double bnfcryAcctNum;
	private String bnfcryBank;
	private String bnfcryIfsc;
	private String bnfcryTxnType;
	private Double bnfcryTrnsfrAmt;
	private String bnfcryTxnComments;
	private String bnfcryMobileNum;
	private String TxnStatus;
	
	public FundsTransfer() {
		super();
	}
	
	
	
	
	public FundsTransfer(Integer custAcctNum, String bnfcryName, double bnfcryAcctNum, String bnfcryBank,
			String bnfcryIfsc, String bnfcryTxnType, Double bnfcryTrnsfrAmt, String bnfcryTxnComments,
			String bnfcryMobileNum, String txnStatus) {
		super();
		this.custAcctNum = custAcctNum;
		this.bnfcryName = bnfcryName;
		this.bnfcryAcctNum = bnfcryAcctNum;
		this.bnfcryBank = bnfcryBank;
		this.bnfcryIfsc = bnfcryIfsc;
		this.bnfcryTxnType = bnfcryTxnType;
		this.bnfcryTrnsfrAmt = bnfcryTrnsfrAmt;
		this.bnfcryTxnComments = bnfcryTxnComments;
		this.bnfcryMobileNum = bnfcryMobileNum;
		TxnStatus = txnStatus;
	}




	public String getTxnStatus() {
		return TxnStatus;
	}

	public void setTxnStatus(String txnStatus) {
		TxnStatus = txnStatus;
	}

	
	public String getBnfcryTxnComments() {
		return bnfcryTxnComments;
	}


	public void setBnfcryTxnComments(String bnfcryTxnComments) {
		this.bnfcryTxnComments = bnfcryTxnComments;
	}




	public Integer getCustAcctNum() {
		return custAcctNum;
	}

	public void setCustAcctNum(Integer custAcctNum) {
		this.custAcctNum = custAcctNum;
	}

	public String getBnfcryName() {
		return bnfcryName;
	}

	public void setBnfcryName(String bnfcryName) {
		this.bnfcryName = bnfcryName;
	}

	public double getBnfcryAcctNum() {
		return bnfcryAcctNum;
	}

	public void setBnfcryAcctNum(double bnfcryAcctNum) {
		this.bnfcryAcctNum = bnfcryAcctNum;
	}

	public String getBnfcryBank() {
		return bnfcryBank;
	}

	public void setBnfcryBank(String bnfcryBank) {
		this.bnfcryBank = bnfcryBank;
	}

	public String getBnfcryIfsc() {
		return bnfcryIfsc;
	}

	public void setBnfcryIfsc(String bnfcryIfsc) {
		this.bnfcryIfsc = bnfcryIfsc;
	}

	public String getBnfcryTxnType() {
		return bnfcryTxnType;
	}

	public void setBnfcryTxnType(String bnfcryTxnType) {
		this.bnfcryTxnType = bnfcryTxnType;
	}

	public String getBnfcryMobileNum() {
		return bnfcryMobileNum;
	}

	public void setBnfcryMobileNum(String bnfcryMobileNum) {
		this.bnfcryMobileNum = bnfcryMobileNum;
	}
	
	public Double getBnfcryTrnsfrAmt() {
		return bnfcryTrnsfrAmt;
	}

	public void setBnfcryTrnsfrAmt(Double bnfcryTrnsfrAmt) {
		this.bnfcryTrnsfrAmt = bnfcryTrnsfrAmt;
	}


	
}
