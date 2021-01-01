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
	
                    	
                        <h2><font color="brown">Add Beneficiary</font></h2>
                        <br></br>
                        <h4><a href="/customerLogin/fundsTransferHome?uci=${uci}">View List Of Beneficiaries</a> <span> | </span>
                        <span><a href="/customerLogin/transferFunds?uci=${uci}">Transfer Funds</a></span></h4>
                        <br></br>
      <form:form action="/customerLogin/addBnfcry?uci=${uci }" method="POST" modelAttribute="addBnf" class="form">
			<table  style="border-collapse:collapse">
			
		<c:choose>
			<c:when test="${savAcctList==null || savAcctList.isEmpty() }">
					<div class="alert alert-info">
						<strong>No Saving Account  available to add Beneficiary</strong>
					</div>
				</c:when>
			<c:otherwise>
			<tr><td><strong>CustomerAccount # </strong></td> 
			<td><select name="custAcctNum">
   				 <c:forEach items="${savAcctList }" var="c">
        			<%-- <option value="${c.bnfcryId}">${c.bnfcryAcctNum}  ${c.bnfcryAcctName} </option>--%>
        			<option value="${c.customerAcctNum }"> ${c.customerAcctNum } </option>
    			</c:forEach>
			</select></td>
			</tr>
			<tr><td><strong>Beneficiary Acct Num# </strong></td> 
			<td><input type="number" name="bnfcryAcctNum" required /></td>
			</tr>
			<tr><td><strong>Beneficiary Name </strong></td> 
			<td><em><input type="text" name="bnfcryAcctName" required /></em></td>
			</tr>
			<tr><td><strong>Beneficiary Bank</strong></td> 
			<td><em><input type="text" name="bnfcryBankName" required /></em></td>
			</tr>
			<tr><td><strong>Beneficiary IFSC</strong></td> 
			<td><em><input type="text" name="bnfcryBankIfsc" required /></em></td>
			</tr>
			<tr><td><strong>Beneficiary Mobile #</strong></td> 
			<td><em><input type="text" name="bnfcryMblNum" required /></em></td>
			</tr>
			<tr><td align="center"><button>Add</button></td> 
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