package com.wellsfargo.batch7.group3.ibs.service;

import java.security.cert.CollectionCertStoreParameters;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wellsfargo.batch7.group3.ibs.entities.CustomerAccount;
import com.wellsfargo.batch7.group3.ibs.entities.CustomerAccountTypesInfo;
import com.wellsfargo.batch7.group3.ibs.entities.CustomerBeneficiary;
import com.wellsfargo.batch7.group3.ibs.entities.CustomerTransactions;
import com.wellsfargo.batch7.group3.ibs.entities.KycDetails;
import com.wellsfargo.batch7.group3.ibs.exception.IBSExceptionHandler;
import com.wellsfargo.batch7.group3.ibs.model.AccountStatementDto;
import com.wellsfargo.batch7.group3.ibs.model.CustomerAccountDto;
import com.wellsfargo.batch7.group3.ibs.model.CustomerAccountTypesInfoDto;
import com.wellsfargo.batch7.group3.ibs.model.CustomerBeneficiaryDto;
import com.wellsfargo.batch7.group3.ibs.model.CustomerNewPasswordModel;
import com.wellsfargo.batch7.group3.ibs.model.CustomerTransactionsDto;
import com.wellsfargo.batch7.group3.ibs.repo.CustomerAccountTypesInfoRepo;
import com.wellsfargo.batch7.group3.ibs.repo.CustomerBeneficiaryRepository;
import com.wellsfargo.batch7.group3.ibs.repo.CustomerRepository;
import com.wellsfargo.batch7.group3.ibs.repo.CustomerTransactionsRepository;
import com.wellsfargo.batch7.group3.ibs.util.Converters;
import com.wellsfargo.batch7.group3.ibs.util.EMnMEParser;
import com.wellsfargo.batch7.group3.ibs.util.EMnMEParserCust;
import com.wellsfargo.batch7.group3.ibs.util.LoadPropertiesFile;




@Service
public class CustomerImpl implements ICustomerService {

	@Autowired
	private CustomerRepository customerRepo;
	
	@Autowired
	private CustomerAccountTypesInfoRepo customerAccountTypesInfoRepo;
	
	@Autowired
	private CustomerBeneficiaryRepository custBnfRepo;
	
	@Autowired
	private CustomerTransactionsRepository custTxnRepo;
	
	@Transactional
	@Override
	public CustomerBeneficiaryDto addBeneficiary(CustomerBeneficiaryDto custBnfcryAcct, String uci) throws IBSExceptionHandler {
		//List<CustomerAccountTypesInfo> custAcct = customerAccountTypesInfoRepo.findByUci(uci);
//	   List<CustomerAccountTypesInfo> custAcct = customerAccountTypesInfoRepo.findByUci(uci);					
//		Long custAcctNum = null;
//		for (int i = 0;i<custAcct.size();i++) {
//		if(custAcct.get(i).getCustAcctType().equalsIgnoreCase("Saving Account")) {			
//				custAcctNum = custAcct.get(i).getCustomerAcctNum();
//		}			
//		}		
			
		if(custBnfRepo.countByCustAcctNumAndBnfcryAcctNum(custBnfcryAcct.getCustAcctNum(), custBnfcryAcct.getBnfcryAcctNum()) > 0)
		{
			throw new IBSExceptionHandler("WARN: Beneficary already added");
		}
		else if(customerAccountTypesInfoRepo.findByCustomerAcctNum(custBnfcryAcct.getBnfcryAcctNum())!=null)
		{
			if (customerAccountTypesInfoRepo.findByCustomerAcctNum(custBnfcryAcct.getBnfcryAcctNum()).getCustAcctType().equals("Fixed Deposit"))
			{
				throw new IBSExceptionHandler("WARN: Fixed deposit account cannot be added as beneficiary, "
					+ "Since its a one time deposit at a time of opening account ");
			}
		}
		else
		{
			custBnfcryAcct.setUci(uci);
		}
		return EMnMEParserCust.bnfParse(custBnfRepo.save(EMnMEParserCust.bnfParse(custBnfcryAcct,custBnfcryAcct.getCustAcctNum())));
		
	}
	
