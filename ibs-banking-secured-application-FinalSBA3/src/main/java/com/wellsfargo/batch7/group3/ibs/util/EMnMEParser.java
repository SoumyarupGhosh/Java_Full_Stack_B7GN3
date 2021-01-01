package com.wellsfargo.batch7.group3.ibs.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.validation.Valid;

import com.wellsfargo.batch7.group3.ibs.entities.CustomerAccount;
import com.wellsfargo.batch7.group3.ibs.entities.CustomerAccountTypesInfo;
import com.wellsfargo.batch7.group3.ibs.entities.KycDetails;
import com.wellsfargo.batch7.group3.ibs.entities.ServiceProviderAccount;
import com.wellsfargo.batch7.group3.ibs.entities.ServiceProviderTransactionInfo;
import com.wellsfargo.batch7.group3.ibs.model.CustomerNewPasswordModel;
import com.wellsfargo.batch7.group3.ibs.model.CustomerTransactionsDto;
import com.wellsfargo.batch7.group3.ibs.model.KycDetailsModel;
import com.wellsfargo.batch7.group3.ibs.model.ServiceProviderAccountModel;
import com.wellsfargo.batch7.group3.ibs.model.ServiceProviderNewPasswordModel;
import com.wellsfargo.batch7.group3.ibs.model.ServiceProviderTransactionInfoModel;



