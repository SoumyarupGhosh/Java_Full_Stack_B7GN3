package com.wellsfargo.batch7.group3.ibs.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.wellsfargo.batch7.group3.ibs.exception.IBSExceptionHandler;
import com.wellsfargo.batch7.group3.ibs.model.AccountStatementDto;
import com.wellsfargo.batch7.group3.ibs.model.KycDetailsModel;
import com.wellsfargo.batch7.group3.ibs.service.CustomerImpl;
import com.wellsfargo.batch7.group3.ibs.service.IKycDetailsService;
import com.wellsfargo.batch7.group3.ibs.service.KycDetailsServiceImpl;
import com.wellsfargo.batch7.group3.ibs.service.PasswordChangeImpl;
import com.wellsfargo.batch7.group3.ibs.service.SerProviderGetPaymentServiceImpl;
import com.wellsfargo.batch7.group3.ibs.util.EMnMEParser;


@Controller
@RequestMapping("/employeeLogin") //URL change to loginPage
public class IBSExecController
{	
	@Autowired
	private KycDetailsServiceImpl kycDetailsService;
	
	@Autowired
	private CustomerImpl customerImpl;
	
	@Autowired
	private SerProviderGetPaymentServiceImpl serProviderImpl;
	
	@Autowired
	private PasswordChangeImpl  passChangeImpl;
	
	@GetMapping
	public ModelAndView employeeHome(@RequestParam("uci") @Valid String uci) throws IBSExceptionHandler {
		ModelAndView mv= new ModelAndView();
		passChangeImpl.confirmUser(uci);
		mv.setViewName("employeeHome");	
		mv.addObject("uci", uci);
		return mv;
	}
	
	@GetMapping("/kyc")
	public ModelAndView employeeLoginAction(@RequestParam("uci") @Valid String uci) throws IBSExceptionHandler {
		ModelAndView mv = null;	
		passChangeImpl.confirmUser(uci);
		mv = new ModelAndView("processingKyc","kycInfo",kycDetailsService.getAllPending());
		mv.addObject("uci", uci);
		return  mv; ///ProcessingKyc view
	}
	
	@GetMapping("/bnfcry")
	public ModelAndView employeeLoginBnfcryction(@RequestParam("uci") @Valid String uci) throws IBSExceptionHandler {
		ModelAndView mv = null;
		passChangeImpl.confirmUser(uci);
		mv = new ModelAndView("processingBnfcry","bnfcryInfo",customerImpl.getAllBnfcryPending());
		mv.addObject("uci", uci);		 
		return mv;  ///ProcessingBnfcry view
	}
	
	@GetMapping("/rejectBnfcry") // once click from jsp its called
	public String RejectBnfcryAction(@RequestParam("bnfcryId") Long bnfcryId,@RequestParam("uci") @Valid String uci ) throws IBSExceptionHandler {
		//ModelAndView mv = new ModelAndView();	
		passChangeImpl.confirmUser(uci);	
		customerImpl.updateRejectBnfcrcy(bnfcryId);
		return ("redirect:/employeeLogin/bnfcry?uci=" + uci);
		}	
	
	@GetMapping("/acceptBnfcry") // once click from jsp its called
	public String AcceptBnfcryAction(@RequestParam("bnfcryId") Long bnfcryId,@RequestParam("uci") @Valid String uci ) throws IBSExceptionHandler {	
		passChangeImpl.confirmUser(uci);
		customerImpl.updateAcceptBnfcry(bnfcryId);
		return ("redirect:/employeeLogin/bnfcry?uci=" + uci);
		}	
	
	@GetMapping("/reject") // once click from jsp its called
	public String RejectAction(@RequestParam("registeredId") Long regId,@RequestParam("uci") @Valid String uci ) throws IBSExceptionHandler {		
		passChangeImpl.confirmUser(uci);
		kycDetailsService.updateReject(regId);		
		return ("redirect:/employeeLogin/kyc?uci=" + uci);
		}	
	
  	
	@GetMapping("/accept")
	public String acceptAction(@RequestParam("registeredId") Long regId,@RequestParam("uci") @Valid String uci ) throws IBSExceptionHandler, FileNotFoundException, IOException {			
		System.out.println("the reg id is"+regId);
		passChangeImpl.confirmUser(uci);
		kycDetailsService.updateAccept(regId);
		return ("redirect:/employeeLogin/kyc?uci=" + uci);
	}
	