	@Transactional
	@Override
	public void deleteBeneficiary(Long bnfcryId, String uci) throws IBSExceptionHandler
	{
		
		if(custBnfRepo.existsByBnfcryId(bnfcryId))
		{
			custBnfRepo.deleteByBnfcryId(bnfcryId);
		}		
	}
	
	
	
	@Transactional
	@Override
	public CustomerAccountTypesInfoDto addNewCustAccount(CustomerAccountTypesInfoDto customerAccountTypesInfoDto, String uci) throws IBSExceptionHandler {
		//List<CustomerAccountTypesInfo> custAcct = customerAccountTypesInfoRepo.findByUci(uci);
		if(customerAccountTypesInfoDto.getCustAcctType()==null)
		{
			throw new IBSExceptionHandler("ERR:Customer hasn't selected any account type");
		}
		if(customerAccountTypesInfoDto.getCustAcctType().equals("Fixed Deposit") || customerAccountTypesInfoDto.getCustAcctType().equals("Recurring Deposit"))
		{
			if(customerAccountTypesInfoDto.getAvailableBalance()==null || customerAccountTypesInfoDto.getBranchName()==null || customerAccountTypesInfoDto.getTenure()==null)
			{
				throw new IBSExceptionHandler("ERR : Fields Amount, BranchName or Tenure cannot be empty for Customer." );
			}
			else if(customerAccountTypesInfoDto.getCustAcctType().equals("Fixed Deposit") && customerAccountTypesInfoDto.getAvailableBalance() < LoadPropertiesFile.getAmount("MinFDAmount"))
			{
				throw new IBSExceptionHandler("ERR : Minimum FD Amount is " +  LoadPropertiesFile.getAmount("MinFDAmount") );
			}
			else if(customerAccountTypesInfoDto.getCustAcctType().equals("Recurring Deposit") && customerAccountTypesInfoDto.getAvailableBalance() < LoadPropertiesFile.getAmount("MinRDAmount"))
			{
				throw new IBSExceptionHandler("ERR : Minimum RD Amount is " +   LoadPropertiesFile.getAmount("MinRDAmount") );
			}
			else
			{
				
			}
		}
		
		if(customerAccountTypesInfoDto.getCustAcctType().equals("Saving Account")) 
		{				
			if(customerAccountTypesInfoDto.getAvailableBalance()==null || customerAccountTypesInfoDto.getBranchName()==null )
			{
				throw new IBSExceptionHandler("ERR : Fields Amount or BranchName  cannot be empty for Customer." );
			}
			else if(customerAccountTypesInfoDto.getAvailableBalance() < LoadPropertiesFile.getAmount("MinSAmount") )
			{
				throw new IBSExceptionHandler("ERR : Minimum Saving Acount Amount is " +   LoadPropertiesFile.getAmount("MinSAmount") );
			}
			else
			{
				
			}
		}
		
		CustomerAccount custAcct = customerRepo.findByUci(uci);	
		List<CustomerAccountTypesInfo> custAcctType = customerAccountTypesInfoRepo.findByUci(uci);
		List<CustomerAccountTypesInfo> custAcctTypeSaving = custAcctType.stream().filter(f -> f.getCustAcctType().equals("Saving Account")).
				collect(Collectors.toList());
		List<CustomerAccountTypesInfo> custAcctTypeFixed = custAcctType.stream().filter(f -> f.getCustAcctType().equals("Fixed Deposit")).
				collect(Collectors.toList());
		List<CustomerAccountTypesInfo> custAcctTypeRecurring = custAcctType.stream().filter(f -> f.getCustAcctType().equals("Recurring Deposit")).
				collect(Collectors.toList());
		
		
		//		Long custAcctNum = null;
//		for (int i = 0;i<custAcct.size();i++) {
//		if(custAcct.get(i).getCustAcctType().equalsIgnoreCase("Saving Account")) {			
//				custAcctNum = custAcct.get(i).getCustomerAcctNum();)
//		}			
//		}		
		if(customerRepo.existsByUci(uci))	
		{
			if(custAcct.getCustAcctStatus().equalsIgnoreCase("ACTIVE"))	
			{
					if((customerAccountTypesInfoDto.getCustAcctType().equals("Saving Account")) && 
							(custAcctTypeSaving.size()<LoadPropertiesFile.getValue("NumOfSavingAcct")))
					{
						System.out.println("savingAccountcount" +  " "+ custAcctTypeSaving.size());
					return EMnMEParserCust.custDataParse(customerAccountTypesInfoRepo.
							save(EMnMEParserCust.custDataParse(customerAccountTypesInfoDto,uci,customerRepo.findByUci(uci).getRegId())));
					}
					else if((customerAccountTypesInfoDto.getCustAcctType().equals("Fixed Deposit")) && 
							(custAcctTypeFixed.size()<LoadPropertiesFile.getValue("NumOfFixedAcct")))
					{
						System.out.println("custAcctTypeFixed" +  " "+ custAcctTypeFixed.size());
					return EMnMEParserCust.custDataParse(customerAccountTypesInfoRepo.
							save(EMnMEParserCust.custDataParse(customerAccountTypesInfoDto,uci,customerRepo.findByUci(uci).getRegId())));
					}
					else if((customerAccountTypesInfoDto.getCustAcctType().equals("Recurring Deposit")) && 
							(custAcctTypeRecurring.size()<LoadPropertiesFile.getValue("NumOfRecurringAcct")))
					{
						System.out.println("custAcctTypeRecurring" +  " "+ custAcctTypeRecurring.size());
						
					return EMnMEParserCust.custDataParse(customerAccountTypesInfoRepo.
							save(EMnMEParserCust.custDataParse(customerAccountTypesInfoDto,uci,customerRepo.findByUci(uci).getRegId())));
					}
					else
					{
						throw new IBSExceptionHandler("ERR: It's exceed number of account limit or Account already exist at the branch");
					}
			}
			else
			{
				throw new IBSExceptionHandler("Customer Cannot be added , since customer is Inactive");
			}
		}
		
		
		return customerAccountTypesInfoDto;
	}
	
	
	@Override
	public List<CustomerBeneficiaryDto> getAllBnfcryPending() throws IBSExceptionHandler {
		// TODO Auto-generated method stub
		if( custBnfRepo.existsByBnfcryStatus("Pending"))
		{
		return custBnfRepo.findAllByBnfcryStatus("Pending").stream().map(e -> EMnMEParserCust.bnfParse(e)).collect(Collectors.toList());
		}
		return null;
	}