public class EMnMEParser 
{
	

	
	public static KycDetailsModel parse(KycDetails source) {
	KycDetailsModel target = new KycDetailsModel();
	
//	String sysdate= DateTimeFormatter.ofPattern("uuuuMMddHHmmss").format(LocalDateTime.now());			
//	String sysdate1= DateTimeFormatter.ofPattern("dd-MM-uuuu").format(LocalDateTime.now());
//	String regId1 = target.getMobileNum() + sysdate;
//	Long regID1 =Long.parseLong(regId1);
	target.setServiceProviderName(source.getServiceProviderName());
	target.setAddress(source.getAddress());	
	target.setAdminComments(source.getAdminComments());
	target.setCity(source.getCity());
//	target.setCreatedDt(source.getCreatedDt());
	target.setCustAcctType(source.getCustAcctType());
	target.setDob(source.getDob());
	target.setEmailId(source.getEmailId());
	target.setFirstName(source.getFirstName());
	target.setLastName(source.getLastName());
	target.setGender(source.getGender());
	target.setKycApproval(source.getKycApproval());
	target.setKycIdentityProof(source.getKycIdentityProof());
	target.setKycProofDoc(source.getKycProofDoc());
	target.setKycUploadInd(source.getKycUploadInd());
	target.setMobileNum(source.getMobileNum());
	target.setPincode(source.getPincode());
	target.setRegId(source.getRegId());
	target.setTypeOfAcctHolder(source.getTypeOfAcctHolder());	
	target.setAmount(source.getAmount());
	target.setTenure(source.getTenure());
	
	target.setServProBankAccount(source.getServProBankAccount());
	target.setServProBankBranch(source.getServProBankBranch());
	target.setServProBankIFSC(source.getServProBankIFSC());
	target.setServProBankName(source.getServProBankName());
	
	target.setBranchName(source.getBranchName());
	target.setBankIfsc(source.getBankIfsc());
	return target;
}

public static KycDetails parse(KycDetailsModel source) {
	KycDetails target = new KycDetails();	
	target.setServiceProviderName(source.getServiceProviderName());
	target.setAddress(source.getAddress());	
	target.setAdminComments(source.getAdminComments());
	target.setCity(source.getCity());
	target.setCreatedDt(LocalDate.now());
	target.setCustAcctType(source.getCustAcctType());
	target.setDob(source.getDob());
	target.setEmailId(source.getEmailId());
	target.setFirstName(source.getFirstName());
	target.setLastName(source.getLastName());
	target.setGender(source.getGender());
	target.setKycApproval(source.getKycApproval());
	target.setKycIdentityProof(source.getKycIdentityProof());
	target.setKycProofDoc(source.getKycProofDoc());
	if(source.getKycProofDoc().equals(null))
	{
		target.setKycUploadInd("Not Uploaded");
	}
	else
	{
		target.setKycUploadInd("Uploaded");
	}
//	target.setKycUploadInd(source.getKycUploadInd());
	target.setMobileNum(source.getMobileNum());
	target.setPincode(source.getPincode());
//	target.setRegId(source.getRegId());
	target.setAmount(source.getAmount());
	if(source.getCustAcctType()!=null)
	{
		if(source.getCustAcctType().equals("Saving Account"))
		{
			target.setTenure((long) 0);
		}
		else
		{
			target.setTenure(source.getTenure());
		}
	}
	target.setTypeOfAcctHolder(source.getTypeOfAcctHolder());
	target.setServProBankAccount(source.getServProBankAccount());
	target.setServProBankBranch(source.getServProBankBranch());
	target.setServProBankIFSC(source.getServProBankIFSC());
	target.setServProBankName(source.getServProBankName());
	
	target.setBranchName(source.getBranchName());
	target.setBankIfsc(LoadPropertiesFile.getBranch(source.getBranchName()));
	
	return target;
}

public static CustomerAccount parse(CustomerNewPasswordModel source) 

{	
		CustomerAccount target = new CustomerAccount();
		target.setPassword(source.getPassword());
		target.setFirstLoginFlag("Completed");		
		return target;
}


public static ServiceProviderAccount parse(ServiceProviderNewPasswordModel source,String role)
{	
	if(role=="ServiceProvider")
	{
		ServiceProviderAccount target1= new ServiceProviderAccount();
		String uci=String.valueOf(source.getServiceProviderId());
		target1.setUserName(uci);
		target1.setPassword(source.getPassword());
		target1.setFirstLoginFlag("Completed");
		target1.setRole(role);
		return target1;
	}
	return null;
}

public static ServiceProviderTransactionInfo serparse(ServiceProviderTransactionInfoModel source) 
{	
	ServiceProviderTransactionInfo target = new ServiceProviderTransactionInfo();
		target.setFromCustomerAccount(source.getFromCustomerAccount());
		target.setFromCustomerName(source.getFromCustomerName());
		target.setPaymentAmt(source.getPaymentAmt());
		target.setServiceProviderId(source.getServiceProviderId());
		target.setServiceProvideraccountId(source.getServiceProvideraccountId());
		target.setCurrentBalance(source.getCurrentBalance());
		target.setTxnCmnts(source.getTxnCmnts());
		target.setTxnDateTime(source.getTxnDateTime());
		target.setTxnId(source.getTxnId());
		target.setTxnType(source.getTxnType());
		return target;
}

public static ServiceProviderTransactionInfoModel serparse(CustomerTransactionsDto transferObj,ServiceProviderAccount acctInfoTo,CustomerAccountTypesInfo cusAcctType,
		CustomerAccount custacctInfo,Double newBal,String txnType)
{	
	ServiceProviderTransactionInfoModel txnObj =new ServiceProviderTransactionInfoModel();
	txnObj.setCurrentBalance(newBal);
	txnObj.setFromCustomerAccount(transferObj.getFromAcctNum());
	txnObj.setFromCustomerName(custacctInfo.getCustName());
	txnObj.setPaymentAmt(transferObj.getTxnAmt());
	txnObj.setServiceProvideraccountId(transferObj.getToAcctNum());
	txnObj.setServiceProviderId(acctInfoTo.getServiceProviderId());
	txnObj.setTxnCmnts(transferObj.getTxnCmnts());
	txnObj.setTxnDateTime(LocalDate.now());
	txnObj.setTxnType(txnType);
	return txnObj;
	
	
}

public static ServiceProviderTransactionInfoModel serparse(ServiceProviderTransactionInfo source) 
{	
	ServiceProviderTransactionInfoModel target = new ServiceProviderTransactionInfoModel();
	target.setFromCustomerAccount(source.getFromCustomerAccount());
	target.setFromCustomerName(source.getFromCustomerName());
	target.setPaymentAmt(source.getPaymentAmt());
	target.setServiceProviderId(source.getServiceProviderId());
	target.setServiceProvideraccountId(source.getServiceProvideraccountId());
	target.setCurrentBalance(source.getCurrentBalance());
	target.setTxnCmnts(source.getTxnCmnts());
	target.setTxnDateTime(source.getTxnDateTime());
	target.setTxnId(source.getTxnId());
	target.setTxnType(source.getTxnType());
		return target;
}

public static ServiceProviderAccountModel serparse(ServiceProviderAccount source) 
{	
		ServiceProviderAccountModel target = new ServiceProviderAccountModel();
		target.setAccountId(source.getAccountId());
		target.setBankName(source.getBankName());
		target.setBranchName(source.getBranchName());
		target.setCreatedDt(LocalDate.now());
		target.setServiceProviderId(source.getServiceProviderId());
		target.setServiceProviderName(source.getServiceProviderName());
		
		return target;
}

public static ServiceProviderAccount serparse(ServiceProviderAccountModel source) 
{	
	ServiceProviderAccount target = new ServiceProviderAccount();
		target.setAccountId(source.getAccountId());
		target.setBankName(source.getBankName());
		target.setBranchName(source.getBranchName());
		target.setCreatedDt(LocalDate.now());
		target.setServiceProviderId(source.getServiceProviderId());
		target.setServiceProviderName(source.getServiceProviderName());
		
		return target;
}







}





