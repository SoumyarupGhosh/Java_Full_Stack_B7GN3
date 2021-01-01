package com.wellsfargo.batch7.group3.ibs.service;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import com.wellsfargo.batch7.group3.ibs.exception.IBSExceptionHandler;
import com.wellsfargo.batch7.group3.ibs.model.AccountStatementDto;
import com.wellsfargo.batch7.group3.ibs.model.CustomerTransactionsDto;
import com.wellsfargo.batch7.group3.ibs.model.KycDetailsModel;
import com.wellsfargo.batch7.group3.ibs.model.ServiceProviderAccountModel;
import com.wellsfargo.batch7.group3.ibs.model.ServiceProviderNewPasswordModel;
import com.wellsfargo.batch7.group3.ibs.model.ServiceProviderTransactionInfoModel;


public interface ISerProviderGetPaymentServices 
{
	
	
	//List<ServiceProviderTransactionInfoModel> getPayment(ServiceProviderTransactionInfoModel  servTxsModel) throws IBSExceptionHandler;	
	
	//List<ServiceProviderTransactionInfoModel> getPaymentOn(ServiceProviderTransactionInfoModel  servTxsModel,LocalDate from,LocalDate to) throws IBSExceptionHandler;	
	
	List<ServiceProviderTransactionInfoModel> getAllPayment() throws IBSExceptionHandler;	
	List<ServiceProviderAccountModel> getAllServiceProviderList() throws IBSExceptionHandler;
	List<ServiceProviderTransactionInfoModel> getOnlyCustPaidAccountList(String uci) throws IBSExceptionHandler;
	List<ServiceProviderTransactionInfoModel> getCustPaidFilteredStatement(AccountStatementDto filterStmtData) throws IBSExceptionHandler;
	 ServiceProviderTransactionInfoModel ServBillPymntCrdt( CustomerTransactionsDto transferObj) throws IBSExceptionHandler;
	 
	 List<ServiceProviderTransactionInfoModel> getserviceProviderFilteredStatement(AccountStatementDto filterStmtData)  throws IBSExceptionHandler;

}