	@Override
	public List<CustomerAccountTypesInfoDto> getCustomerData(String uci) {
		List<CustomerAccountTypesInfo> c1 = customerAccountTypesInfoRepo.findAllByUci(uci);		
		List<CustomerAccountTypesInfoDto> custObj1 = c1.stream().map(e ->EMnMEParserCust.custDataParse(e)).collect(Collectors.toList());		
		return custObj1;
	}
	
	
	
	@Override
	public List<CustomerBeneficiaryDto> getListOfBnfcry(@Valid String uci) throws IBSExceptionHandler {
		//List<CustomerAccount> custAcct = customerRepo.findByUserName(uci);
		List<CustomerAccountTypesInfo> custAcct = customerAccountTypesInfoRepo.findByUci(uci);
		List<CustomerAccountTypesInfo> custAcct1  = custAcct.stream().filter(f -> f.getCustAcctType().equals("Saving Account")).
				collect(Collectors.toList());
//		long custAcctNum = 0;
//		for (int i = 0;i<custAcct.size();i++) {
//			if(custAcct.get(i).getCustAcctType().equalsIgnoreCase("Saving Account")) {
//				custAcctNum = custAcct.get(i).getCustomerAcctNum();
//		}
//		}
		
		List<Long> custAcctNum = new ArrayList<Long>();
		for (int i = 0;i<custAcct1.size();i++) {
			custAcctNum.add(custAcct1.get(i).getCustomerAcctNum());
		}
		
		List<CustomerBeneficiary> b1 = custBnfRepo.findAllByCustAcctNumIn(custAcctNum);		
		return b1.stream().map(e -> EMnMEParserCust.bnfcryParse(e)).collect(Collectors.toList());
	}
	

