 <%@page import="java.time.LocalDate" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import = "java.io.*,java.util.*, javax.servlet.*" %>
<html>
	<head>
		  <link rel="stylesheet" href="/css/site.css"/>
		 <link rel="stylesheet" href="/css/IBS-Styling.css"/>
		 <link rel="stylesheet" href="/css/registrationForm.css"/>
		 <style>
		 body{
		 		 background-image: url('${pageContext.request.contextPath}/resources/BankLogo.jpg');
		 		 background-repeat: no-repeat;
		 		 background-size:100% 100%;
		 		 background-blend-mode:soft-light;
		 	}
		 </style>
	
	 	<title>Register</title>
	<script type="text/javascript">
				function typOfAcctChk() {
									
				    if (document.getElementById('customer').checked) 
				    	{
				        	document.getElementById('ifCustomer').style.display = 'block';						        
					   } 
					  else {
								 document.getElementById('ifCustomer').style.display = 'none';
					}
				    
				    if(document.getElementById('serviceProvider').checked)
				    	{
				    	 document.getElementById('ifserviceProvider').style.display = 'block';
				    	 document.getElementById('ifTenureFixed').style.display = 'none';
				    	 document.getElementById('ifTenure').style.display = 'none';
				    	 document.getElementById('ifAmtBranch').style.display = 'none';
				    	}
					    else {
					        document.getElementById('ifserviceProvider').style.display = 'none';
					  		 }
				}
				
				function account()
				{					
					var ids =['ifTenure','ifAmtBranch'];	
					var ids1=['ifAmtBranch'];	
						
					    if (document.getElementById('FixedAccount').checked || document.getElementById('RecurringAccount').checked) 
				        {						        							        	
					        	for (var i=0; i<= ids.length ; i++)
					        	{
						        	document.getElementById(ids[i]).style.display = 'block';
						        }
				        }else if(document.getElementById('SavingAccount').checked) 						 
						 {							 
					    	 for (var i=0; i<= ids.length ; i++)
					        	{
						        	document.getElementById(ids1[i]).style.display = 'block';
						        	document.getElementById('ifTenure').style.display = 'none'						        	
						        }							
						 }
					     else
						{							    	
					        	for (var i=0; i<= ids.length ; i++)
					        	{
						        	document.getElementById(ids[i]).style.display = 'none';								        	
						        }								        
						}
										    					    
					    				    
				}
				if ( window.history.replaceState ) {
			        window.history.replaceState( null, null, window.location.href );
			    }
</script>
	</head>
