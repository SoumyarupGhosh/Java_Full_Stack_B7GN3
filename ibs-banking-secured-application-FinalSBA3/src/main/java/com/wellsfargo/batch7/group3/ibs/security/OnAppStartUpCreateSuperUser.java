package com.wellsfargo.batch7.group3.ibs.security;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.wellsfargo.batch7.group3.ibs.entities.LoginInfo;
import com.wellsfargo.batch7.group3.ibs.repo.LoginInfoRepo;
import com.wellsfargo.batch7.group3.ibs.util.GeneraterRandomNumber;


@Component
public class OnAppStartUpCreateSuperUser {

	@Autowired
	private LoginInfoRepo empRepo;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@EventListener
	public void createSuperUserOnStartUp(ApplicationStartedEvent event) {
		
		//String sysdate= DateTimeFormatter.ofPattern("uuuuMMddHHmmss").format(LocalDateTime.now());	
		//String empId = "9999999999" + sysdate;//		
		//Long regID1 =Long.parseLong(empId); ////Mobile Number+sysdate of IBSexecutive which will be become his userid as unique on		
		//String empid="EMP" + GeneraterRandomNumber.gen();
		String empId="SURESH";
		
//		System.out.println("my employee idd is"+ empId);
//		System.out.println("my password is"+ GeneraterRandomNumber.generateRandomChars(10));
		
		if(!empRepo.existsByUserName(empId)) { 
			
		//	empRepo.save(new LoginInfo(null,empId, encoder.encode(GeneraterRandomNumber.generateRandomChars(10)),"NO","EMPLOYEE"));
			empRepo.save(new LoginInfo(null,empId, encoder.encode(empId),"NO","Employee",null,null));
		}
	}
}
