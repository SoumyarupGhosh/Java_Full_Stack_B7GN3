package com.wellsfargo.batch7.group3.ibs.controller;

import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jms.JmsProperties.DeliveryMode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.wellsfargo.batch7.group3.ibs.entities.CustomerAccountTypesInfo;
import com.wellsfargo.batch7.group3.ibs.exception.IBSExceptionHandler;
import com.wellsfargo.batch7.group3.ibs.model.AccountStatementDto;
import com.wellsfargo.batch7.group3.ibs.model.CustomerAccountDto;
import com.wellsfargo.batch7.group3.ibs.model.CustomerAccountTypesInfoDto;
import com.wellsfargo.batch7.group3.ibs.model.CustomerBeneficiaryDto;
import com.wellsfargo.batch7.group3.ibs.model.CustomerNewPasswordModel;
import com.wellsfargo.batch7.group3.ibs.model.CustomerTransactionsDto;
import com.wellsfargo.batch7.group3.ibs.model.ServiceProviderTransactionInfoModel;
import com.wellsfargo.batch7.group3.ibs.repo.CustomerAccountTypesInfoRepo;
import com.wellsfargo.batch7.group3.ibs.repo.CustomerRepository;
import com.wellsfargo.batch7.group3.ibs.service.CustomerImpl;
import com.wellsfargo.batch7.group3.ibs.service.KycDetailsServiceImpl;
import com.wellsfargo.batch7.group3.ibs.service.PasswordChangeImpl;
import com.wellsfargo.batch7.group3.ibs.service.SerProviderGetPaymentServiceImpl;
import com.wellsfargo.batch7.group3.ibs.util.LoadPropertiesFile;



@Controller
@RequestMapping("/customerLogin") //URL change to loginPage
public class CustomerController {

	@Autowired
	private CustomerImpl customerImpl;
	
	@Autowired
	private CustomerAccountTypesInfoRepo customerAccountTypesInfoRepo;
	
	@Autowired
	private CustomerRepository custAcctRepo;
	
	@Autowired
	private SerProviderGetPaymentServiceImpl serProviderImpl;
	
	@Autowired
	private PasswordChangeImpl passChangeImpl;
	
	@GetMapping
	public ModelAndView customerHome(@RequestParam("uci") @Valid String uci) throws IBSExceptionHandler {
		ModelAndView mv= new ModelAndView();
		passChangeImpl.confirmUser(uci);
		mv.setViewName("customeHome");	
		mv.addObject("uci", uci); 
		return mv;
	}

	
	@GetMapping("/acctSummary")
	public ModelAndView acctSummaryAction(@RequestParam("uci") @Valid String uci) throws IBSExceptionHandler {
		ModelAndView mv = null;
		passChangeImpl.confirmUser(uci);
		List<CustomerAccountTypesInfoDto> custAcct = customerImpl.getCustomerData(uci);
		mv = new ModelAndView("accountSummary", "savingsData", customerImpl.getSavingsAcctInfo(custAcct) );
		mv.addObject("uci", uci);
		return mv;
	}
	
	@GetMapping("/fixedDeposit")
	public ModelAndView fixedDepAction(@RequestParam("uci") @Valid String uci) throws IBSExceptionHandler {
		ModelAndView mv = null;
		passChangeImpl.confirmUser(uci);
		List<CustomerAccountTypesInfoDto> custAcct = customerImpl.getCustomerData(uci);
		mv = new ModelAndView("fixedDeposit", "fdData", customerImpl.getFixedDepositInfo(custAcct) );
		mv.addObject("uci", uci);
		return mv;
	}
	
	@GetMapping("/recurringDeposit")
	public ModelAndView recurringDepAction(@RequestParam("uci") @Valid String uci) throws IBSExceptionHandler {
		ModelAndView mv = null;
		passChangeImpl.confirmUser(uci);
		List<CustomerAccountTypesInfoDto> custAcct = customerImpl.getCustomerData(uci);
		mv = new ModelAndView("recurringDeposit", "rdData", customerImpl.getRecurringDepositInfo(custAcct)); 
		//mv = new ModelAndView("fixedDeposit", "rdData", customerImpl.getRecurringDepositInfo(custAcct));
		mv.addObject("uci", uci);
		return mv;
	}
	
