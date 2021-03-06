package com.wellsfargo.batch7.group3.view;

import com.wellsfargo.batch7.group3.model.CustomerOperations;
import com.wellsfargo.batch7.group3.model.FundsTransfer;
import com.wellsfargo.batch7.group3.model.IBSException;

public interface ICustomerDao {

	CustomerOperations custLogin(CustomerOperations custAcct) throws IBSException;
	
	CustomerOperations firstTimeLogin(CustomerOperations custAcct) throws IBSException;
	CustomerOperations checkBalance(CustomerOperations custAcct) throws IBSException;
	CustomerOperations addBeneficiary(CustomerOperations custAcct) throws IBSException;
	CustomerOperations updateBeneficiary(CustomerOperations custAcct) throws IBSException;
	
	CustomerOperations viewStatement(CustomerOperations custAcct) throws IBSException;
	CustomerOperations payUtilBills(CustomerOperations custAcct) throws IBSException;
	
	CustomerOperations txnProcess(CustomerOperations custAcct) throws IBSException;
	
	CustomerOperations applyLoan(CustomerOperations custAcct) throws IBSException;
	
	CustomerOperations loanDetails(CustomerOperations custAcct) throws IBSException;
	
	CustomerOperations applyCard(CustomerOperations custAcct) throws IBSException;

	CustomerOperations cardDetails(CustomerOperations custAcct) throws IBSException;
	CustomerOperations reportLostCard(CustomerOperations custAcct) throws IBSException;
	CustomerOperations reqCardStatement(CustomerOperations custAcct) throws IBSException;

	FundsTransfer transferFunds(FundsTransfer fndsTrf);

	
	
}
