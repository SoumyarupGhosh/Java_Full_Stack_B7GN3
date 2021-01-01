package com.wellsfargo.batch7.group3.ibs.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.SetFactoryBean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.wellsfargo.batch7.group3.ibs.entities.CustomerAccount;
import com.wellsfargo.batch7.group3.ibs.entities.CustomerAccountTypesInfo;
import com.wellsfargo.batch7.group3.ibs.entities.CustomerTransactions;
import com.wellsfargo.batch7.group3.ibs.entities.LoginInfo;
import com.wellsfargo.batch7.group3.ibs.entities.ServiceProviderAccount;
import com.wellsfargo.batch7.group3.ibs.entities.ServiceProviderTransactionInfo;
import com.wellsfargo.batch7.group3.ibs.exception.IBSExceptionHandler;
import com.wellsfargo.batch7.group3.ibs.model.AccountStatementDto;
import com.wellsfargo.batch7.group3.ibs.model.CustomerAccountTypesInfoDto;
import com.wellsfargo.batch7.group3.ibs.model.CustomerNewPasswordModel;
import com.wellsfargo.batch7.group3.ibs.model.CustomerTransactionsDto;
import com.wellsfargo.batch7.group3.ibs.model.KycDetailsModel;
import com.wellsfargo.batch7.group3.ibs.model.ServiceProviderAccountModel;
import com.wellsfargo.batch7.group3.ibs.model.ServiceProviderNewPasswordModel;
import com.wellsfargo.batch7.group3.ibs.model.ServiceProviderTransactionInfoModel;
import com.wellsfargo.batch7.group3.ibs.repo.CustomerAccountTypesInfoRepo;
import com.wellsfargo.batch7.group3.ibs.repo.CustomerRepository;
import com.wellsfargo.batch7.group3.ibs.repo.LoginInfoRepo;
import com.wellsfargo.batch7.group3.ibs.repo.ServiceProviderAccountRepo;
import com.wellsfargo.batch7.group3.ibs.repo.ServiceProviderTransactionInfoRepo;
import com.wellsfargo.batch7.group3.ibs.util.Converters;
import com.wellsfargo.batch7.group3.ibs.util.EMnMEParser;
import com.wellsfargo.batch7.group3.ibs.util.EMnMEParserCust;

@Service
public class SerProviderGetPaymentServiceImpl implements ISerProviderGetPaymentServices
{

	@Autowired
	private ServiceProviderTransactionInfoRepo serviceProviderTransactionInfoRepo;
	
	@Autowired
	private ServiceProviderAccountRepo serviceProviderAccountRepo;
	
	@Autowired
	private CustomerRepository cusRepo;
	
	@Autowired
	private PasswordEncoder encoder;