	@GetMapping("/addBnfPage")
	public ModelAndView addBnfPage(@RequestParam("uci") String uci) throws IBSExceptionHandler {
		ModelAndView mv = null;
		passChangeImpl.confirmUser(uci);
		mv = new ModelAndView("addBeneficiary", "uci", uci);	
		List<CustomerAccountTypesInfoDto> custAcct = customerImpl.getCustomerData(uci);
		mv.addObject("savAcctList",customerImpl.getSavingsAcctInfo(custAcct));
				
		return mv;
	}
	
	@PostMapping("/addBnfcry")
	public ModelAndView addBnfcry(@ModelAttribute("addBnf") @Valid CustomerBeneficiaryDto addBnfcry, 
			BindingResult result,@RequestParam("uci")  String uci ) throws IBSExceptionHandler {
		ModelAndView mv = null;
		passChangeImpl.confirmUser(uci);
		CustomerBeneficiaryDto bnfcryAdd= customerImpl.addBeneficiary(addBnfcry,uci);
		List<CustomerBeneficiaryDto> benList = customerImpl.getListOfBnfcry(uci);//customeracct
		mv = new ModelAndView("fundsTransferHome","bncfryList",benList);
		mv.addObject("uci", uci);
		mv.addObject("message", "Add Beneficiary request raised successfully.Generated Beneficiary Id:"+ bnfcryAdd.getBnfcryId())	;	 
		return mv;
	}
	
	
	@GetMapping("/deleteBnfcry")
	public ModelAndView deleteBnfcy(@RequestParam("uci")  String uci,@RequestParam("bnfcryId")  Long bnfcryId) throws IBSExceptionHandler
	{
		ModelAndView mv = null;
		passChangeImpl.confirmUser(uci);
		customerImpl.deleteBeneficiary(bnfcryId,uci);
		List<CustomerBeneficiaryDto> benList = customerImpl.getListOfBnfcry(uci);//customeracct
		mv = new ModelAndView("fundsTransferHome","bncfryList",benList);
		mv.addObject("uci", uci);
		return mv;
	}
	
	@GetMapping("/fundConfirmPassword")
		public ModelAndView fundConfirmPassGet(@RequestParam("uci")  String uci) throws IBSExceptionHandler
		{
			ModelAndView mv = null;
			passChangeImpl.confirmUser(uci);
			mv = new ModelAndView("fundConfirmPassword","uci", uci);
			return mv;
		}
	
	@PostMapping("/fundConPassword")
	public ModelAndView fundConfirmPassAction(@ModelAttribute("confirmPassword") @Valid CustomerNewPasswordModel confirmPassword,
	BindingResult result,@RequestParam("uci")  String uci) throws IBSExceptionHandler
	{
		ModelAndView mv = null;
		passChangeImpl.confirmUser(uci);
		passChangeImpl.confirmPassword(confirmPassword,uci);
		List<CustomerBeneficiaryDto> benList = customerImpl.getListOfBnfcry(uci);//customeracc
		mv = new ModelAndView("fundsTransferHome","bncfryList",benList);
		mv.addObject("uci", uci);
		return mv;
	}
	
	@GetMapping("/billConfirmPassword")
	public ModelAndView billConfirmPassGet(@RequestParam("uci")  String uci) throws IBSExceptionHandler
	{
		ModelAndView mv = null;
		passChangeImpl.confirmUser(uci);
		mv = new ModelAndView("billConfirmPassword","uci", uci);
		return mv;
	}

