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
	
                    	
                        <h2><font color="brown">Account Summary - Recurring Deposit</font></h2>
                        <br></br>
                      
                        
             <c:choose>
				<c:when test="${rdData==null || rdData.isEmpty()}">
					<div class="alert alert-info">
						<h3>No Recurring Deposit Account Available</h3>
					</div>
				</c:when>
				<c:otherwise>
				 <table border="1" ><thead>
                             <tr bgcolor="#E3E4FA" >
                               <th>UCI</th>
								<th>CustomerAcctNum</th>
								<th>CustomerAcctType</th>
								<th>Branch Name</th>
								<th>Interest Rate</th>
								<th>Monthly Installment</th>
                                <th>Total AmountPaid</th>
                                <th>Tenure(No.of Quarter)</th>                            	
                            	<th>MaturityAmount </th>
                            	<th>Maturity Date</th>
                            	<th>AccountOpenOn</th>
                            	</tr></thead>
                            <tbody>
							<c:forEach var="c" items="${rdData }">
								 <tr bgcolor="#FFF0FF">
								 	<td>${c.uci }</td> 
									<td>${c.customerAcctNum }</td>
									<td>${c.custAcctType }</td>
									<td>${c.branchName }</td>
									<td>${c.interestRate }</td>
									<td>${c.monthlyInstallment }</td>
									<td>${c.availableBalance}</td>
									<td>${c.tenure}</td>
									<td>${c.maturityAmount }</td>
									<td>${c.custAccountClosedOn }</td>
									<td>${c.custAccountCreatedOn }</td>
								</tr>
							</c:forEach>
						</tbody>
                        </table>
                        </c:otherwise>
			</c:choose>
			<c:if test="${message !=null}">
					<div style="text-align:centre;margin-left:450px" id="status message"><b>${message}</b></div>
					</c:if>	
                <div id="footer">	
         <footer>Copyright&copy;2020 IBS Bank.com. All rights reserved | Designed by Batch-7 Group3</footer>
         </div>
    </body>
</html>
