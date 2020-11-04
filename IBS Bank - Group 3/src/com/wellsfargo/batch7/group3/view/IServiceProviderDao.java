package com.wellsfargo.batch7.group3.view;

import com.wellsfargo.batch7.group3.model.IBSException;
import com.wellsfargo.batch7.group3.model.ServiceProviderOperations;

public interface IServiceProviderDao {
	
	ServiceProviderOperations checkpayments(ServiceProviderOperations chkpymnt) throws IBSException;

}
