package com.wellsfargo.batch7.group3.ibs.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.wellsfargo.batch7.group3.ibs.entities.CustomerAccount;
import com.wellsfargo.batch7.group3.ibs.entities.CustomerAccountTypesInfo;
import com.wellsfargo.batch7.group3.ibs.entities.CustomerBeneficiary;
import com.wellsfargo.batch7.group3.ibs.entities.CustomerTransactions;
import com.wellsfargo.batch7.group3.ibs.model.CustomerAccountTypesInfoDto;
import com.wellsfargo.batch7.group3.ibs.model.CustomerBeneficiaryDto;
import com.wellsfargo.batch7.group3.ibs.model.CustomerTransactionsDto;

public class EMnMEParserCust {
	
	public static CustomerBeneficiaryDto bnfParse(CustomerBeneficiary source) { // was private no static inside customerimpl class
		CustomerBeneficiaryDto target = new CustomerBeneficiaryDto();
		target.setBnfcryAcctNum(source.getBnfcryAcctNum());
		target.setCustAcctNum(source.getCustAcctNum());
		target.setBnfcryAcctName(source.getBnfcryAcctName());
		target.setBnfcryBankName(source.getBnfcryBankName());
		target.setBnfcryBankIfsc(source.getBnfcryBankIfsc());
		target.setBnfcryMblNum(source.getBnfcryMblNum());
		target.setCustAcctNum(source.getCustAcctNum());
		target.setBnfcryTxnType("IMPS");
		target.setBnfcryStatus(source.getBnfcryStatus());
		target.setBnfcryId(source.getBnfcryId());
		target.setUci(source.getUci());
		return target;
	}
	
	public static CustomerBeneficiary bnfParse(CustomerBeneficiaryDto source , Long custAcctNum) {
		CustomerBeneficiary target = new CustomerBeneficiary();
		target.setBnfcryAcctNum(source.getBnfcryAcctNum());
		target.setCustAcctNum(custAcctNum);
		target.setBnfcryAcctName(source.getBnfcryAcctName());
		target.setBnfcryBankName(source.getBnfcryBankName());
		target.setBnfcryBankIfsc(source.getBnfcryBankIfsc());
		target.setBnfcryMblNum(source.getBnfcryMblNum());
		target.setUci(source.getUci());
		target.setBnfcryStatus("Pending");
		target.setBnfcryTxnType("IMPS");
		
		return target;
	}
	
	public static  CustomerBeneficiary bnfParse(CustomerBeneficiaryDto source) {
		CustomerBeneficiary target = new CustomerBeneficiary();
		target.setBnfcryAcctNum(source.getBnfcryAcctNum());
		target.setCustAcctNum(source.getCustAcctNum());
		target.setBnfcryAcctName(source.getBnfcryAcctName());
		target.setBnfcryBankName(source.getBnfcryBankName());
		target.setBnfcryBankIfsc(source.getBnfcryBankIfsc());
		target.setBnfcryMblNum(source.getBnfcryMblNum());
		target.setUci(source.getUci());
		target.setBnfcryStatus(source.getBnfcryStatus());
		target.setBnfcryTxnType("IMPS");
		
		return target;
	}
	
	public static CustomerAccountTypesInfoDto custDataParse(CustomerAccountTypesInfo source) {
		CustomerAccountTypesInfoDto target = new CustomerAccountTypesInfoDto();
		target.setUci(source.getUci());
		target.setAvailableBalance(source.getAvailableBalance());
		target.setCustAcctType(source.getCustAcctType());
		target.setCustomerAcctNum(source.getCustomerAcctNum());
		target.setInterestRate(source.getInterestRate());
		target.setTenure(source.getTenure());
		target.setBranchName(source.getBranchName());
		target.setBranchIFSC(source.getBranchIFSC());
		target.setMaturityAmount(source.getMaturityAmount());
		target.setCustAccountClosedOn(source.getCustAccountClosedOn());
		target.setCustAccountCreatedOn(source.getCustAccountCreatedOn());
		target.setMonthlyInstallment(source.getMonthlyInstallment());
		return target;		
	}
	
