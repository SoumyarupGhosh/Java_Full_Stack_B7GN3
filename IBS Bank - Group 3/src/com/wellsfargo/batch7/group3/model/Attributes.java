package com.wellsfargo.batch7.group3.model;

public class Attributes {
	
	public static final String GET_ACCT_BALANCE = "select AVLBL_BAL from CUST_ACCT where CUST_ACCT_NUM = ?";
	public static final String GET_MAX_KYC_REG_ID = "select max(REG_ID) from KYC_DETAIL";

	public static final String INS_KYC_DETAILS = "INSERT INTO KYC_DETAILS \r\n"
			+ "	(REG_ID,FIRST_NAME,LAST_NAME,GENDER,DOB,EMAIL_ID,MOBILE_NUM,ADDRESS,CITY,PINCODE,TYPE_OF_ACCT_HOLDER,CUST_ACCT_TYPE,KYC_IDENTITY_PROOF,\r\n"
			+ "			KYC_PROOF_DOC,KYC_UPLOAD_IND,ADMIN_COMMENTS_KYC,KYC_APPROVAL_STATUS,CREATED_DT,MODIFIED_DT) VALUES \r\n"
			+ "	(?,?,?,?,?,?,?,?,?,?,?,?,?,\r\n"
			+ "			\"Doc1.jpeg\",\"Y\",null,\"Open\",CURDATE(),CURDATE());";
	
//	INSERT INTO KYC_DETAILS 
//	(REG_ID,FIRST_NAME,LAST_NAME,GENDER,DOB,EMAIL_ID,MOBILE_NUM,ADDRESS,CITY,PINCODE,TYPE_OF_ACCT_HOLDER,CUST_ACCT_TYPE,KYC_IDENTITY_PROOF,
//			KYC_PROOF_DOC,KYC_UPLOAD_IND,ADMIN_COMMENTS_KYC,KYC_APPROVAL_STATUS,CREATED_DT,MODIFIED_DT) VALUES 
//	('123',"TOM","CRUISE",'M','1999-01-01',"ABC@GMAIL.COM",'1238968989',"Hyderabad","Hyderabad",'500001',"Customer","Savings Account","PAN Card",
//			"Doc1.jpeg","Y",null,"Open",CURDATE(),CURDATE());
}
