package com.wellsfargo.batch7.group3.ibs.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.wellsfargo.batch7.group3.ibs.entities.CustomerAccountTypesInfo;
import com.wellsfargo.batch7.group3.ibs.exception.IBSExceptionHandler;
import com.wellsfargo.batch7.group3.ibs.model.CustomerAccountDto;
import com.wellsfargo.batch7.group3.ibs.model.CustomerAccountTypesInfoDto;
import com.wellsfargo.batch7.group3.ibs.model.CustomerBeneficiaryDto;
import com.wellsfargo.batch7.group3.ibs.model.CustomerTransactionsDto;
import com.wellsfargo.batch7.group3.ibs.model.KycDetailsModel;
import com.wellsfargo.batch7.group3.ibs.util.EMnMEParser;



public interface ICustomerService {

	//LoginDataDto userLogin(LoginDataDto custAcct) throws IBSException;
	
	List<CustomerAccountTypesInfoDto> getCustomerData(String uci);

	CustomerBeneficiaryDto addBeneficiary(CustomerBeneficiaryDto custBnfcryAcct, String uci) throws IBSExceptionHandler;
	void deleteBeneficiary(Long bnfcryId, String uci) throws IBSExceptionHandler;
	
	CustomerAccountTypesInfoDto addNewCustAccount(CustomerAccountTypesInfoDto customerAccountTypesInfoDto, String uci) throws IBSExceptionHandler;
	
	//CustomerAccountDto updateCustBal(CustomerTransactionsDto txnObj) throws IBSExceptionHandler;
	CustomerTransactionsDto transferFunds(CustomerTransactionsDto transferObj) throws IBSExceptionHandler;
	CustomerTransactionsDto BillPaymentDebit(CustomerTransactionsDto transferObj) throws IBSExceptionHandler;
	
//	List<CustomerTransactionsDto> getAccountStatement(String uci);
	
	
	List<CustomerBeneficiaryDto> getAllBnfcryPending() throws IBSExceptionHandler ;	
	CustomerBeneficiaryDto updateRejectBnfcrcy(Long bnfcryId) throws IBSExceptionHandler;
	CustomerBeneficiaryDto updateAcceptBnfcry(Long bnfcryId) throws IBSExceptionHandler;	
	List<CustomerBeneficiaryDto> getListOfBnfcryAccepted(String uci,Long fromCustName) throws IBSExceptionHandler;
	List<CustomerBeneficiaryDto> getListOfBnfcryAccepted(String uci) throws IBSExceptionHandler;
	List<CustomerBeneficiaryDto> getListOfBnfcry( String uci) throws IBSExceptionHandler;
	


	
}
