package com.wellsfargo.batch7.group3.ibs.service;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.wellsfargo.batch7.group3.ibs.entities.LoginInfo;
import com.wellsfargo.batch7.group3.ibs.exception.IBSExceptionHandler;
import com.wellsfargo.batch7.group3.ibs.model.CustomerNewPasswordModel;

import com.wellsfargo.batch7.group3.ibs.repo.CustomerRepository;
import com.wellsfargo.batch7.group3.ibs.repo.LoginInfoRepo;
import com.wellsfargo.batch7.group3.ibs.repo.ServiceProviderAccountRepo;


@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private CustomerRepository customerAccountRep;
	
	@Autowired
	private ServiceProviderAccountRepo serviceProviderAccountRepo;  //
	
	@Autowired
	private LoginInfoRepo loginInfoRepo;
	
//	
//	@Autowired
//	private PasswordEncoder encoder;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		if(!loginInfoRepo.existsByUserName(username)) {
			throw new UsernameNotFoundException("Invalid user credits!");
		}
		
		LoginInfo loginInfo = loginInfoRepo.findByUserName(username);
		
		System.out.println( "bdhdxvhdfhv isue isue"+ Collections.singletonList(new SimpleGrantedAuthority(loginInfo.getRole())) );
		
		System.out.println("Logged in UserName" + loginInfo.getUserName() );
		
		return new User(loginInfo.getUserName(), loginInfo.getPassword(), 
				Collections.singletonList(new SimpleGrantedAuthority(loginInfo.getRole())));
	}
	
	
	
	/* @Autowired
	private AdbUserRepo userRepo;
	
	@Autowired
	private AdbSubscriberRepo subRepo;
	
	@Autowired
	private PasswordEncoder encoder;
	
	
	public void register(AdbSubscriberRegistrationModel user) throws AddressBookException {
		if(user!=null) {
			if(user.getPassword().equals(user.getConfirmPassword())) {
				user.setPassword(encoder.encode(user.getPassword()));
				subRepo.save(EMParser.parse(user));
			}else {
				throw new AddressBookException("Password do not match");
			}
		}
	 * 
	 * 
	 * 
	 * 
	 * */
	
	
}

