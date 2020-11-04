package com.wellsfargo.batch7.group3.view;

import com.wellsfargo.batch7.group3.model.CustomerOperations;
import com.wellsfargo.batch7.group3.model.IBSException;

public interface IFundsTransfer {
	CustomerOperations transferFunds(CustomerOperations custAcct) throws IBSException;
}
