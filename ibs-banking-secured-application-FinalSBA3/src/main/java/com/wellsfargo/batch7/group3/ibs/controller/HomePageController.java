package com.wellsfargo.batch7.group3.ibs.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.wellsfargo.batch7.group3.ibs.entities.LoginInfo;
import com.wellsfargo.batch7.group3.ibs.exception.IBSExceptionHandler;
import com.wellsfargo.batch7.group3.ibs.model.CustomerAccountTypesInfoDto;
import com.wellsfargo.batch7.group3.ibs.model.CustomerNewPasswordForgetModel;
import com.wellsfargo.batch7.group3.ibs.model.CustomerNewPasswordModel;
import com.wellsfargo.batch7.group3.ibs.model.KycDetailsModel;
import com.wellsfargo.batch7.group3.ibs.model.SetSecurityQuestionModel;
import com.wellsfargo.batch7.group3.ibs.repo.CustomerRepository;
import com.wellsfargo.batch7.group3.ibs.repo.LoginInfoRepo;
import com.wellsfargo.batch7.group3.ibs.service.PasswordChangeImpl;
import com.wellsfargo.batch7.group3.ibs.service.UserDetailsServiceImpl;

@Controller
@RequestMapping("")
public class HomePageController  {

	
	@Autowired
	private PasswordChangeImpl passwordChangeImpl;
	
	@Autowired
	private CustomerRepository CustomerRepo;
	
	@Autowired
	private LoginInfoRepo lgnIfRp;
	
	
	@GetMapping({ "", "/", "/home"})
	public ModelAndView homeAction() throws IBSExceptionHandler {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
//		mv.addObject("groups",agService.getAll());
//		mv.addObject("group",new AddressGroupModel());
		return mv;
	}
	
	@RequestMapping("/header")
	public ModelAndView headerAction() throws IBSExceptionHandler {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("homeMenu");

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();		

		if (!(auth instanceof AnonymousAuthenticationToken) && auth.isAuthenticated()) {	
			
			mv.addObject("role",auth.getAuthorities().stream().findFirst().get().getAuthority());
			mv.addObject("uci",auth.getName());
		//	mv.addObject("Name",CustomerRepo.findByName(Long.parseLong(auth.getName())));
			
			System.out.println("/headerv  user role is "+ auth.getAuthorities().stream().findFirst().get().getAuthority() + "Name "+ auth.getName());
			Boolean ChangePassword=passwordChangeImpl.firstTimePasswordChange(auth.getName());
			if(ChangePassword)
			{
				mv.addObject("PassChange","requires");
				
			}
			else
			{
				mv.addObject("PassChange","notRequires");
			}
			
			
			
		}
		
		
		

		return mv;
	}

	@GetMapping({"/loginPage"})
	public String loginAction() throws IBSExceptionHandler {
		String view = "loginPage";	

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		if (!(auth instanceof AnonymousAuthenticationToken) && auth.isAuthenticated())
		{				
			System.out.println("readirect to header from login page.getName()"+ auth.getName());
			return "redirect:/header";								
		}
		return view;
	}
	
	
	

	@PostMapping("/changePassword")
	public ModelAndView verifyFirstTimeLoginAction(@ModelAttribute("chgPassword") @Valid CustomerNewPasswordModel chgPassword,
			BindingResult result,@RequestParam("uci") @Valid String uci) throws IBSExceptionHandler {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		ModelAndView mv = new ModelAndView();
		passwordChangeImpl.confirmUser(uci);
		mv.setViewName("changePassword");	
		if(result.hasErrors()) {
			System.out.println("Bindingg EWrror");
			mv.addObject("chgPassword",chgPassword);	
		}else {
			
			Object Principal=SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			if(Principal instanceof LoginInfo)
			{
				System.out.println("It is an instance");
				String userName =((LoginInfo)Principal).getUserName();				
			}
			else
			{
				System.out.println("It is not  an instance");
				String userName =Principal.toString();
			}
			
			System.out.println("verifyFirstTimeLoginAction.getName()"+ auth.getName());	
			
			passwordChangeImpl.changePassword(chgPassword,auth.getName());
//			boolean ChangePassword= passwordChangeImpl.firstTimePasswordChange(auth.getName());
//			if(ChangePassword)
//			{
//				mv.addObject("PassChange","requires");
//			}
//			else
//			{
//				mv.addObject("PassChange","notRequires");
//			}
			mv.addObject("chgPassword",new CustomerNewPasswordModel());	
			mv.addObject("uci", uci);
			
			mv.addObject("message", "User changed password successfully!!!");
		}		
					
		return mv;
	}
	
