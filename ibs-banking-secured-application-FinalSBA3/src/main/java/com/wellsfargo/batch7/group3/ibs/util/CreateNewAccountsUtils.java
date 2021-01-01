package com.wellsfargo.batch7.group3.ibs.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.wellsfargo.batch7.group3.ibs.entities.CustomerAccount;
import com.wellsfargo.batch7.group3.ibs.entities.CustomerAccountTypesInfo;
import com.wellsfargo.batch7.group3.ibs.entities.KycDetails;
import com.wellsfargo.batch7.group3.ibs.entities.ServiceProviderAccount;
import com.wellsfargo.batch7.group3.ibs.exception.IBSExceptionHandler;


public class CreateNewAccountsUtils {
	
	
	public static CustomerAccount parse(KycDetails source) {
		CustomerAccount target = new CustomerAccount();	
		
		target.setAcctStartDate(LocalDate.now());
		target.setAcctCloseDate(null);
		target.setAddress(source.getAddress());
//		target.setBranchIfsc(null);
//		target.setBranchName(null);
		target.setCity(source.getCity());
		target.setRegId(source.getRegId());
		target.setCustAcctStatus("Active");
		String CustomerName=source.getFirstName()+" "+source.getLastName();
		target.setCustName(CustomerName);
//		target.setCustomerInfo(source.get);
		target.setDob(source.getDob());
		target.setEmailId(source.getEmailId());
		target.setGender(source.getGender());
		target.setMobileNum(source.getMobileNum());
		target.setPincode(source.getPincode());
		
		String sysdate= DateTimeFormatter.ofPattern("uuMMdd").format(LocalDateTime.now());			
		String sysdate1= DateTimeFormatter.ofPattern("uuuuMMddHHmmss").format(LocalDateTime.now());
		String uci1 = target.getMobileNum() + sysdate;
		
		//String uci =Long.parseLong(uci1);
		target.setUci(uci1);
		
//		Long CustAcctNum=Long.parseLong(sysdate1);
//		target.setCustAcctNum(CustAcctNum);	
		
		target.setUserName(uci1);
		
		String Password=GeneraterRandomNumber.generateRandomChars(12);
		System.out.println("**********************************************************************");
		System.out.println("**********************************************************************");
		System.out.println("Password generated is "+ Password + "    UCI     " + uci1);
		System.out.println("**********************************************************************");
		System.out.println("**********************************************************************");
		target.setPassword(Password);
		
		target.setFirstLoginFlag("Pending");
		target.setRole("Customer");		
		target.setBranchName(source.getBranchName());
		target.setBranchIFSC(source.getBankIfsc());
			
//		List<CustomerAccountTypesInfo> target1 = new List<CustomerAccountTypesInfo>();		

		return target;
	}
	
	
	
	public static CustomerAccountTypesInfo parse(KycDetails source,String uci) throws IBSExceptionHandler  {
		
		CustomerAccountTypesInfo target = new CustomerAccountTypesInfo();
		target.setUci(uci);
		
		String sysdate1= source.getRegId()+DateTimeFormatter.ofPattern("uuuuMMddHHmmss").format(LocalDateTime.now());
		Long CustAcctNum=Long.parseLong(sysdate1);
		target.setCustomerAcctNum(CustAcctNum);
		
//		target.setCustomerAcctNum(custAcctNum);
		target.setCustAcctType(source.getCustAcctType());
		LocalDate acctCreatedOn =LocalDate.now();
		target.setCustAccountCreatedOn(acctCreatedOn);		
		System.out.println("CustomerAccountNumber" + CustAcctNum + "Amount" +source.getAmount());
		target.setAvailableBalance(source.getAmount());
			
		target.setTenure(source.getTenure());
	
		
		if(source.getCustAcctType().equals("Saving Account"))
		{			
			Double interestRate= LoadPropertiesFile.getValue("SavingAccount", source.getTenure());
		//	double maturityAmount= (source.getAmount()) +((source.getAmount()*interestRate*(source.getTenure()/12))/100);
			target.setInterestRate(interestRate); // from properties file						
		}
		else if (source.getCustAcctType().equals("Fixed Deposit"))
		{
			Double interestRate= LoadPropertiesFile.getValue("FixedAccount", source.getTenure());
			if(interestRate!=null)
			{	
			Double maturityAmount= Converters.getMaturityAmountFixed(source.getAmount(),interestRate,source.getTenure());
			target.setInterestRate(interestRate);
			target.setCustAccountClosedOn(acctCreatedOn.plusMonths(source.getTenure()));
			target.setMaturityAmount(maturityAmount);
			}
			else
			{
				throw new IBSExceptionHandler("ERR: This form cannot be accepted a per tenure and account type mismatch.Hence Reject it.");
			}
				
		}
		else if (source.getCustAcctType().equals("Recurring Deposit"))
		{
			
			Double interestRate= LoadPropertiesFile.getValue("RecurringAccount", source.getTenure());
			if(interestRate!=null)
			{
			double maturityAmount= Converters.getMaturityAmountRecurring(source.getAmount(),interestRate,source.getTenure());
			target.setInterestRate(interestRate);
			target.setCustAccountClosedOn(acctCreatedOn.plusMonths(source.getTenure()));
			target.setMaturityAmount(maturityAmount);
			target.setMonthlyInstallment(source.getAmount());
			}
			else
			{
				throw new IBSExceptionHandler("ERR: This form cannot be accepted a per tenure and account type mismatch.Hence Reject it.");
			}
		}
		else
		{
			
		}		
		
		target.setBranchName(source.getBranchName());
		target.setBranchIFSC(source.getBankIfsc());	
		
		
		target.setAccountStatus("ACTIVE");		
		
		
		return target;		
	}
	

	public static ServiceProviderAccount parse(KycDetails source,String holderType, String flag) {
		ServiceProviderAccount target = new ServiceProviderAccount();	
		
		//String serviceprovidername=source.getFirstName()+source.getLastName();
		target.setServiceProviderName(source.getServiceProviderName());
		target.setAccountId(source.getServProBankAccount());
		target.setBankName(source.getServProBankName());
		target.setBranchName(source.getServProBankBranch());
		target.setIfscCode(source.getServProBankIFSC());
		String sysdate= DateTimeFormatter.ofPattern("uuMMdd").format(LocalDateTime.now());
		String uci1 = source.getMobileNum() + sysdate;
		//Long sp1 =Long.parseLong(uci1);
		target.setServiceProviderId(uci1);
		target.setSvcEndDate(null);
		target.setSvcStartDate(LocalDate.now());
		target.setCreatedDt(LocalDate.now());
		
		target.setUserName(uci1);
		String Password=GeneraterRandomNumber.generateRandomChars(12);
		
		System.out.println("**********************************************************************");
		System.out.println("**********************************************************************");
		System.out.println("Password generated is "+ Password + "    ServiceProvider     " + uci1);
		System.out.println("**********************************************************************");
		System.out.println("**********************************************************************");
		target.setPassword(Password);
		target.setFirstLoginFlag("Pending");
		target.setRole("ServiceProvider");
					
		
		
		return target;
	}


}
