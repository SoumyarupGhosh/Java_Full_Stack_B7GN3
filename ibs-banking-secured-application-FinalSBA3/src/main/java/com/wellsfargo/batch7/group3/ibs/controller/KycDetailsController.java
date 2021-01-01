package com.wellsfargo.batch7.group3.ibs.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.wellsfargo.batch7.group3.ibs.exception.IBSExceptionHandler;
import com.wellsfargo.batch7.group3.ibs.model.KycDetailsModel;
import com.wellsfargo.batch7.group3.ibs.model.ServiceProviderTransactionInfoModel;
import com.wellsfargo.batch7.group3.ibs.service.KycDetailsServiceImpl;
import com.wellsfargo.batch7.group3.ibs.util.EMnMEParser;
import com.wellsfargo.batch7.group3.ibs.util.LoadPropertiesFile;



@Controller
@RequestMapping("/registrationForm")
public class KycDetailsController {
	
	@Autowired
	private KycDetailsServiceImpl kycDetailsSer;
	
	@GetMapping
	public ModelAndView regHomeAction() throws IBSExceptionHandler {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("registrationHome");
		
		return mv;
	}
	
	@GetMapping("register")
	public ModelAndView registerAction() throws IBSExceptionHandler {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("registrationForm");
	mv.addObject("newUsersKyc",kycDetailsSer.getAll());
		mv.addObject("newUserKyc",new KycDetailsModel());
		
		mv.addObject("tenureFixed",LoadPropertiesFile.getTenureList("TenureFixed"));
		mv.addObject("tenureReccuring",LoadPropertiesFile.getTenureList("TenureRecurring"));
		mv.addObject("branchList",LoadPropertiesFile.getBranchList("BankBranchList"));
		
		return mv;
	}
	
	@GetMapping("/trackStatus")
	public ModelAndView getRegIdAction() throws IBSExceptionHandler {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("registrationTrackStatus");
		
		return mv;
	}
//	
	@PostMapping("/register")
	public ModelAndView addUserAction(
			@ModelAttribute("newUserKyc") @Valid KycDetailsModel newUserKyc,
			BindingResult result) throws IBSExceptionHandler {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("registrationForm");	
		
		if(result.hasErrors()) {
			
			mv.addObject("newUserKyc",newUserKyc);	
			
		}else {
			
			
			
			KycDetailsModel addedRegid=kycDetailsSer.add(newUserKyc);
			
			mv.addObject("newUserKyc",new KycDetailsModel());	
			mv.addObject("tenureFixed",LoadPropertiesFile.getTenureList("TenureFixed"));
			mv.addObject("tenureReccuring",LoadPropertiesFile.getTenureList("TenureRecurring"));
			mv.addObject("branchList",LoadPropertiesFile.getBranchList("BankBranchList"));
			mv.addObject("message", "User Registration is successfully Completed!!! Your Reg id is   " + addedRegid.getRegId() );
			
		}
	//	mv.addObject("newUsersKyc",kycDetailsSer.getAll());
		return mv;		
	//	mv.addObject("newUsersKyc",kycDetailsSer.get(EMnMEParser.parse(newUserKyc).getRegId()));
	//	mv.addObject("fetchRegId", kycDetailsSer.getbyMobileNum(newUserKyc.getMobileNum()));		
	}
	
	@PostMapping("/trackStatus")
	public ModelAndView toTrackStatus( @RequestParam("registrationid") Long regId) throws IBSExceptionHandler {
		
		ModelAndView mv = new ModelAndView();	
		mv.setViewName("registrationTrackStatus");									
					
					KycDetailsModel kycModel=kycDetailsSer.get(regId);				
					mv.addObject("messageStatus", "The Application is currently under "+kycModel.getKycApproval() +"  status");					
		return mv;		
	//	mv.addObject("newUsersKyc",kycDetailsSer.get(EMnMEParser.parse(newUserKyc).getRegId()));
	//	mv.addObject("fetchRegId", kycDetailsSer.getbyMobileNum(newUserKyc.getMobileNum()));		
	}
		

}
