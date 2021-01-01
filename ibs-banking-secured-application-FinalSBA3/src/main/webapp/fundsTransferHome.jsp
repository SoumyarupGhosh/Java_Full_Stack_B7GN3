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
	
                    	
                        <h2><font color="brown">Fund Transfer</font></h2>
                        <br></br>                                          
                        <h4><a href="/customerLogin/addBnfPage?uci=${uci}">Add Beneficiary</a>
                        <span><a href="/customerLogin/transferFunds?uci=${uci}">Transfer Funds</a></span></h4>
                        
                        <h4 style="text-align:left">Beneficiary List</h4>
                        
               <c:choose>
				<c:when test="${bncfryList==null || bncfryList.isEmpty()}">
					<div class="alert alert-info">
						<strong>No Beneficiaries Available</strong>
					</div>
				</c:when>
				<c:otherwise>
                        <table class="table table-bordered table-striped" border = "1" bgcolor="#98AFC7">
						<thead>
                            <tr align="center" bgcolor="#98AFC7">
                            	<th>CustomerAcctNumber</th>
                                <th >Beneficiary ID</th>
                                <th>Beneficiary Name</th>
                                <th>Account Number</th>
                                <th>IFSC </th>
                            	<th>Bank Name</th>
                            	<th>Mobile #</th>
                            	<th>Status #</th>
                            	<th colspan="1">Action</th>
                            	</tr>
                            </thead>
						<tbody>
							<c:forEach var="c" items="${bncfryList}">
								<tr bgcolor="#FAF8CC">
									<td>${c.custAcctNum }</td>
									<td>${c.bnfcryId }</td>
									<td>${c.bnfcryAcctName }</td>
									<td>${c.bnfcryAcctNum}</td>
									<td>${c.bnfcryBankIfsc}</td>
									<td>${c.bnfcryBankName}</td>
									<td>${c.bnfcryMblNum}</td>
									<td>${c.bnfcryStatus }</td>	
									<!-- <td>
										<a href="/transferFunds?bnfcryId=${c.bnfcryId }" class="btn btn-sm btn-danger">Transfer</a>
									</td> -->
									<td>
										<a href="/customerLogin/deleteBnfcry?bnfcryId=${c.bnfcryId }&uci=${uci }" class="btn btn-sm btn-danger">Delete</a>
									</td>
								</tr>
							</c:forEach>
						</tbody>					
					</table>
					</c:otherwise>
			</c:choose>
				<c:if test="${message !=null}">
					<div style="text-align:centre" id="status message"><b>${message}</b></div>
					</c:if>
            <div id="footer">
           <footer>Copyright&copy;2020 IBS Bank.com. All rights reserved | Designed by Batch-7 Group3</footer>
           </div>
    </body>
</html>
