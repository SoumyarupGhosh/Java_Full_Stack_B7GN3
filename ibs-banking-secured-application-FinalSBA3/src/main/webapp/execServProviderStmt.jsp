<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page import = "java.io.*,java.util.*, javax.servlet.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <title>IBS Bank-Account Statement</title>
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
   <!--  <body leftmargin=0 topmargin=0 marginheight="0" marginwidth="0"  style="background-color:PaleGoldenRod;">-->
   <body>
	<h1><img src="${pageContext.request.contextPath}/resources/BankLogo.jpg" width="60" height=60 /> IBS Bank </h1>		
	<h2>Welcome ${uci } !!<img src="${pageContext.request.contextPath}/resources/BankHeaderLogo.gif" width="70" height=70 /> 
	<%         Date date = new Date();        out.print( "<h5 align = \"right\">" +date.toString()+"</h5>");      %>		
	<hr />	          
                           <jsp:include page="/header"/>
                      
                   <!--  <td width="1100" height="80" bgcolor="#FAF8CC">--> 
              	<form:form action="/employeeLogin/execFilterServiceProviderStmt?uci=${uci}" method="GET" modelAttribute="execSPfilterStmt" class="form">
                        <font color="brown"><h2> ServiceProvider Payment Received Statement</h2></font>
                        
                        <strong>EmployeeId : </strong><input type="text" name="uci"  value=${uci} readonly />
                        
                        <strong>CustomerAcctNum : </strong>                        
                        <td><select name="custAcctNum">
	   				 <c:forEach items="${AllcustAcctNum }" var="c">
	        			<%-- <option value="${c.bnfcryId}">${c.bnfcryAcctNum}  ${c.bnfcryAcctName} </option>--%>
	        			<option value="${c.accountId }">${c.serviceProviderName } ${c.accountId }</option>
	    			</c:forEach>
				</select></td>
                        
                        
                        <strong>From :  </strong> 
							<em><input type="date" name="startDate" required /></em>
						<strong>To :  </strong>
						<em><input type="date" name="endDate" required />
						<button>Filter</button>
				</form:form>
               <c:choose>
				<c:when test="${SPStmt==null || SPStmt.isEmpty()}">
					<div class="alert alert-info">
						<h3>No transaction available for the selected user</h3>
					</div>
				</c:when>
				<c:otherwise>
                        <table class="table table-bordered table-striped" border = "1" bgcolor="#98AFC7">
						<thead>
                            <tr align="center" bgcolor="#98AFC7">
                                <th >Transaction ID</th>
                                <th>ServiceProviderId </th>
                                <th>ServiceProviderAccountId </th>
                                <th>Txn Type</th>
                                <th>Customer Name</th>
                                <th>Customer Account</th>
                                <th>Transaction Amount</th>
                                <th>Current Balance</th>
                                <th>Transaction Date</th>                                
                                <th>Comments </th>
                            	</tr>
                            </thead>
						<tbody>
							<c:forEach var="c" items="${SPStmt }">
								<tr bgcolor="#FAF8CC">
									<td>${c.txnId }</td>
									<td>${c.serviceProviderId }</td>
									<td>${c.serviceProvideraccountId }</td>
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