	@PostMapping("/billConPassword")
	public ModelAndView billConfirmPassAction(@ModelAttribute("ConfirmPassword") @Valid CustomerNewPasswordModel ConfirmPassword,
	BindingResult result,@RequestParam("uci")  String uci) throws IBSExceptionHandler
	{
		ModelAndView mv = null;
		passChangeImpl.confirmUser(uci);
		passChangeImpl.confirmPassword(ConfirmPassword,uci);	
		List<CustomerAccountTypesInfoDto> custAcct = customerImpl.getCustomerData(uci);					
		mv = new ModelAndView("billPayment","fromCustAcctNum",customerImpl.getSavingsAcctInfo(custAcct));
		mv.addObject("servProviderList", serProviderImpl.getAllServiceProviderList());
		mv.addObject("uci", uci);
		
		return mv;
	}
	
	@GetMapping("/openNewAccountPage")
	public ModelAndView OpenNewAccountPgeAction(@RequestParam("uci") String uci) throws IBSExceptionHandler {
		ModelAndView mv = null;
		passChangeImpl.confirmUser(uci);
		mv = new ModelAndView("openNewAccount", "openNewAcct", new CustomerAccountTypesInfoDto());
		
		mv.addObject("tenureFixed",LoadPropertiesFile.getTenureList("TenureFixed"));
		mv.addObject("tenureReccuring",LoadPropertiesFile.getTenureList("TenureRecurring"));
		mv.addObject("branchList",LoadPropertiesFile.getBranchList("BankBranchList"));
		
		mv.addObject("uci",uci);
		return mv;
	}
	
	@PostMapping("/openNewAccunt")
	public ModelAndView OpenNewAccountAction(@ModelAttribute("openNewAcct") @Valid CustomerAccountTypesInfoDto openNewAcct, 
			@RequestParam("uci")  String uci, BindingResult result) throws IBSExceptionHandler {
		
		ModelAndView mv =null;
		passChangeImpl.confirmUser(uci);
		CustomerAccountTypesInfoDto CustActType=customerImpl.addNewCustAccount(openNewAcct,uci);
//		List<CustomerBeneficiaryDto> benList = customerImpl.getListOfBnfcry(uci);
		
		if(result.hasErrors()) {
			mv.addObject("openNewAccunt",openNewAcct);				
		}
		else
		{		
		mv = new ModelAndView("openNewAccount","openNewAcct", new CustomerAccountTypesInfoDto());
		mv.addObject("tenureFixed",LoadPropertiesFile.getTenureList("TenureFixed"));
		mv.addObject("tenureReccuring",LoadPropertiesFile.getTenureList("TenureRecurring"));
		mv.addObject("branchList",LoadPropertiesFile.getBranchList("BankBranchList"));
		mv.addObject("uci", uci);
		
		}
		mv.addObject("message","New Account got open. Account Number:" + CustActType.getCustomerAcctNum());
		return mv;
	}

	
	
	@GetMapping("/fundsTransferHome")
	public ModelAndView fundsTransferHome(@RequestParam("uci") @Valid String uci) throws IBSExceptionHandler {
		ModelAndView mv = null;
		passChangeImpl.confirmUser(uci);
		mv = new ModelAndView("fundsTransferHome","bncfryList",customerImpl.getListOfBnfcry(uci));

		mv.addObject("uci", uci);
		return mv;
	}

	
	@GetMapping("/transferFunds")
	public ModelAndView transferFunds(@RequestParam("uci") String uci) throws IBSExceptionHandler {
		ModelAndView mv = null;
		passChangeImpl.confirmUser(uci);
		//	mv = new ModelAndView("fundsTransfer","bncfryList",customerImpl.getListOfBnfcryAccepted(uci,fromAcctNum));
			List<CustomerAccountTypesInfoDto> custAcct = customerImpl.getCustomerData(uci);			
		//	mv.addObject("fromCustAcctNum",customerImpl.getSavingsAcctInfo(custAcct));
			mv = new ModelAndView("fundsTransfer","fromCustAcctNum",customerImpl.getSavingsAcctInfo(custAcct));
			mv.addObject("bncfryList", customerImpl.getListOfBnfcryAccepted(uci));
			mv.addObject("uci", uci);
		return mv;
	}
	