	@PostMapping("/setSecurityQuestion")
	public ModelAndView SetSecurityQuestionAction(@ModelAttribute("setSecurityQuestion") @Valid SetSecurityQuestionModel setSecurityQuestion,
			BindingResult result,@RequestParam("uci") @Valid String uci) throws IBSExceptionHandler {
	//	passwordChangeImpl.confirmUser(uci);
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("setSecurityQuestion");	
		if(result.hasErrors()) {
			System.out.println("Bindingg EWrror");
			mv.addObject("setSecurityQuestion",setSecurityQuestion);	
		}else {
			
			System.out.println("verifyFirstTimeLoginAction.getName()"+ auth.getName());	
			
			passwordChangeImpl.setSecQAnAns(setSecurityQuestion,uci);
			mv.addObject("setSecurityQuestion",new SetSecurityQuestionModel());		
			mv.addObject("uci", uci);
			
			mv.addObject("message", "User Security question has been set successfully!!!");
		}		
					
		return mv;
	}
	
	@GetMapping({"/setSecurityQuestion"})
	public ModelAndView SetSecurityQuestionActiongGet(@RequestParam("uci") @Valid String uci) throws IBSExceptionHandler {
		
		ModelAndView mv = new ModelAndView();
		passwordChangeImpl.confirmUser(uci);
		mv.setViewName("setSecurityQuestion");
		mv.addObject("uci", uci);
		
		mv.addObject("setSecurityQuestion",new SetSecurityQuestionModel());
							
		return mv;
	}
	
	
	@GetMapping({"/changePassword"})
	public ModelAndView verifyFirstTimeLoginAction(@RequestParam("uci") @Valid String uci) throws IBSExceptionHandler {
		
		ModelAndView mv = new ModelAndView();
		passwordChangeImpl.confirmUser(uci);
		mv.setViewName("changePassword");	
		mv.addObject("uci", uci);
		
		mv.addObject("chgPassword",new CustomerNewPasswordModel());
							
		return mv;
	}
	
	@GetMapping("/changePasswordForget")
	public ModelAndView forgetResetPsswrdGet() throws IBSExceptionHandler {	
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("changePasswordForget");
		
		mv.addObject("chgPasswordReset",new CustomerNewPasswordForgetModel());
							
		return mv;
	}//changePasswordForget
	

	@PostMapping({"/changePasswordForgetReset"})
	public ModelAndView forgetResetPsswrdAction(@ModelAttribute("chgPasswordReset") @Valid CustomerNewPasswordForgetModel chgPasswordReset,
			BindingResult result) throws IBSExceptionHandler {
			
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("changePasswordForget");	
		if(result.hasErrors()) {
			System.out.println("Bindingg EWrror");
			mv.addObject("chgPasswordReset",chgPasswordReset);	
		}else {		
			passwordChangeImpl.changePasswordForget(chgPasswordReset);
			mv.addObject("chgPasswordReset",new CustomerNewPasswordForgetModel());	
			
			mv.addObject("message", "User changed password successfully!!!");
		}		
					
		return mv;
	}


	@GetMapping("/aboutUs")
	public ModelAndView aboutUsAction() throws IBSExceptionHandler {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("aboutUs");
//		mv.addObject("groups",agService.getAll());
//		mv.addObject("group",new AddressGroupModel());
		return mv;
	}
	
	@GetMapping("/error")
	public ModelAndView errorAction(@RequestParam("uci") @Valid String uci) throws IBSExceptionHandler {
		ModelAndView mv = new ModelAndView();
		passwordChangeImpl.confirmUser(uci);
		mv.setViewName("access-denied-page.jsp");
		mv.addObject("uci", uci);
		return mv;
	}
	
	

	
	
	

}