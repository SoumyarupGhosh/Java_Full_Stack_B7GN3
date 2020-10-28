package com.wellsfargo.batch7.group3.view;

import com.wellsfargo.batch7.group3.model.IBSException;
import com.wellsfargo.batch7.group3.model.RegistrationProcess;

public interface IVerifyKYC {

	RegistrationProcess validateKYC(RegistrationProcess regAcct) throws IBSException; // Approve/reject registration & send mail accordingly
	RegistrationProcess createCustomerId(RegistrationProcess custAcct) throws IBSException;
	RegistrationProcess createServiceProviderId(RegistrationProcess svcAcct) throws IBSException;
	

}
