package com.wellsfargo.batch7.group3.ibs.entities;

import java.util.Date;
import java.sql.Blob;
import java.sql.Clob;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
//@Table(name="kyc_details")
public class KycDetails {

	
	//@GeneratedValue
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="regId",nullable=false,unique=true)
	private Long regId;
	private String firstName;
	private String lastName;
	private String gender;
	
	private LocalDate dob;
	@Column(name="emailId",nullable=false,unique=true)
	private String emailId;
	@Column(name="mobileNum",nullable=false,unique=true)
	private String mobileNum;
	private String address;
	private String city;
	private String pincode;
	private String typeOfAcctHolder;
	private String custAcctType;
	private String serviceProviderName;
	private String servProBankName;
	private String servProBankBranch;
	private Long servProBankAccount;
	private String servProBankIFSC;	
	private String kycIdentityProof;
	private String kycProofDoc;
	private String kycUploadInd;
	private String adminComments;
	private String kycApproval;
	private LocalDate createdDt;
	
	private Double amount;
	private Long tenure;
	
	private String branchName;
	private String bankIfsc;
	

	//SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyyHH:mm:SS");
	//Date date= new Date();
	
	public KycDetails() {
		
	}


	public KycDetails(Long regId, String firstName, String lastName, String gender, LocalDate dob, String emailId,
			String mobileNum, String address, String city, String pincode, String typeOfAcctHolder, String custAcctType,
			String serviceProviderName, String servProBankName, String servProBankBranch, Long servProBankAccount,
			String servProBankIFSC, String kycIdentityProof, String kycProofDoc, String kycUploadInd,
			String adminComments, String kycApproval, LocalDate createdDt, Double amount, Long tenure,String branchName, String bankIfsc) {
		super();
		this.regId = regId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.dob = dob;
		this.emailId = emailId;
		this.mobileNum = mobileNum;
		this.address = address;
		this.city = city;
		this.pincode = pincode;
		this.typeOfAcctHolder = typeOfAcctHolder;
		this.custAcctType = custAcctType;
		this.serviceProviderName = serviceProviderName;
		this.servProBankName = servProBankName;
		this.servProBankBranch = servProBankBranch;
		this.servProBankAccount = servProBankAccount;
		this.servProBankIFSC = servProBankIFSC;
		this.kycIdentityProof = kycIdentityProof;
		this.kycProofDoc = kycProofDoc;
		this.kycUploadInd = kycUploadInd;
		this.adminComments = adminComments;
		this.kycApproval = kycApproval;
		this.createdDt = createdDt;
		this.amount = amount;
		this.tenure = tenure;
		this.bankIfsc=bankIfsc;
		this.branchName=branchName;
		
	}
	
	


	public String getBranchName() {
		return branchName;
	}


	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}


	public String getBankIfsc() {
		return bankIfsc;
	}


	public void setBankIfsc(String bankIfsc) {
		this.bankIfsc = bankIfsc;
	}


	public Long getRegId() {
		return regId;
	}


	public void setRegId(Long regId) {
		this.regId = regId;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public LocalDate getDob() {
		return dob;
	}


	public void setDob(LocalDate dob) {
		this.dob = dob;
	}


	public String getEmailId() {
		return emailId;
	}


	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}


	public String getMobileNum() {
		return mobileNum;
	}


	public void setMobileNum(String mobileNum) {
		this.mobileNum = mobileNum;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getPincode() {
		return pincode;
	}


	public void setPincode(String pincode) {
		this.pincode = pincode;
	}


	public String getTypeOfAcctHolder() {
		return typeOfAcctHolder;
	}


	public void setTypeOfAcctHolder(String typeOfAcctHolder) {
		this.typeOfAcctHolder = typeOfAcctHolder;
	}


	public String getCustAcctType() {
		return custAcctType;
	}


	public void setCustAcctType(String custAcctType) {
		this.custAcctType = custAcctType;
	}


	public String getServiceProviderName() {
		return serviceProviderName;
	}


	public void setServiceProviderName(String serviceProviderName) {
		this.serviceProviderName = serviceProviderName;
	}


	public String getServProBankName() {
		return servProBankName;
	}


	public void setServProBankName(String servProBankName) {
		this.servProBankName = servProBankName;
	}


	public String getServProBankBranch() {
		return servProBankBranch;
	}


	public void setServProBankBranch(String servProBankBranch) {
		this.servProBankBranch = servProBankBranch;
	}


	public Long getServProBankAccount() {
		return servProBankAccount;
	}


	public void setServProBankAccount(Long servProBankAccount) {
		this.servProBankAccount = servProBankAccount;
	}


	public String getServProBankIFSC() {
		return servProBankIFSC;
	}


	public void setServProBankIFSC(String servProBankIFSC) {
		this.servProBankIFSC = servProBankIFSC;
	}


	public String getKycIdentityProof() {
		return kycIdentityProof;
	}


	public void setKycIdentityProof(String kycIdentityProof) {
		this.kycIdentityProof = kycIdentityProof;
	}


	public String getKycProofDoc() {
		return kycProofDoc;
	}
	public void setKycProofDoc(String kycProofDoc) {
		this.kycProofDoc = kycProofDoc;
	}
	public String getKycUploadInd() {
		return kycUploadInd;
	}
	public void setKycUploadInd(String kycUploadInd) {
		this.kycUploadInd = kycUploadInd;
	}
	public String getAdminComments() {
		return adminComments;
	}
	public void setAdminComments(String adminComments) {
		this.adminComments = adminComments;
	}
	public String getKycApproval() {
		return kycApproval;
	}
	public void setKycApproval(String kycApproval) {
		this.kycApproval = kycApproval;
	}
	public LocalDate getCreatedDt() {
		return createdDt;
	}
	public void setCreatedDt(LocalDate createdDt) {
		this.createdDt = createdDt;
	}
	
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Long getTenure() {
		return tenure;
	}
	public void setTenure(Long tenure) {
		this.tenure = tenure;
	}
}