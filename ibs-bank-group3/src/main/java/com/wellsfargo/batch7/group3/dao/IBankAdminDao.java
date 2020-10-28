package com.wellsfargo.batch7.group3.dao;

import com.wellsfargo.batch7.group3.dto.CustomerOperations;
import com.wellsfargo.batch7.group3.exception.IBSException;

public interface IBankAdminDao {
	
	CustomerOperations chkCustStatement(CustomerOperations custAcct) throws IBSException;
	CustomerOperations fundDepositEntry(CustomerOperations custAcct) throws IBSException;
	
	CustomerOperations loanApprovals(CustomerOperations custAcct) throws IBSException;
	CustomerOperations cardApprovals(CustomerOperations custAcct) throws IBSException;
	
	CustomerOperations cardActivation(CustomerOperations custAcct) throws IBSException;
	CustomerOperations viewCardStatement(CustomerOperations custAcct) throws IBSException;
	
	
	
}
