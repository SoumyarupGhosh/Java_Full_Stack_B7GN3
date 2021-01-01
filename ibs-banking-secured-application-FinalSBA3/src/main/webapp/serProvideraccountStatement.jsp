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
	<h2>Welcome ${uci } !!<img src="${pageContext.request.contextPath}/resources/BankHeaderLogo.gif" width="70" height=70 /> 
	<%         Date date = new Date();        out.print( "<h5 align = \"right\">" +date.toString()+"</h5>");      %>		
	
	
			<jsp:include page="/header"/>	 
	
                    	
                        <h2><font color="brown">Payment Received</font></h2>
                        <br></br>          
                          
                      
                   <!--  <td width="1100" height="80" bgcolor="#FAF8CC">--> 
              	<form:form action="/serviceProviderLogin/filterStmt?uci=${uci}" method="GET" modelAttribute="filterStmt" class="form">
                        
                        <strong>CustomerAcctNum : </strong>
                        
                        <td><select name="custAcctNum">
	   				 <c:forEach items="${AllcustAcctNum }" var="c">
	        			<%-- <option value="${c.bnfcryId}">${c.bnfcryAcctNum}  ${c.bnfcryAcctName} </option>--%>
	        			<option value="${c.fromCustomerAccount }">${c.fromCustomerName } ${c.fromCustomerAccount } </option>
	    			</c:forEach>
				</select></td>
                        
                        <strong>ServiceProviderId : </strong><input type="text" name="uci"  value=${uci} readonly />
                        <strong>From :  </strong> 
							<em><input type="date" name="startDate" required /></em>
						<strong>To :  </strong>
						<em><input type="date" name="endDate" required />
						<button>Filter</button>
				</form:form>
               <c:choose>
				<c:when test="${acctStmt==null || acctStmt.isEmpty()}">
					<div class="alert alert-info">
						<strong>No transaction available for the selected user</strong>
					</div>
				</c:when>
				<c:otherwise>
                        <table class="table table-bordered table-striped" border = "1" bgcolor="#98AFC7">
						<thead>
                            <tr align="center" bgcolor="#98AFC7">
                                <th >Transaction ID</th>
                                <th>ServiceProviderId </th>
                                <th>Txn Type</th>
                                <th>Customer Name</th>
                                <th>Customer Account</th>
                                <th>Transaction Amount</th>
                                <th>Total Payment Received</th>
                                <th>Transaction Date</th>                                
                                <th>Comments </th>
                            	</tr>
                            </thead>
						<tbody>
							<c:forEach var="c" items="${acctStmt}">
								<tr bgcolor="#FAF8CC">
									<td>${c.txnId }</td>
									<td>${c.serviceProviderId }</td>
									<td>${c.txnType }</td>
									<td>${c.fromCustomerName}</td>
									<td>${c.fromCustomerAccount}</td>
									<td>${c.paymentAmt}</td>
									<td>${c.currentBalance }</td>
									<td>${c.txnDateTime}</td>
									<td>${c.txnCmnts}</td>
								</tr>
							</c:forEach>
						</tbody>					
					</table>
					</c:otherwise>
			</c:choose>
			<div id="footer">
 			<footer>Copyright&copy;2020 IBS Bank.com. All rights reserved | Designed by Batch-7 Group3</footer>
 			</div>
    </body>
</html>
