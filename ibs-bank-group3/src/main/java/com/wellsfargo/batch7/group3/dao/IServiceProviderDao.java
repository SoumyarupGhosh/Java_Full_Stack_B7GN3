package com.wellsfargo.batch7.group3.dao;

import com.wellsfargo.batch7.group3.dto.ServiceProviderOperations;
import com.wellsfargo.batch7.group3.exception.IBSException;

public interface IServiceProviderDao {
	
	ServiceProviderOperations checkpayments(ServiceProviderOperations chkpymnt) throws IBSException;

}
