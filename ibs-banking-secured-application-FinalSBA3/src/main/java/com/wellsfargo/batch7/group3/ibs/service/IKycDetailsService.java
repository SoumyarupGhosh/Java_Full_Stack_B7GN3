package com.wellsfargo.batch7.group3.ibs.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import com.wellsfargo.batch7.group3.ibs.exception.IBSExceptionHandler;
import com.wellsfargo.batch7.group3.ibs.model.KycDetailsModel;


public interface IKycDetailsService 
{
	
	KycDetailsModel add(KycDetailsModel kycDetailsModel) throws IBSExceptionHandler;

	KycDetailsModel get(Long regId) throws IBSExceptionHandler;	
	KycDetailsModel getbyMobileNum(String mobileNum) throws IBSExceptionHandler;
	
	List<KycDetailsModel> getAll() throws IBSExceptionHandler;
	List<KycDetailsModel> getAllPending() throws IBSExceptionHandler ;

	
	KycDetailsModel updateReject(Long regId) throws IBSExceptionHandler;
	KycDetailsModel updateAccept(Long regId) throws IBSExceptionHandler;
	
	
	KycDetailsModel updateAdminComments(String comments, Long regId) throws IBSExceptionHandler;
	
	

}
