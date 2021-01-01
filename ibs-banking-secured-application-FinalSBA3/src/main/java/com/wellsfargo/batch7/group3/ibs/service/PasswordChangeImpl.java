package com.wellsfargo.batch7.group3.ibs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.SetFactoryBean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.wellsfargo.batch7.group3.ibs.entities.LoginInfo;
import com.wellsfargo.batch7.group3.ibs.exception.IBSExceptionHandler;
import com.wellsfargo.batch7.group3.ibs.model.CustomerNewPasswordForgetModel;
import com.wellsfargo.batch7.group3.ibs.model.CustomerNewPasswordModel;
import com.wellsfargo.batch7.group3.ibs.model.SetSecurityQuestionModel;
import com.wellsfargo.batch7.group3.ibs.repo.LoginInfoRepo;

@Service
public class PasswordChangeImpl implements IpasswordChange
{

	@Autowired
	private LoginInfoRepo loginInfoRepo;
	
@Autowired
	private PasswordEncoder encoder;

@Override
	public  Boolean firstTimePasswordChange(String uci) throws IBSExceptionHandler {
		// TODO Auto-generated method stub
		LoginInfo loginInfo=loginInfoRepo.findByUserName(uci);
		if(loginInfo.getFirstLoginFlag().equals("Pending"))
				{
					System.out.println("firstTimePasswordChange-Required matched"+loginInfo.getFirstLoginFlag());
					return true ;
				}
		else
		{
			return false;
		}
		
	}


	@Override
	public void changePassword(CustomerNewPasswordModel customerNewPasswordModel,String uci) throws IBSExceptionHandler {
		// TODO Auto-generated method stub	
		
		
		LoginInfo loginInfo=loginInfoRepo.findByUserName(uci);
		
		if(loginInfoRepo.existsByUserName(uci))
		{
			if(!encoder.matches(customerNewPasswordModel.getOldPassword(), loginInfoRepo.findByUserName(uci).getPassword()))
			{
				throw new IBSExceptionHandler(" Old Password does not matches as per our records. You  can't proceed further");
			}	
		}
		
		System.out.println("a"+customerNewPasswordModel.getPassword()+ "***************"+"b"+customerNewPasswordModel.getConfirmPassword());
		if(customerNewPasswordModel.getPassword().equals(customerNewPasswordModel.getConfirmPassword()))
		{
			loginInfo.setPassword(encoder.encode(customerNewPasswordModel.getPassword()));
			loginInfo.setFirstLoginFlag("Completed");
			loginInfoRepo.save(loginInfo);
		}
		else
		{
			throw new IBSExceptionHandler("Password and Confirm Password does not match.Please try Again with correct data.");
		}
		//return null;
		
	} 
	
	@Override
	public void setSecQAnAns(SetSecurityQuestionModel source,String uci) throws IBSExceptionHandler {
		// TODO Auto-generated method stub			
		System.out.println("uci******"+uci   +"**********");
		LoginInfo loginInfo=loginInfoRepo.findByUserName(uci);

		
		
		if(!encoder.matches(source.getOldPassword(), loginInfoRepo.findByUserName(uci).getPassword()))
		{
			throw new IBSExceptionHandler(" Old Password does not matches as per our records. You  can't proceed further");
		}
		if(!(source.getSecurityQuestion().isEmpty()) && !(source.getSecurityQuestion().isEmpty()))
		{
			loginInfo.setSecurityQuestion(source.getSecurityQuestion());
			loginInfo.setSecurityAnswer(source.getSecurityAnswer());
			loginInfoRepo.save(loginInfo);
		}
		else
		{
			throw new IBSExceptionHandler("Questiona and Answer should be selected properly");
		}
		
		//return null;
		
	}
	
	@Override
	public void changePasswordForget(CustomerNewPasswordForgetModel custNewPasswrdMdl) throws IBSExceptionHandler {
		// TODO Auto-generated method stub	
		
		LoginInfo loginInfo = new LoginInfo();
		 loginInfo=loginInfoRepo.findByUserName(custNewPasswrdMdl.getUserId());
		 
		 System.out.println(loginInfo.getSecurityQuestion() + " " +custNewPasswrdMdl.getSecurityQuestion() + " " +
				 loginInfo.getSecurityAnswer() + " " + custNewPasswrdMdl.getSecurityAnswer());
		 
		 if(loginInfo.getSecurityQuestion().equals(custNewPasswrdMdl.getSecurityQuestion()) && 
				 loginInfo.getSecurityAnswer().equals(custNewPasswrdMdl.getSecurityAnswer()) )
		 {	
			if(custNewPasswrdMdl.getPassword().equals(custNewPasswrdMdl.getConfirmPassword()))
			{
			loginInfo.setPassword(encoder.encode(custNewPasswrdMdl.getPassword()));			
			loginInfoRepo.save(loginInfo);
			}
			else
			{
				throw new IBSExceptionHandler("Password and Confirm Password does not match.Please try Again with correct data.");
			}
		//return null;
		 }
		 else
		 {
			 throw new IBSExceptionHandler("ERR: Security didn't match as per our record either "
			 		+ "its wrong or its a first time login."
			 		+ " For  firstTimeLogin  use your firstTimePassword or Contact us at ibsBank@g.com. "
			 		);
		 }
	} 
	
	
	public void confirmPassword(CustomerNewPasswordModel cusNewPassModel,String uci) throws IBSExceptionHandler
	{
		if(loginInfoRepo.existsByUserName(uci))
		{
			if(!encoder.matches(cusNewPassModel.getPassword(), loginInfoRepo.findByUserName(uci).getPassword()))
			{
				throw new IBSExceptionHandler("Password does not matches as per our records. You  can't proceed further");
			}	
		}
		else {
			throw new IBSExceptionHandler("SOmething went Wrong, Please retry again.");
		}
	}


	public void confirmUser(String uci) throws IBSExceptionHandler
	{
		if(!loginInfoRepo.existsByUserName(uci))
		{
			
				throw new IBSExceptionHandler("User does not matches as per our records. You  can't proceed further");
		}		
		
	}

}