	@Override
	public List<CustomerBeneficiaryDto> getListOfBnfcryAccepted(@Valid String uci,Long fromAcctNum )  throws IBSExceptionHandler{
	
		List<CustomerBeneficiary> b1 = custBnfRepo.findByCustAcctNum(fromAcctNum);
		List<CustomerBeneficiary> b2 = b1.stream().filter(f -> f.getBnfcryStatus().equals("Accepted")).collect(Collectors.toList());
		return b2.stream().map(e -> EMnMEParserCust.bnfcryParse(e)).collect(Collectors.toList());

	} // can be deleted not used
	
	@Override
	public List<CustomerBeneficiaryDto> getListOfBnfcryAccepted(@Valid String uci)  throws IBSExceptionHandler{
		//List<CustomerAccount> custAcct = customerRepo.findByUserName(uci);
				List<CustomerAccountTypesInfo> custAcct = customerAccountTypesInfoRepo.findByUci(uci);
				List<CustomerAccountTypesInfo> custAcct1  = custAcct.stream().filter(f -> f.getCustAcctType().equals("Saving Account")).
						collect(Collectors.toList());
			
				List<Long> custAcctNum = new ArrayList<Long>();
				for (int i = 0;i<custAcct1.size();i++) {
					custAcctNum.add(custAcct1.get(i).getCustomerAcctNum());
				}
				
				List<CustomerBeneficiary> b1 = custBnfRepo.findAllByCustAcctNumIn(custAcctNum);		
				
		List<CustomerBeneficiary> b2 = b1.stream().filter(f -> f.getBnfcryStatus().equals("Accepted")).collect(Collectors.toList());
		return b2.stream().map(e -> EMnMEParserCust.bnfcryParse(e)).collect(Collectors.toList());

	}


// **************End of Beneficary************************
	
	public List<CustomerAccountTypesInfoDto> getSavingsAcctInfo(List<CustomerAccountTypesInfoDto> custAcct1) {
		List<CustomerAccountTypesInfoDto> custAcct  = custAcct1.stream().filter(f -> f.getCustAcctType().equals("Saving Account")).
				collect(Collectors.toList());
		
		return custAcct;
	}
	
	public List<CustomerAccountTypesInfoDto> getFixedDepositInfo(List<CustomerAccountTypesInfoDto> custAcct1) {
		List<CustomerAccountTypesInfoDto> custAcct  = custAcct1.stream().filter(f -> f.getCustAcctType().equals("Fixed Deposit")).
				collect(Collectors.toList());		
		return custAcct;
	}
	
	public List<CustomerAccountTypesInfoDto> getRecurringDepositInfo(List<CustomerAccountTypesInfoDto> custAcct2) {
		List<CustomerAccountTypesInfoDto> custAcct  = custAcct2.stream().filter(f -> f.getCustAcctType().equals("Recurring Deposit")).
				collect(Collectors.toList());
		return custAcct;
	}
	


