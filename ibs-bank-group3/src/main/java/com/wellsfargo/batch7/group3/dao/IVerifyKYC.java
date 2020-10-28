package com.wellsfargo.batch7.group3.dao;

import com.wellsfargo.batch7.group3.dto.RegistrationProcess;
import com.wellsfargo.batch7.group3.exception.IBSException;

public interface IVerifyKYC {

	RegistrationProcess validateKYC(RegistrationProcess regAcct) throws IBSException; // Approve/reject registration & send mail accordingly
	RegistrationProcess createCustomerId(RegistrationProcess custAcct) throws IBSException;
	RegistrationProcess createServiceProviderId(RegistrationProcess svcAcct) throws IBSException;
	

}
