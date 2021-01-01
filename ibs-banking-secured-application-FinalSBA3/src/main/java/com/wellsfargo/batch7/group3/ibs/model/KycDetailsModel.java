package com.wellsfargo.batch7.group3.ibs.model;

import java.util.Date;
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
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;


public class KycDetailsModel {

//	private Long regId;
//	private String firstName;
//	private String lastName;
//	private String gender;
//	@DateTimeFormat(iso=ISO.DATE)
//	private Date dob;
//	private String emailId;
//	private String mobileNum;
//	private String address;
//	private String city;
//	private String pincode;
//	private String typeOfAcctHolder;
//	private String custAcctType;
//	private String kycIdentityProof;
//	private String kycProofDoc; //No need can be removed
//	private String kycUploadInd;
//	private String adminComments;
//	private String kycApproval;
//	@DateTimeFormat(iso=ISO.DATE)
//	private LocalDate createdDt;
	
	private Long regId;
	@NotNull(message="First Name is mandate")
	@NotBlank(message="First Name is mandate")
	private String firstName;
	@NotNull(message="Last Name is mandate")
	@NotBlank(message="Last Name is mandate")
	private String lastName;
	private String gender;
	@NotNull(message = "{KycDetailsModel.dob.notNull}")
	    //@DateTimeFormat(pattern = "dd.MM.yyyy")
	@Past(message = "{KycDetailsModel.dob.past}")
	@DateTimeFormat(iso=ISO.DATE)
	private LocalDate dob;
	@NotNull(message="Mail Id is mandate")
	@NotBlank(message="Mail Id is mandate")
	@Email(message = "Email Id is not valied")@Column(name="email_id",nullable=false)
	private String emailId;

	@Pattern(regexp = "[1-9][0-9]{9}",message = "Mobile number must be exactly ten digits")
	private String mobileNum;
	@NotNull(message="Address number is mandate")
	@NotBlank(message="Address number is mandate")
	private String address;
	@NotNull(message="city  is mandate")
	@NotBlank(message="city is mandate")
	private String city;
	@NotNull(message="pincode  is mandate")
	@NotBlank(message="pincode is mandate")
	private String pincode;
	@NotNull(message="typeOfAcctHolder  is mandate")
	
	private String typeOfAcctHolder;
	private String custAcctType;
	private String servProBankName;
	private String servProBankBranch;
	private Long servProBankAccount;
	private String servProBankIFSC;
	private String serviceProviderName;
	@NotNull(message="kycIdentityProof  is mandate")
	
	private String kycIdentityProof;
	@NotNull(message="kycProofDoc  is mandate")
	@NotBlank(message="kycProofDoc is mandate")
	private String kycProofDoc; 
	private String kycUploadInd;
	private String adminComments;
	private String kycApproval;
	@DateTimeFormat(iso=ISO.DATE)
	private LocalDate createdDt;
	
	private Double amount;
	private Long tenure;
	
	private String branchName;
	private String bankIfsc;
	

	//SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyyHH:mm:SS");
	//Date date= new Date();
	
	public KycDetailsModel() {
		
	}

	

	public KycDetailsModel(Long regId,
			@NotNull(message = "First Name is mandate") @NotBlank(message = "First Name is mandate") String firstName,
			@NotNull(message = "Last Name is mandate") @NotBlank(message = "Last Name is mandate") String lastName,
			String gender,
			@NotNull(message = "{KycDetailsModel.dob.notNull}") @Past(message = "{KycDetailsModel.dob.past}") LocalDate dob,
			@NotNull(message = "Mail Id is mandate") @NotBlank(message = "Mail Id is mandate") @Email(message = "Email Id is not valied") String emailId,
			@Pattern(regexp = "[1-9][0-9]{9}", message = "Mobile number must be exactly ten digits") String mobileNum,
			@NotNull(message = "Address number is mandate") @NotBlank(message = "Address number is mandate") String address,
			@NotNull(message = "city  is mandate") @NotBlank(message = "city is mandate") String city,
			@NotNull(message = "pincode  is mandate") @NotBlank(message = "pincode is mandate") String pincode,
			String typeOfAcctHolder, String custAcctType, String servProBankName, String servProBankBranch,
			Long servProBankAccount, String servProBankIFSC, String serviceProviderName, String kycIdentityProof,
			String kycProofDoc, String kycUploadInd, String adminComments, String kycApproval, LocalDate createdDt,
			Double amount, Long tenure, String branchName, String bankIfsc) {
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
		this.servProBankName = servProBankName;
		this.servProBankBranch = servProBankBranch;
		this.servProBankAccount = servProBankAccount;
		this.servProBankIFSC = servProBankIFSC;
		this.serviceProviderName = serviceProviderName;
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


	public String getKycIdentityProof() {
		return kycIdentityProof;
	}


	public void setKycIdentityProof(String kycIdentityProof) {
		this.kycIdentityProof = kycIdentityProof;
	}


	public  String getKycProofDoc() {
		return kycProofDoc;
	}


	public void setKycProofDoc( String kycProofDoc) {
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





	public String getServiceProviderName() {
		return serviceProviderName;
	}



	public void setServiceProviderName(String serviceProviderName) {
		this.serviceProviderName = serviceProviderName;
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



	@Override
	public String toString() {
		return "KycDetailsModel [regId=" + regId + ", firstName=" + firstName + ", lastName=" + lastName + ", gender="
				+ gender + ", dob=" + dob + ", emailId=" + emailId + ", mobileNum=" + mobileNum + ", address=" + address
				+ ", city=" + city + ", pincode=" + pincode + ", typeOfAcctHolder=" + typeOfAcctHolder
				+ ", custAcctType=" + custAcctType + ", kycIdentityProof=" + kycIdentityProof + ", kycProofDoc="
				+ kycProofDoc + ", kycUploadInd=" + kycUploadInd + ", adminComments=" + adminComments + ", kycApproval="
				+ kycApproval + ", createdDt=" + createdDt + "]";
	}
	
	

}