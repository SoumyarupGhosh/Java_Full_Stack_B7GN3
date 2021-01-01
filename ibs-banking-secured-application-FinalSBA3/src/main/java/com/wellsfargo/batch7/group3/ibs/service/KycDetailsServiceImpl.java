package com.wellsfargo.batch7.group3.ibs.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.wellsfargo.batch7.group3.ibs.entities.CustomerAccount;

import com.wellsfargo.batch7.group3.ibs.entities.CustomerAccountTypesInfo;
import com.wellsfargo.batch7.group3.ibs.entities.CustomerTransactions;
import com.wellsfargo.batch7.group3.ibs.entities.KycDetails;
import com.wellsfargo.batch7.group3.ibs.entities.LoginInfo;
import com.wellsfargo.batch7.group3.ibs.entities.ServiceProviderAccount;
import com.wellsfargo.batch7.group3.ibs.exception.IBSExceptionHandler;
import com.wellsfargo.batch7.group3.ibs.model.AccountStatementDto;
import com.wellsfargo.batch7.group3.ibs.model.CustomerAccountTypesInfoDto;
import com.wellsfargo.batch7.group3.ibs.model.CustomerBeneficiaryDto;
import com.wellsfargo.batch7.group3.ibs.model.CustomerNewPasswordModel;
import com.wellsfargo.batch7.group3.ibs.model.CustomerTransactionsDto;
import com.wellsfargo.batch7.group3.ibs.model.KycDetailsModel;
import com.wellsfargo.batch7.group3.ibs.model.ServiceProviderAccountModel;
import com.wellsfargo.batch7.group3.ibs.repo.CustomerAccountTypesInfoRepo;
import com.wellsfargo.batch7.group3.ibs.repo.CustomerBeneficiaryRepository;
import com.wellsfargo.batch7.group3.ibs.repo.CustomerRepository;
import com.wellsfargo.batch7.group3.ibs.repo.KycDetailsRepo;
import com.wellsfargo.batch7.group3.ibs.repo.LoginInfoRepo;
import com.wellsfargo.batch7.group3.ibs.repo.ServiceProviderAccountRepo;
import com.wellsfargo.batch7.group3.ibs.util.Converters;
import com.wellsfargo.batch7.group3.ibs.util.CreateNewAccountsUtils;
import com.wellsfargo.batch7.group3.ibs.util.EMnMEParser;
import com.wellsfargo.batch7.group3.ibs.util.EMnMEParserCust;
import com.wellsfargo.batch7.group3.ibs.util.GeneraterRandomNumber;
import com.wellsfargo.batch7.group3.ibs.util.LoadPropertiesFile;


@Service
public class KycDetailsServiceImpl  implements IKycDetailsService{
	
	
	@Autowired
	private KycDetailsRepo kycRepo;
	
	@Autowired
	//private CustomerAccountRepo customerAccountRepo;
	private CustomerRepository customerAccountRepo;
	
	@Autowired
	//private CustomerAccountRepo customerAccountRepo;
	private CustomerAccountTypesInfoRepo customerAccountTypesInfoRepo;
	
	@Autowired
	private ServiceProviderAccountRepo serviceProviderAccountRepo;
	
	@Autowired
	private LoginInfoRepo loginInfoRepo;
	
