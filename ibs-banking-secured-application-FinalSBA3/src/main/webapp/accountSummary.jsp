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
	
                    	
                        <font color="brown"><h2>Account Summary</h2></font>
                        <br></br>
                        <h3 style="text-align:left">Savings Account</h3>
                        <br></br>
                        
           <c:choose>
				<c:when test="${savingsData==null || savingsData.isEmpty()}">
					<div class="alert alert-info">
						<strong>No Saving Account Available</strong>
					</div>
				</c:when>
				<c:otherwise>
				<table class="table table-bordered table-striped" border = "1">
						<thead>
							<tr align="center" bgcolor="#E3E4FA" valign="top">
							<th>Account Number</th>
							<th>Branch Name</th>
							<th>Customer Account Type</th>
							<th>Interest Rate</th>
							<th>Account Balance</th>
							
							</tr>
						</thead>
						<tbody>
							<c:forEach var="c" items="${savingsData }">
								<tr bgcolor="#FAF8CC">
								<%--	<td>${c.custAcctNum }</td>
									<td>${c.custName }</td>
									<td>${c.branchName}</td>
									<td>${c.availableBalance}</td>
									<td>${c.custAcctType}</td>  --%>
									<td>${c.customerAcctNum }</td>
									<td>${c.branchName }</td>
									<td>${c.custAcctType }</td>
									<td>${c.interestRate}</td>
									<td>${c.availableBalance}</td>							
									
								</tr>
							</c:forEach>
						</tbody>					
					</table>
					</c:otherwise>
			</c:choose>
                    </td>
                </tr>
            </table>
            
           <div id="footer">
           <footer>Copyright&copy;2020 IBS Bank.com. All rights reserved | Designed by Batch-7 Group3</footer>
           </div>
    </body>
</html>