	@PostMapping("/provideAdminComments")
	public String provideAdminCommentsAction(@RequestParam("AdminComments") String AdminComments,
			@RequestParam("register_id") Long register_id ,
			@RequestParam("btn") String btn
			) throws IBSExceptionHandler {
			
			kycDetailsService.updateAdminComments(AdminComments,register_id);
			System.out.println("ReyanshReyanshReyansh"+ register_id );
			
			if(btn.equals("ACCEPT"))
					{
				return "redirect:/accept";
					}
			else
			{
				return "redirect:/reject";
			}
			
			
	}
	
	@GetMapping("/execAcctStmtHome")
	public ModelAndView execAcctStatementGetAction(@RequestParam("uci") String uci) throws IBSExceptionHandler {
		ModelAndView mv = new ModelAndView();
		passChangeImpl.confirmUser(uci);
		mv.setViewName("execAccountStatementHome");
		mv.addObject("uci", uci);
		return mv;
	}
	
	@GetMapping("/execAcctStmt")
	public ModelAndView acctStmt(@RequestParam("uci") String uci) throws IBSExceptionHandler {
		ModelAndView mv = null;
			passChangeImpl.confirmUser(uci);
//			mv = new ModelAndView("/accountStatement","acctStmt",customerImpl.getAccountStatement(uci));
//			mv.addObject("AllcustAcctNum",customerImpl.getSavRecAccountList(uci));
			mv = new ModelAndView("execAccountStatement","AllcustAcctNum",kycDetailsService.getAllSavRecAccountList());
//			mv.addObject("AllserProvideAcctNum",kycDetailsService.getAllSerProAccountList());
			mv.addObject("uci", uci);
		return mv;
	}
	
	@GetMapping("/execFilterAcctStmt")
	public ModelAndView filterAcctStmt(@ModelAttribute("execStatefilterStmt") @Valid AccountStatementDto execStatefilterStmt,@RequestParam("uci") String uci) throws IBSExceptionHandler, ParseException {
		ModelAndView mv = null;		
		passChangeImpl.confirmUser(uci);
			mv = new ModelAndView("execAccountStatement","acctStmt",customerImpl.getFilteredStatement(execStatefilterStmt));
//			mv.addObject("custAcctNum",customerImpl.getCustomerData(uci).get(0).getCustAcctNum());			
			mv.addObject("uci", uci);
			mv.addObject("AllcustAcctNum",kycDetailsService.getAllSavRecAccountList());
//			mv.addObject("AllserProvideAcctNum",kycDetailsService.getAllSerProAccountList());
		return mv;
	}
	
	@GetMapping("/execFundStmt")
	public ModelAndView execFundStmt(@RequestParam("uci") String uci) throws IBSExceptionHandler {
		ModelAndView mv = null;
		passChangeImpl.confirmUser(uci);
			mv = new ModelAndView("execFundStatement","AllcustAcctNum",kycDetailsService.getAllFundAccountList());
			mv.addObject("uci", uci);
		return mv;
	}
	
	@GetMapping("/execFilterFundStmt")
	public ModelAndView execfilterFuStmt(@ModelAttribute("execFundfilterStmt") @Valid AccountStatementDto execFundfilterStmt,@RequestParam("uci") String uci) throws IBSExceptionHandler, ParseException {
		ModelAndView mv = null;	
		passChangeImpl.confirmUser(uci);
			mv = new ModelAndView("execFundStatement","fundStmt",customerImpl.getFilteredFundStatement(execFundfilterStmt));		
			mv.addObject("uci", uci);
			mv.addObject("AllcustAcctNum",kycDetailsService.getAllFundAccountList());
		return mv;
	} //
	
	@GetMapping("/execServiceProviderStmt")
	public ModelAndView execSerProviderStmt(@RequestParam("uci") String uci) throws IBSExceptionHandler {
		ModelAndView mv = null;
		passChangeImpl.confirmUser(uci);
			mv = new ModelAndView("execServProviderStmt","AllcustAcctNum",kycDetailsService.getAllSerProAccountList());
			mv.addObject("uci", uci);
		return mv;
	}
	
	@GetMapping("/execFilterServiceProviderStmt")
	public ModelAndView execfilterSerProviderStmt(@ModelAttribute("execSPfilterStmt") @Valid AccountStatementDto execSPfilterStmt,@RequestParam("uci") String uci) throws IBSExceptionHandler, ParseException {
		ModelAndView mv = null;		
		passChangeImpl.confirmUser(uci);
			mv = new ModelAndView("execServProviderStmt", "SPStmt",serProviderImpl.getserviceProviderFilteredStatement(execSPfilterStmt));		
			mv.addObject("uci", uci);
			mv.addObject("AllcustAcctNum",kycDetailsService.getAllSerProAccountList());
		return mv;
	}
	
	

}
