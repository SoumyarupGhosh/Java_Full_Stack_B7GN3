<%@ page import = "java.io.*,java.util.*, javax.servlet.*" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>IBS Bank-Open Transfer</title>
   	 		 <link rel="stylesheet" href="/css/site.css"/>
		 <link rel="stylesheet" href="/css/IBS-Styling.css"/>
		 <style> 
     	 body{
		 		 background-image: url('${pageContext.request.contextPath}/resources/BankLogoGIf.gif');
		 		 background-repeat: no-repeat;
		 		 background-size:100% 100%;
		 		 background-blend-mode:soft-light;
		 	}
		</style> 
   	 		<script type="text/javascript">

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
			   	 	
   	 		</script>
    </head>
   <body>
	<h1><img src="${pageContext.request.contextPath}/resources/BankLogo.jpg" width="60" height=60 /> IBS Bank </h1>		
	<h2>Welcome ${uci } !!<img src="${pageContext.request.contextPath}/resources/BankHeaderLogo.gif" width="70" height=70 /></h2> 
	<%         Date date = new Date();        out.print( "<h5 align = \"right\">" +date.toString()+"</h5>");      %>		
	
	
			<jsp:include page="/header"/>	 
	
                    	
                        <h2><font color="brown">Open New Account</font></h2>
                        <br></br> 
                                              
      <form:form action="/customerLogin/openNewAccunt?uci=${uci}" method="POST" modelAttribute="openNewAcct" class="form-inline">
      			<h5 style="margin-left:10px">****Note: FD Tenure is in Months | RD Tenure is in Quarters****</h5>
      			<br></br>				
			BranchName:
					<form:select  path="branchName"   required="required" >
						<c:forEach var="c" items="${branchList }">
							 <form:option  value="${c }">${c }</form:option>							
							 </c:forEach>						
					</form:select>	
					<form:errors path="branchName"/>															
			
			<br></br>
			CustomerAccountType:	
				SavingAccount<form:radiobutton onclick="account();"  path="custAcctType" value="Saving Account"  id="SavingAccount"/>				
					FixedAccount<form:radiobutton onclick="account();" path="custAcctType" value="Fixed Deposit" id="FixedAccount"   />
					RecurringAccount<form:radiobutton onclick="account();" path="custAcctType" value="Recurring Deposit" id="RecurringAccount"   />															
			<br></br>									
			<p  id="ifAmtBranch" style="display:none"> 					
					Amount: <form:input  path="availableBalance"   type="number"  class="form-control mr-2" placeholder="Enter Amount"/>																				
			</p>
			
				
					<p  id="ifTenure" style="display:none"> 					
					Tenure 
					<form:select  path="tenure" >
						<c:forEach var="c" items="${tenureFixed }">
							 <form:option  value="${c }" >${c }</form:option>							
							 </c:forEach>						
					</form:select>							
					</p>
					
			<input value="Submit" type="submit" />
	
	</form:form>
	<c:if test="${message !=null}">
					<div style="text-align:centre;margin-left:650px" id="status message"><b>${message}</b></div>
					</c:if>	

	<div id="footer">
         <footer>Copyright&copy;2020 IBS Bank.com. All rights reserved | Designed by Batch-7 Group3</footer>
         </div>
    </body>
</html>