	@PostMapping("/transfer")
	public ModelAndView transfer(@ModelAttribute("transfer") @Valid CustomerTransactionsDto transferObj, @RequestParam("uci") String uci) throws IBSExceptionHandler {
		ModelAndView mv = null;
		passChangeImpl.confirmUser(uci);
			CustomerTransactionsDto custrasDto=customerImpl.transferFunds(transferObj);
			mv = new ModelAndView("fundsTransferHome","bncfryList",customerImpl.getListOfBnfcry(uci));
			mv.addObject("uci", uci);
			mv.addObject("message","Your Transaction process completed successfully. TxnID: " + custrasDto.getTxnId() +" Click FundTransfer again link to perform another transaction");
			
		return mv;
	}
	
	@GetMapping("/billPymtPage")
	public ModelAndView billPaymentGet(@RequestParam("uci") String uci) throws IBSExceptionHandler {
		ModelAndView mv = null;
		passChangeImpl.confirmUser(uci);
			List<CustomerAccountTypesInfoDto> custAcct = customerImpl.getCustomerData(uci);					
			mv = new ModelAndView("billPayment","fromCustAcctNum",customerImpl.getSavingsAcctInfo(custAcct));
			mv.addObject("servProviderList", serProviderImpl.getAllServiceProviderList());
			mv.addObject("uci", uci);
		return mv;
	}
	
	@PostMapping("/billPaymt")
	public ModelAndView billPymt(@ModelAttribute("billPymt") @Valid CustomerTransactionsDto billPymtObj, @RequestParam("uci") String uci) throws IBSExceptionHandler {
		ModelAndView mv = null;
		passChangeImpl.confirmUser(uci);
		CustomerTransactionsDto txnobj= customerImpl.BillPaymentDebit(billPymtObj);
		ServiceProviderTransactionInfoModel sertxnObj=serProviderImpl.ServBillPymntCrdt(billPymtObj);
			List<CustomerAccountTypesInfoDto> custAcct = customerImpl.getCustomerData(uci);
			mv = new ModelAndView("billPayment","billPymt",new CustomerTransactionsDto() );
			mv.addObject("fromCustAcctNum",customerImpl.getSavingsAcctInfo(custAcct));
			mv.addObject("servProviderList", serProviderImpl.getAllServiceProviderList());
//			mv.setViewName("/billPymtPage");
//			//mv.setViewName("billPayment");
			mv.addObject("uci", uci);
			mv.addObject("message","Successfully Paid the bill.Your txn id is " + txnobj.getTxnId());
			return mv;
			
	}
	
	@GetMapping("/acctStmt")
	public ModelAndView acctStmt(@RequestParam("uci") String uci) throws IBSExceptionHandler {
		ModelAndView mv = null;
		passChangeImpl.confirmUser(uci);
//			mv = new ModelAndView("/accountStatement","acctStmt",customerImpl.getAccountStatement(uci));
//			mv.addObject("AllcustAcctNum",customerImpl.getSavRecAccountList(uci));
			mv = new ModelAndView("accountStatement","AllcustAcctNum",customerImpl.getSavRecAccountList(uci));
			mv.addObject("uci", uci);
		return mv;
	}
	
	@GetMapping("/filterStmt")
	public ModelAndView filterAcctStmt(@ModelAttribute("filterStmt") @Valid AccountStatementDto filterStmtData,@RequestParam("uci") String uci) throws IBSExceptionHandler, ParseException {
		ModelAndView mv = null;
		passChangeImpl.confirmUser(uci);
			mv = new ModelAndView("accountStatement","acctStmt",customerImpl.getFilteredStatement(filterStmtData));
//			mv.addObject("custAcctNum",customerImpl.getCustomerData(uci).get(0).getCustAcctNum());			
			mv.addObject("uci", filterStmtData.getUserName());
			mv.addObject("AllcustAcctNum",customerImpl.getSavRecAccountList(uci));
			mv.addObject("custAcctNum", filterStmtData.getCustAcctNum());
		return mv;
	}
		
//	public static String from(BindingResult result) {
//		StringBuilder sb = new StringBuilder();
//		
//		for(ObjectError err : result.getAllErrors()) {
//			sb.append(err.getDefaultMessage()+",");
//		}
//		
//		return sb.toString();
//	} 
	
}