	@Autowired
	private CustomerBeneficiaryRepository customerBeneficiaryRepo;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Transactional
	@Override
	public KycDetailsModel add(KycDetailsModel kycDetailModel) throws IBSExceptionHandler {
		// TODO Auto-generated method stub	
		
		if(kycDetailModel!= null)
		{
			if((kycRepo.existsByMobileNum(kycDetailModel.getMobileNum())) || (kycRepo.existsByEmailId(kycDetailModel.getEmailId())))
			{
				throw new IBSExceptionHandler("Requester mobile or EmailId already exists.Please try Again with correct data." );
			}
			else if(kycDetailModel.getTypeOfAcctHolder().equals("Customer")) 
			{	
				if(kycDetailModel.getCustAcctType()!=null)
				{
					if(kycDetailModel.getCustAcctType().equals("Fixed Deposit") || kycDetailModel.getCustAcctType().equals("Recurring Deposit"))
					{
						if(kycDetailModel.getAmount()==null || kycDetailModel.getBranchName()==null || kycDetailModel.getTenure()==null)
						{
							throw new IBSExceptionHandler("ERR : Fields Amount, BranchName or Tenure cannot be empty for Customer." );
						}
						else if(kycDetailModel.getCustAcctType().equals("Fixed Deposit") && kycDetailModel.getAmount() < LoadPropertiesFile.getAmount("MinFDAmount"))
						{
							throw new IBSExceptionHandler("ERR : Minimum FD Amount is " +  LoadPropertiesFile.getAmount("MinFDAmount") );
						}
						else if(kycDetailModel.getCustAcctType().equals("Recurring Deposit") && kycDetailModel.getAmount() < LoadPropertiesFile.getAmount("MinRDAmount"))
						{
							throw new IBSExceptionHandler("ERR : Minimum RD Amount is " +   LoadPropertiesFile.getAmount("MinRDAmount") );
						}
						else
						{
							System.out.println("SUCCESS: PROCEED");
						}
					}
					
					if(kycDetailModel.getCustAcctType().equals("Saving Account")) 
					{				
						if(kycDetailModel.getAmount()==null || kycDetailModel.getBranchName()==null )
						{
							throw new IBSExceptionHandler("ERR : Fields Amount or BranchName  cannot be empty for Customer." );
						}
						else if(kycDetailModel.getAmount() < 0)
						{
							throw new IBSExceptionHandler("ERR : Minimum Saving Amount is " +   LoadPropertiesFile.getAmount("MinSAmount") );
						}
						else
						{
							System.out.println("SUCCESS: PROCEED");
						}
						
					}
				}
				else {
					throw new IBSExceptionHandler("ERR : AccountType cannot be null cannot be empty for Customer." );
				}
			}
			else if(kycDetailModel.getTypeOfAcctHolder().equals("ServiceProvider")) 
			{
				if(kycDetailModel.getServiceProviderName()==null || kycDetailModel.getServProBankAccount()==null ||
						kycDetailModel.getServProBankBranch()==null || kycDetailModel.getServProBankIFSC()==null ||
						kycDetailModel.getServProBankName()==null)
				{
					throw new IBSExceptionHandler("ERR : Fields ServiceProviderName, ServProBankAccount , ServProBankBranch "
							+ "ServProBankBranch or ServProBankName cannot be empty for ServiceProvider." );
				}
				
			}
			else {		
			}
			
			kycDetailModel.setKycApproval("Pending");
			kycDetailModel = EMnMEParser.parse(kycRepo.save(EMnMEParser.parse(kycDetailModel)));			
		}					
		return kycDetailModel;
	}

	@Override
	public KycDetailsModel get(Long regId) throws IBSExceptionHandler {
		// TODO Auto-generated method stub
		
		if(!kycRepo.existsById(regId) ) {
			throw new IBSExceptionHandler("ReGID#"+regId+" does not exists");
		}
		return EMnMEParser.parse(kycRepo.findById(regId).get());
	}

	@Override
	public List<KycDetailsModel> getAll() throws IBSExceptionHandler {
		// TODO Auto-generated method stub
		return kycRepo.findAll().stream().map(e -> EMnMEParser.parse(e)).collect(Collectors.toList());
	}

	@Override
	public KycDetailsModel getbyMobileNum(String mobileNum) throws IBSExceptionHandler {
		// TODO Auto-generated method stub
		if(!kycRepo.existsByMobileNum(mobileNum) )
				{
			throw new IBSExceptionHandler("MobileNum#"+mobileNum+" does not exists");
		}
		return EMnMEParser.parse(kycRepo.findByMobileNum(mobileNum));
	}
	
	@Override
	public List<KycDetailsModel> getAllPending() throws IBSExceptionHandler {
		// TODO Auto-generated method stub
		if( kycRepo.existsByKycApproval("Pending"))
		{
		return kycRepo.findAllByKycApproval("Pending").stream().map(e -> EMnMEParser.parse(e)).collect(Collectors.toList());
		}
		return null;
	}

	@Override
	public KycDetailsModel  updateReject(Long regId) throws IBSExceptionHandler {
		if(regId!= null)
		{
			 if(kycRepo.existsById(regId))
			{
				KycDetails kycDetails=kycRepo.findByRegId(regId);
				kycDetails.setKycApproval("Rejected");
				kycRepo.save(kycDetails);				
			}
			else
			{
				throw new IBSExceptionHandler("Requester's Id does not exists." );
			}
		}
		return EMnMEParser.parse(kycRepo.findByRegId(regId));					
		
	}
	