	//new account open
	public static CustomerAccountTypesInfo custDataParse(CustomerAccountTypesInfoDto source, String uci,Long regId) {
		CustomerAccountTypesInfo target = new CustomerAccountTypesInfo();
		
		target.setUci(uci);
		
		String sysdate1= regId+ DateTimeFormatter.ofPattern("uuuuMMddHHmmss").format(LocalDateTime.now());
		Long custAcctNum=Long.parseLong(sysdate1);
		target.setCustomerAcctNum(custAcctNum);
				
		LocalDate acctCreatedOn =LocalDate.now();
		target.setCustAccountCreatedOn(acctCreatedOn);		
		
		target.setCustAcctType(source.getCustAcctType());
		target.setAvailableBalance(source.getAvailableBalance());		
		
		if(source.getCustAcctType().equals("Saving Account"))
		{			
			Double interestRate= LoadPropertiesFile.getValue("SavingAccount", (long) 0);
		//	double maturityAmount= (source.getAmount()) +((source.getAmount()*interestRate*(source.getTenure()/12))/100);
			target.setInterestRate(interestRate); // from properties file						
		}
		else if (source.getCustAcctType().equals("Fixed Deposit"))
		{
			Double interestRate= LoadPropertiesFile.getValue("FixedAccount", source.getTenure());
			Double maturityAmount= Converters.getMaturityAmountFixed(source.getAvailableBalance(),interestRate,source.getTenure());
			target.setInterestRate(interestRate);
			target.setCustAccountClosedOn(acctCreatedOn.plusMonths(source.getTenure()));
			target.setMaturityAmount(maturityAmount);
		}
		else if (source.getCustAcctType().equals("Recurring Deposit"))
		{
			Double interestRate= LoadPropertiesFile.getValue("RecurringAccount", source.getTenure());
			double maturityAmount= Converters.getMaturityAmountRecurring(source.getAvailableBalance(),interestRate,source.getTenure());
			target.setInterestRate(interestRate);
			target.setCustAccountClosedOn(acctCreatedOn.plusMonths(source.getTenure()));
			target.setMaturityAmount(maturityAmount);
			target.setMonthlyInstallment(source.getAvailableBalance());
		}
		else
		{
			
		}	
		target.setTenure(source.getTenure());
		target.setBranchName(source.getBranchName());
		target.setBranchIFSC(LoadPropertiesFile.getBranch(source.getBranchName()));		
		target.setAccountStatus("ACTIVE");		
		
		return target;		
	}
	
	
	public static CustomerBeneficiaryDto bnfcryParse(CustomerBeneficiary source) {
		CustomerBeneficiaryDto target = new CustomerBeneficiaryDto();
		
		target.setBnfcryId(source.getBnfcryId());
		target.setBnfcryAcctNum(source.getBnfcryAcctNum());
		target.setBnfcryAcctName(source.getBnfcryAcctName());
		target.setBnfcryBankName(source.getBnfcryBankName());
		target.setBnfcryBankIfsc(source.getBnfcryBankIfsc());
		target.setBnfcryMblNum(source.getBnfcryMblNum());
		target.setCustAcctNum(source.getCustAcctNum());
		target.setBnfcryStatus(source.getBnfcryStatus());
		return target;
	}
	
	
	public static CustomerAccountTypesInfoDto updateParse(CustomerAccountTypesInfo custAcct) {
		CustomerAccountTypesInfoDto updCust = new CustomerAccountTypesInfoDto();
		updCust.setAvailableBalance(custAcct.getAvailableBalance());
		updCust.setAccountStatus(custAcct.getAccountStatus());
		updCust.setBranchIFSC(custAcct.getBranchIFSC());
		updCust.setBranchName(custAcct.getBranchName());
		updCust.setCustAccountClosedOn(custAcct.getCustAccountClosedOn());
		updCust.setCustAccountCreatedOn(custAcct.getCustAccountCreatedOn());
		updCust.setCustAcctType(custAcct.getCustAcctType());
		updCust.setCustAcctTypeId(custAcct.getCustAcctTypeId());
		updCust.setCustomerAcctNum(custAcct.getCustomerAcctNum());
		updCust.setInterestRate(custAcct.getInterestRate());
		updCust.setMaturityAmount(custAcct.getMaturityAmount());
		updCust.setMonthlyInstallment(custAcct.getMonthlyInstallment());
		updCust.setTenure(custAcct.getTenure());
		updCust.setUci(custAcct.getUci());
		return updCust;
	}
	
	public static CustomerTransactions txnParse( CustomerTransactionsDto source,String uci, String txnType) {
		CustomerTransactions target = new CustomerTransactions();
		
//		target.setCustAcctNum(source.getFromAcctNum());
		target.setUci(uci);
		target.setTxnType(txnType);		
		target.setFromAcctNum(source.getFromAcctNum());		
		target.setToAcctNum(source.getToAcctNum());		
		target.setTxnAmt(source.getTxnAmt());
		target.setTxnCmnts(source.getTxnCmnts());
		target.setCurrentBalanceEffAcctNum(source.getCurrentBalanceEffAcctNum());
		target.setEffAcctNum(source.getEffAcctNum());
		target.setTxnMode(source.getTxnMode());
		target.setTxnDate(LocalDate.now());
		target.setTxnId(source.getTxnId());
		return target;
	}
	
	public static CustomerTransactionsDto txnParse( CustomerTransactions source) {
		CustomerTransactionsDto target = new CustomerTransactionsDto();
		
//		target.setCustAcctNum(source.getFromAcctNum());
		target.setUci(source.getUci());
		target.setTxnDate(source.getTxnDate());
		target.setFromAcctNum(source.getFromAcctNum());
		target.setToAcctNum(source.getToAcctNum());
		target.setTxnAmt(source.getTxnAmt());
		target.setTxnCmnts(source.getTxnCmnts());
		target.setTxnType(source.getTxnType());
		target.setTxnMode(source.getTxnMode());
		target.setCurrentBalanceEffAcctNum(source.getCurrentBalanceEffAcctNum());
		target.setEffAcctNum(source.getEffAcctNum());
		target.setTxnId(source.getTxnId());
		return target;
	}


}