	@Override
	public CustomerTransactionsDto transferFunds(@Valid CustomerTransactionsDto transferObj) throws IBSExceptionHandler{
		
		CustomerAccountTypesInfo acctInfoFrom =customerAccountTypesInfoRepo.findByCustomerAcctNum(transferObj.getFromAcctNum());
		CustomerAccountTypesInfo acctInfoTo =customerAccountTypesInfoRepo.findByCustomerAcctNum(transferObj.getToAcctNum());
		Long bnfcryDto = custBnfRepo.countByCustAcctNumAndBnfcryAcctNum(transferObj.getFromAcctNum(),transferObj.getToAcctNum());
		CustomerTransactionsDto txnObj;
		Double existingBal = acctInfoFrom.getAvailableBalance();
		
		if (existingBal==null ) {
			throw new IBSExceptionHandler("You have Zero Balance in your account, Please credit some money to perform transaction !! ");
		}
		
		if(bnfcryDto < 1 )
		{
			throw new IBSExceptionHandler("ERR: Selected  Beneficiary account linked with CustomerAcctNum doesn't exist, Please select correct beneficiary referring"
					+ "DropDown Details.");
		}
		
		if (transferObj.getTxnAmt() > existingBal ) {
			throw new IBSExceptionHandler("Transaction Amount cannot be greater that your current account balance !! ");
		}	
		
		double prevBal = acctInfoFrom.getAvailableBalance();		
		double newBal = prevBal - transferObj.getTxnAmt();
		acctInfoFrom.setAvailableBalance(newBal);
		transferObj.setEffAcctNum(transferObj.getFromAcctNum());
		transferObj.setCurrentBalanceEffAcctNum(newBal);
		 txnObj = EMnMEParserCust.txnParse(custTxnRepo.save(EMnMEParserCust.txnParse(transferObj,acctInfoFrom.getUci(),"DEBIT")));
		EMnMEParserCust.updateParse(customerAccountTypesInfoRepo.save(acctInfoFrom));
		//	CustomerAccountTypesInfoDto customerAccountTypesInfoDto= updateCustBalDebit(txnObj);
		
		
		if(customerAccountTypesInfoRepo.existsByCustomerAcctNum(txnObj.getToAcctNum())) // Account can exist in same Bank or different bank ,in case of same bank credit update will also happen
		{
//			CustomerAccountTypesInfo acctInfoTo =customerAccountTypesInfoRepo.findByCustomerAcctNum(transferObj.getToAcctNum());
//			CustomerTransactionsDto txnObjTo = EMnMEParserCust.txnParse(custTxnRepo.save(EMnMEParserCust.txnParse(transferObj,acctInfoTo.getUci(),"CREDIT-TO")));
//			updateCustBalCredit(txnObjTo);
					
			double prevBal1 = acctInfoTo.getAvailableBalance();		
			double newBal1 = prevBal1 + transferObj.getTxnAmt();
			acctInfoTo.setAvailableBalance(newBal1);
			transferObj.setEffAcctNum(transferObj.getToAcctNum());
			transferObj.setCurrentBalanceEffAcctNum(newBal1);
			 txnObj = EMnMEParserCust.txnParse(custTxnRepo.save(EMnMEParserCust.txnParse(transferObj,acctInfoTo.getUci(),"CREDIT")));
			EMnMEParserCust.updateParse(customerAccountTypesInfoRepo.save(acctInfoTo));						
		}
	return txnObj;
}			
	
	//*******************End of Fund Transfer****************
	
	@Override
	public CustomerTransactionsDto BillPaymentDebit(@Valid CustomerTransactionsDto transferObj) throws IBSExceptionHandler{
		
		CustomerAccountTypesInfo acctInfoFrom =customerAccountTypesInfoRepo.findByCustomerAcctNum(transferObj.getFromAcctNum());
		//CustomerAccountTypesInfo acctInfoTo =customerAccountTypesInfoRepo.findByCustomerAcctNum(transferObj.getToAcctNum());
		
		CustomerTransactionsDto txnObj;
		Double existingBal = acctInfoFrom.getAvailableBalance();

		if (existingBal==null ) {
			throw new IBSExceptionHandler("You have Zero Balance in your account, Please credit some money to perform Bill Payment !! ");
		}
		
		
		if (transferObj.getTxnAmt() > existingBal ) {
			throw new IBSExceptionHandler("Transaction Amount cannot be greater that your current account balance !! ");
		}					
		double prevBal = acctInfoFrom.getAvailableBalance();		
		double newBal = prevBal - transferObj.getTxnAmt();
		acctInfoFrom.setAvailableBalance(newBal);
		transferObj.setEffAcctNum(transferObj.getFromAcctNum());
		transferObj.setCurrentBalanceEffAcctNum(newBal);
		 txnObj = EMnMEParserCust.txnParse(custTxnRepo.save(EMnMEParserCust.txnParse(transferObj,acctInfoFrom.getUci(),"DEBIT")));
		EMnMEParserCust.updateParse(customerAccountTypesInfoRepo.save(acctInfoFrom));
		return txnObj;
	}
	
//	@Override
	public List<CustomerAccountTypesInfoDto> getSavRecAccountList(String uci) {
	
		List<CustomerAccountTypesInfo> allRecSavList = new ArrayList<CustomerAccountTypesInfo>();
		List<CustomerAccountTypesInfo> recAcctList=(customerAccountTypesInfoRepo.findByUci(uci)).stream().
				filter(f -> f.getCustAcctType().equals("Recurring Deposit")).collect(Collectors.toList());
		List<CustomerAccountTypesInfo> savAcctList=(customerAccountTypesInfoRepo.findByUci(uci)).stream().
				filter(f -> f.getCustAcctType().equals("Saving Account")).collect(Collectors.toList());
		allRecSavList.addAll(recAcctList);
		allRecSavList.addAll(savAcctList);
		
		return allRecSavList.stream().map(e -> EMnMEParserCust.custDataParse(e)).collect(Collectors.toList());
	}