	@Autowired
	private CustomerAccountTypesInfoRepo custTypeRepo;


@Override
public List<ServiceProviderTransactionInfoModel> getAllPayment()
		throws IBSExceptionHandler {
	// TODO Auto-generated method stub
	return serviceProviderTransactionInfoRepo.findAll().stream().map(e -> EMnMEParser.serparse(e)).collect(Collectors.toList());
}

@Override
public List<ServiceProviderAccountModel> getAllServiceProviderList() {
	List<ServiceProviderAccount> c1 = serviceProviderAccountRepo.findAll()	;
	List<ServiceProviderAccountModel> servObj1 = c1.stream().map(e ->EMnMEParser.serparse(e)).collect(Collectors.toList());		
	return servObj1;
}

@Override
public ServiceProviderTransactionInfoModel ServBillPymntCrdt(@Valid CustomerTransactionsDto transferObj) throws IBSExceptionHandler{
	
	//CustomerAccountTypesInfo acctInfoFrom =serviceProviderTransactionInfoRepo.findByCustomerAcctNum(transferObj.getFromAcctNum());
	ServiceProviderAccount acctInfoTo =serviceProviderAccountRepo.findAllByAccountId(transferObj.getToAcctNum());
	CustomerAccountTypesInfo cusAcctType = custTypeRepo.findByCustomerAcctNum(transferObj.getFromAcctNum());
	CustomerAccount custacctInfo = cusRepo.findByUci(cusAcctType.getUci());
	Double prevBal=null;
	if(acctInfoTo.getCurrentBalance()!=null)	
	{
		prevBal = acctInfoTo.getCurrentBalance();
	}
	else
	{
		prevBal=(double) 0;
	}
	Double newBal = prevBal + transferObj.getTxnAmt();
	acctInfoTo.setCurrentBalance(newBal);
	serviceProviderAccountRepo.save(acctInfoTo);
	
	System.out.println("Inside the serv provider credit bosy");
	
//	 txnObj = EMnMEParserCust.txnParse(custTxnRepo.save(EMnMEParserCust.txnParse(transferObj,acctInfoTo.getUci(),"CREDIT-TO")));
	ServiceProviderTransactionInfoModel txnObj=EMnMEParser.serparse(serviceProviderTransactionInfoRepo.save(EMnMEParser.serparse
			(EMnMEParser.serparse(transferObj,acctInfoTo,cusAcctType,custacctInfo,newBal,"CREDIT"))));
	return txnObj;
	
//	serviceProviderTransactionInfoRepo.save(EMnMEParser.serparse
//		(EMnMEParser.serparse(transferObj,acctInfoTo,cusAcctType,custacctInfo,newBal)));
//	
//	return null;
}

//**************************Account Statement***************************
	@Override
	public List<ServiceProviderTransactionInfoModel> getOnlyCustPaidAccountList(String uci) {
				
		List<ServiceProviderTransactionInfo> recAcctList=(serviceProviderTransactionInfoRepo.findAllByServiceProviderId(uci)).
				stream().filter(distinctByKey(p -> p.getFromCustomerAccount())).collect(Collectors.toList());
				 
		return recAcctList.stream().map(e -> EMnMEParser.serparse(e)).collect(Collectors.toList());
	}
	
	public static <T> Predicate<T> distinctByKey(Function<? super T, Object > keyExtractor)
	{
		Map<Object, Boolean> map = new ConcurrentHashMap<>();
		return t -> map.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE)== null;
	}
	
	@Override
	public List<ServiceProviderTransactionInfoModel> getCustPaidFilteredStatement(AccountStatementDto filterStmtData)  {
		//System.out.println("in filter stmt");
		
		LocalDate startDate = Converters.stringToLocalDate(filterStmtData.getStartDate());
		LocalDate endDate = Converters.stringToLocalDate(filterStmtData.getEndDate());	
		
		List<ServiceProviderTransactionInfo> txnRepoList=serviceProviderTransactionInfoRepo.
				findByFromCustomerAccountAndServiceProviderIdAndTxnDateTimeBetween(filterStmtData.getCustAcctNum(), filterStmtData.getUserName(),
				startDate,endDate);
		List<ServiceProviderTransactionInfoModel> txnObj = txnRepoList.
		stream().map(e -> EMnMEParser.serparse(e)).collect(Collectors.toList());
		return txnObj;			
		
}
	
	@Override
	public List<ServiceProviderTransactionInfoModel> getserviceProviderFilteredStatement(AccountStatementDto filterStmtData)  {
		//System.out.println("in filter stmt");
		
		LocalDate startDate = Converters.stringToLocalDate(filterStmtData.getStartDate());
		LocalDate endDate = Converters.stringToLocalDate(filterStmtData.getEndDate());	
		
		List<ServiceProviderTransactionInfo> txnRepoList=serviceProviderTransactionInfoRepo.
				findByServiceProvideraccountIdAndTxnDateTimeBetween(filterStmtData.getCustAcctNum(),
				startDate,endDate);
		List<ServiceProviderTransactionInfoModel> txnObj = txnRepoList.
		stream().map(e -> EMnMEParser.serparse(e)).collect(Collectors.toList());
		return txnObj;			
		
}





}
