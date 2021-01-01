<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import = "java.io.*,java.util.*, javax.servlet.*" %>
<html>
    <head>
        <title>IBS Bank-Account Summary</title>
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
		 
    </head>
   <body>
	<h1><img src="${pageContext.request.contextPath}/resources/BankLogo.jpg" width="60" height=60 /> IBS Bank </h1>		
	<h2>Welcome ${uci } !!<img src="${pageContext.request.contextPath}/resources/BankHeaderLogo.gif" width="70" height=70 /></h2> 
	<%         Date date = new Date();        out.print( "<h5 align = \"right\">" +date.toString()+"</h5>");      %>		
	
	
			<jsp:include page="/header"/>	 
	
                    	
                        <h2><font color="brown">Bill Payment</font></h2>
                        <br></br>
						
<form:form action="/customerLogin/billPaymt?uci=${uci}" method="POST" modelAttribute="billPymt" class="form">

		<table border="0" cellspacing="0" cellpadding="0" width="40%" >
			<c:choose>
			<c:when test="${fromCustAcctNum==null || fromCustAcctNum.isEmpty() }">
					<div class="alert alert-info">
						<strong>No Saving Account  available for bill payment</strong>
					</div>
				</c:when>
			<c:otherwise>			
				
				<tr><td><strong>From Account</strong></td> 			
				<td><select name="fromAcctNum">
	   				 <c:forEach items="${fromCustAcctNum }" var="c">
	        			<%-- <option value="${c.bnfcryId}">${c.bnfcryAcctNum}  ${c.bnfcryAcctName} </option>--%>
	        			<option value="${c.customerAcctNum }"> ${c.customerAcctNum } </option>
	    			</c:forEach>
				</select></td>
				</tr>
				
			<tr><td><strong>To ServiceProvider&nbsp;</strong></td> 
			<td><select name="toAcctNum">
   				 <c:forEach items="${servProviderList }" var="c">
        			<%-- <option value="${c.bnfcryId}">${c.bnfcryAcctNum}  ${c.bnfcryAcctName} </option>--%>
        			<option value="${c.accountId}">${c.serviceProviderId } ${c.serviceProviderName} </option>
    			</c:forEach>
			</select></td>
			</tr>
			<tr><td><strong>BillPayment Mode</strong>
				<td><select name="txnMode">
				<option  value="IMPS">IMPS</option>
				<option value="NEFT">NEFT</option>
				</select>
			</td> 
			
			<tr><td><strong>Bill Amount</strong></td> 
			<td><em><input type="number" name="txnAmt" min="1" max="500000" step="1" required/></em></td>
			</tr>
			<tr><td><strong>Comments</strong></td> 
			<td><em><input type="text" name="txnCmnts" required /></em></td>
			</tr>
			<tr align="right"><td><button>Submit</button></td> 
			<td><em></em></td>
			</tr>
			</c:otherwise>
			</c:choose>
		</table>
	</form:form>	
		<c:if test="${message !=null}">
					<div align ="centre" id="status message"><b>${message}</b></div>
					</c:if>
					<div id="footer">
          <footer>Copyright&copy;2020 IBS Bank.com. All rights reserved | Designed by Batch-7 Group3</footer>
          </div>
    </body>
</html>