	public List<CustomerTransactionsDto> getFilteredStatement(AccountStatementDto filterStmtData) throws ParseException {
		//System.out.println("in filter stmt");
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd",Locale.getDefault());
		LocalDate startDate = Converters.stringToLocalDate(filterStmtData.getStartDate());
		LocalDate endDate = Converters.stringToLocalDate(filterStmtData.getEndDate());
		Date txnDate = null;
		System.out.println(startDate+"|"+endDate+"|"+"acctName:"+filterStmtData.getCustAcctNum());
		List<CustomerTransactions> txnRepoList=custTxnRepo.findByEffAcctNumAndTxnDateBetween(filterStmtData.getCustAcctNum(), startDate,endDate);
		List<CustomerTransactionsDto> txnObj = txnRepoList.
		stream().map(e -> EMnMEParserCust.txnParse(e)).collect(Collectors.toList());
		return txnObj;			
		
	}
	
	public List<CustomerAccountTypesInfoDto> getFilteredFundStatement(AccountStatementDto filterStmtData) throws  IBSExceptionHandler {
		//System.out.println("in filter stmt");
		
//		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd",Locale.getDefault());
//		LocalDate startDate = Converters.stringToLocalDate(filterStmtData.getStartDate());
//		LocalDate endDate = Converters.stringToLocalDate(filterStmtData.getEndDate());
//		Date txnDate = null;
		System.out.println("acctName:"+filterStmtData.getCustAcctNum());
		if(filterStmtData.getCustAcctNum()!=null)
		{
		List<CustomerAccountTypesInfo> AcctTypeRepo=customerAccountTypesInfoRepo.findAllByCustomerAcctNum(filterStmtData.getCustAcctNum());
		List<CustomerAccountTypesInfoDto> txnObj = AcctTypeRepo.stream().map(e -> EMnMEParserCust.updateParse(e)).collect(Collectors.toList());
		return txnObj;}
		else
		{
			throw new IBSExceptionHandler("Statement Account ID is not found.Please re-selected");
		}
		
	}
	

	@Override
	public CustomerBeneficiaryDto updateRejectBnfcrcy(Long bnfcryId) throws IBSExceptionHandler {
		// TODO Auto-generated method stub
		if(bnfcryId!= null)
		{
			 if(custBnfRepo.existsByBnfcryId(bnfcryId))
			{
				 CustomerBeneficiary customerBeneficiary=custBnfRepo.findByBnfcryId(bnfcryId);
				 customerBeneficiary.setBnfcryStatus("Rejected");
				 custBnfRepo.save(customerBeneficiary);				
			}
			else
			{
				throw new IBSExceptionHandler("Beneficary Id does not exists." );
			}
		}
		return null;	
	}

	@Override
	public CustomerBeneficiaryDto updateAcceptBnfcry(Long bnfcryId) throws IBSExceptionHandler {
		// TODO Auto-generated method stub
		if(bnfcryId!= null)
		{
			 if(custBnfRepo.existsByBnfcryId(bnfcryId))
			{
				 CustomerBeneficiary customerBeneficiary=custBnfRepo.findByBnfcryId(bnfcryId);
				 customerBeneficiary.setBnfcryStatus("Accepted");
				 custBnfRepo.save(customerBeneficiary);				
			}
			else
			{
				throw new IBSExceptionHandler("Beneficary Id does not exists." );
			}
		}
		return null;
	}


	

	

}
