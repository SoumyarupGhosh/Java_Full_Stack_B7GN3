package com.wellsfargo.batch7.group3.ibs.model;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

public class AccountStatementDto{
	
	private String startDate;
	private String endDate;
	private Long custAcctNum;
	private String uci;
	
	
	public AccountStatementDto() {
		super();
	}

	 
	

	public AccountStatementDto(String startDate, String endDate, Long custAcctNum, String uci) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
		this.custAcctNum = custAcctNum;
		this.uci = uci;
	}




	public String getUci() {
		return uci;
	}



	public void setUci(String uci) {
		this.uci = uci;
	}


	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public Long getCustAcctNum() {
		return custAcctNum;
	}

	public void setCustAcctNum(Long custAcctNum) {
		this.custAcctNum = custAcctNum;
	}

	public String getUserName() {
		return uci;
	}

	public void setUserName(String uci) {
		this.uci = uci;
	}

	
	
	
		
}