	@Override
	public KycDetailsModel  updateAccept(Long regId) throws IBSExceptionHandler {
		CustomerAccount customerAccounts=null;
		CustomerAccountTypesInfo customerAccountsTypesInfo=null;
		ServiceProviderAccount serviceProviderAccount=new ServiceProviderAccount();
		LoginInfo loginInfo=new LoginInfo();
		if(regId!= null)
		{
			 if(kycRepo.existsByRegId(regId))
			{
								
				KycDetails kycDetails=kycRepo.findByRegId(regId);				
				System.out.println("Type of Account holder "+ kycDetails.getTypeOfAcctHolder() );
					if(kycDetails.getTypeOfAcctHolder().equals("Customer"))
					{
					
					customerAccounts=CreateNewAccountsUtils.parse(kycDetails);
					customerAccounts.setPassword(encoder.encode(customerAccounts.getPassword()));					
//					customerAccountsTypesInfo=CreateNewAccountsUtils.parse(kycDetails, customerAccounts.getCustAcctNum(),customerAccounts.getUci());
					customerAccountsTypesInfo=CreateNewAccountsUtils.parse(kycDetails, customerAccounts.getUci());
					customerAccountTypesInfoRepo.save(customerAccountsTypesInfo);					
					customerAccountRepo.save(customerAccounts);							
					
					}
						if(kycDetails.getTypeOfAcctHolder().equals("ServiceProvider"))
						{
							serviceProviderAccount=CreateNewAccountsUtils.parse(kycDetails, "ServiceProvider","Y" );
							serviceProviderAccount.setPassword(encoder.encode(serviceProviderAccount.getPassword()));
							serviceProviderAccountRepo.save(serviceProviderAccount);
						}
						
						kycDetails.setKycApproval("Accepted");
						kycRepo.save(kycDetails);
			}
			else
			{
				throw new IBSExceptionHandler("Requester's Id does not exists" );
			}
		}
		return EMnMEParser.parse(kycRepo.findByRegId(regId));					
		
	}
	
	
	@Override
	public KycDetailsModel  updateAdminComments(String comments, Long regId) throws IBSExceptionHandler {
		if(regId!= null)
		{
			 if(kycRepo.existsById(regId))
			{
				KycDetails kycDetails=kycRepo.findByRegId(regId);
				kycDetails.setAdminComments(comments);
				kycRepo.save(kycDetails);				
			}
			else
			{
				throw new IBSExceptionHandler("Requester's Id does not exists." );
			}
		}
		return EMnMEParser.parse(kycRepo.findByRegId(regId));					
		
	}
	
	
	public List<CustomerAccountTypesInfoDto> getAllSavRecAccountList() {
		
		List<CustomerAccountTypesInfo> allRecSavList = new ArrayList<CustomerAccountTypesInfo>();
		List<CustomerAccountTypesInfo> recAcctList=(customerAccountTypesInfoRepo.findAllByCustAcctType("Recurring Deposit")).stream()
				.collect(Collectors.toList());
		List<CustomerAccountTypesInfo> savAcctList=(customerAccountTypesInfoRepo.findAllByCustAcctType("Saving Account")).stream().
				collect(Collectors.toList());
		allRecSavList.addAll(recAcctList);
		allRecSavList.addAll(savAcctList);		
		
		return allRecSavList.stream().map(e -> EMnMEParserCust.custDataParse(e)).collect(Collectors.toList());
	}
	
	public List<CustomerAccountTypesInfoDto> getAllFundAccountList() {
		
		List<CustomerAccountTypesInfo> allRecSavList = new ArrayList<CustomerAccountTypesInfo>();
		List<CustomerAccountTypesInfo> recAcctList=(customerAccountTypesInfoRepo.findAllByCustAcctType("Recurring Deposit")).stream()
				.collect(Collectors.toList());
		List<CustomerAccountTypesInfo> savAcctList=(customerAccountTypesInfoRepo.findAllByCustAcctType("Fixed Deposit")).stream().
				collect(Collectors.toList());
		allRecSavList.addAll(recAcctList);
		allRecSavList.addAll(savAcctList);		
		
		return allRecSavList.stream().map(e -> EMnMEParserCust.custDataParse(e)).collect(Collectors.toList());
	}
	
	public List<ServiceProviderAccountModel> getAllSerProAccountList() {		
		List<ServiceProviderAccount> servAcctList=(serviceProviderAccountRepo.findAll()).stream().
				collect(Collectors.toList());		
		return servAcctList.stream().map(e -> EMnMEParser.serparse(e)).collect(Collectors.toList());
	}

	
	
	

	

}