<body>
		<h1><img src="${pageContext.request.contextPath}/resources/BankLogo.jpg" width="60" height=60 /> IBS Bank </h1>		
	<%         Date date = new Date();        out.print( "<h5 align = \"right\">" +date.toString()+"</h5>");      %>
	<hr></hr>
	<jsp:include page="homeMenu.jsp"/>
	<hr></hr>
	
			<font color="brown"><h2>New Application</h2></font>	
			<br>/<br>
					
					<c:if test="${message !=null}">
					<div style="text-align:centre;margin-left:450px" id="status message"><b>${message}</b></div>
					</c:if>	
							
					<form:form action="/registrationForm/register" method="POST" modelAttribute="newUserKyc" class="form-inline">
									
					<h5 style="margin-left:10px">****Note: FD Tenure is in Months | RD Tenure is in Quarters****</h5>
					
								
					<label>FirstName</label>
					<form:input path="firstName" type="text" class="form-control mr-2" placeholder="Enter FirstName"/><form:errors path="firstName"/>
					<br></br>
					<label>LastName</label>
					<form:input path="lastName" type="text" 	class="form-control mr-2" placeholder=" Enter LastName"/>
					<form:errors path="lastName"/>
					<br></br>
					<label>DateOfBirth</label><form:input path="dob" type="date" 	class="form-control mr-2" />
					<form:errors path="dob"/>
					<br></br>					
					<label>Gender</label>
					Male<form:radiobutton path="gender" value="Male"  class="form-control mr-2" />
					Female<form:radiobutton path="gender" value="Female"  class="form-control mr-2"/>
					<form:errors path="gender"/>
					<br></br>
					<label>EmailId</label>
					<form:input path="emailId" type="text" class="form-control mr-2" placeholder="Enter EmailId"/>
					<form:errors path="emailId"/>
					<br></br>
					<label>MobileNo.</label>
					<form:input path="mobileNum" type="text" 	class="form-control mr-2" placeholder="Enter MobileNum"/>
					<form:errors path="mobileNum"/>
					<br></br>
					<label>Address</label>
					<form:input path="address" type="text" class="form-control mr-2" placeholder="Enter Address"/>
					<form:errors path="address"/>
					<br></br>
					<label>City</label>
					<form:input path="city" type="text" 	class="form-control mr-2" placeholder="Enter City"/>
					<form:errors path="city"/>
					<br></br>	
					<label>PinCode</label>
					<form:input path="pincode" type="number" 	class="form-control mr-2" placeholder="Enter Pincode"/>
					<form:errors path="pincode"/>
					<br></br>
					
					
					<label>TypeOfAcctHolder:</label>
					Customer<form:radiobutton  onclick="typOfAcctChk();" path="typeOfAcctHolder" value="Customer" id="customer" class="form-control mr-2" />
					ServiceProvider<form:radiobutton onclick="typOfAcctChk();"  path="typeOfAcctHolder" value="ServiceProvider" id="serviceProvider" class="form-control mr-2" />
					<form:errors path="typeOfAcctHolder"/>
					<br></br>
					
					<p  id="ifCustomer" style="display:none">
					<label>CustomerAcctType: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
					SavingAccount<form:radiobutton onclick="account();"  path="custAcctType" value="Saving Account"  id="SavingAccount"  class="form-control mr-2"/>
					FixedAccount<form:radiobutton onclick="account();" path="custAcctType" value="Fixed Deposit" id="FixedAccount" class="form-control mr-2"  />
					RecurringAccount<form:radiobutton onclick="account();" path="custAcctType" value="Recurring Deposit" id="RecurringAccount" class="form-control mr-2"  />															
					<form:errors path="custAcctType"/>
					</p>	
												
					<p  id="ifAmtBranch" style="display:none"> 					
					Amount: <form:input  path="amount"   type="number"  class="form-control mr-2" placeholder="Enter Amount"/>
					BranchName:
					<form:select  path="branchName"   required="required" >
						<c:forEach var="c" items="${branchList }">
							 <form:option  value="${c }">${c }</form:option>							
							 </c:forEach>						
					</form:select>	
					<form:errors path="branchName"/>															
					</p>
					
					<p  id="ifTenure" style="display:none"> 					
					Tenure 
					<form:select  path="tenure" >
						<c:forEach var="c" items="${tenureFixed }">
							 <form:option  value="${c }" >${c }</form:option>							
							 </c:forEach>						
					</form:select>							
					</p>
					
					
						
															
					<p  id="ifserviceProvider" style="display:none">
					SPName<form:input path="serviceProviderName" type="text" 	class="form-control mr-2" placeholder="Enter serviceProviderName"/>					
					SPBankName<form:input path="servProBankName" type="text" 	class="form-control mr-2" placeholder="Enter BankName"/>
					SPBankBranch<form:input path="servProBankBranch" type="text" 	class="form-control mr-2" placeholder="Enter BankBranch"/>
					<br></br>
					SPBankAccount<form:input path="servProBankAccount" type="number" 	class="form-control mr-2" placeholder="Enter BankAccountName"/>
					SPBankIFSC<form:input path="servProBankIFSC" type="text" 	class="form-control mr-2" placeholder="Enter BankIFSC"/>
					<form:errors path="serviceProviderName"/>	
					<form:errors path="servProBankName"/>
					<form:errors path="servProBankBranch"/>
					<form:errors path="servProBankAccount"/>
					<form:errors path="servProBankIFSC"/>				
					</p>
					
					<br></br>				
					
					<label>KycIdentityProof:</label>
					<form:select path="kycIdentityProof">
					PanCard<form:option value="PanCard" class="form-control mr-2" />
					AdaharCard<form:option value="AdharCard" class="form-control mr-2" />					
					</form:select>
					<form:errors path="kycIdentityProof"/>
					<br></br>
					
					<label>KycProofDoc:</label>
					<form:input path ="kycProofDoc"  type="file" class="form-control mr-2"/>
					<form:errors path="kycProofDoc"/>					
									
					<br></br>
					<div style="margin-left:150px"><b><input  value="Submit" type="submit"  style="color:brown;"/></b></div>
					
					<br></br>
					
					
					</form:form>
					
									 

	 <div id="footer">
			<footer style="text-align:center;">Copyright&copy;2020 IBS Bank.com. All rights reserved | Designed by Batch-7 Group3</footer>
		</div>
</body>
</html>