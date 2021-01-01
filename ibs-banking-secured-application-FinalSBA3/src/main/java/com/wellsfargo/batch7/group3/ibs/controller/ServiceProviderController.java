package com.wellsfargo.batch7.group3.ibs.controller;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Date;

import javax.print.attribute.standard.Severity;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.wellsfargo.batch7.group3.ibs.exception.IBSExceptionHandler;
import com.wellsfargo.batch7.group3.ibs.model.AccountStatementDto;
import com.wellsfargo.batch7.group3.ibs.model.KycDetailsModel;
import com.wellsfargo.batch7.group3.ibs.model.ServiceProviderNewPasswordModel;
import com.wellsfargo.batch7.group3.ibs.model.ServiceProviderTransactionInfoModel;
import com.wellsfargo.batch7.group3.ibs.service.IKycDetailsService;
import com.wellsfargo.batch7.group3.ibs.service.KycDetailsServiceImpl;
import com.wellsfargo.batch7.group3.ibs.service.PasswordChangeImpl;
import com.wellsfargo.batch7.group3.ibs.service.SerProviderGetPaymentServiceImpl;
import com.wellsfargo.batch7.group3.ibs.util.Converters;
import com.wellsfargo.batch7.group3.ibs.util.EMnMEParser;


@Controller
@RequestMapping("/serviceProviderLogin") //URL change to loginPage
public class ServiceProviderController
{
	
	
	
	@Autowired
	private SerProviderGetPaymentServiceImpl serProviderGetPaymentServiceImpl;
	
	@Autowired
	private PasswordChangeImpl passChangeImpl;
	
	
	
	@GetMapping
	public ModelAndView serProviderHome(@RequestParam("uci") String uci) throws IBSExceptionHandler {
		ModelAndView mv= new ModelAndView();
		mv.setViewName("serviceProviderHome");
		passChangeImpl.confirmUser(uci);
		mv.addObject("uci", uci);
		return mv;
	}
	
	@GetMapping("/acctStmt")
	public ModelAndView acctStmt(@RequestParam("uci") String uci) throws IBSExceptionHandler {
		ModelAndView mv = null;
//			mv = new ModelAndView("/accountStatement","acctStmt",customerImpl.getAccountStatement(uci));
//			mv.addObject("AllcustAcctNum",customerImpl.getSavRecAccountList(uci));
			mv = new ModelAndView("serProvideraccountStatement","AllcustAcctNum",serProviderGetPaymentServiceImpl.getOnlyCustPaidAccountList(uci));
			passChangeImpl.confirmUser(uci);
			mv.addObject("uci", uci);
		return mv;
	}
	
	@GetMapping("/filterStmt")
	public ModelAndView filterAcctStmt(@ModelAttribute("filterStmt") @Valid AccountStatementDto filterStmtData,@RequestParam("uci") String uci) throws IBSExceptionHandler, ParseException {
		ModelAndView mv = null;		
			mv = new ModelAndView("serProvideraccountStatement","acctStmt",serProviderGetPaymentServiceImpl.getCustPaidFilteredStatement(filterStmtData));
//			mv.addObject("custAcctNum",customerImpl.getCustomerData(uci).get(0).getCustAcctNum());	
			passChangeImpl.confirmUser(uci);
			mv.addObject("uci", uci);
			mv.addObject("AllcustAcctNum",serProviderGetPaymentServiceImpl.getOnlyCustPaidAccountList(uci));
			
		return mv;
	}

		


}
