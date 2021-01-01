<%@page import="java.time.LocalDate" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import = "java.io.*,java.util.*, javax.servlet.*" %>
<html>
	<head>
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
	 	<title>IBS Executive</title>

	</head>
<body>  
	<h1><img src="${pageContext.request.contextPath}/resources/BankLogo.jpg" width="60" height=60 /> IBS Bank </h1>		
	 <h2>Welcome ${uci } !!<img src="${pageContext.request.contextPath}/resources/BankHeaderLogo.gif" width="70" height=70 /></h2>
	<%         Date date = new Date();        out.print( "<h5 align = \"right\">" +date.toString()+"</h5>");      %>
	
	<jsp:include page="employeeMenuTBD.jsp" />
	
	
	<font color="brown"><h3>Processing Beneficiary Request</h3></font>
	<br></br>

		<c:choose>
					<c:when test="${bnfcryInfo==null || bnfcryInfo.isEmpty() }">
					
					<div class="alert alert-info">
						<div style="text-align:center"><strong>No Request available to take an action upon</strong></div>
					</div>
				</c:when>
				<c:otherwise>
					<table class="table table-bordered table-striped" border = "1" bgcolor="white">
						<thead>
							<tr>
								<th>bnfcryId#   </th>
								<th>uci#   </th>
								<th>custAcctNum#   </th>	
								<th>bnfcryAcctNum#   </th>	
								<th>bnfcryAcctName#   </th>
								<th>bnfcryBankName#   </th>	
								<th>bnfcryBankIfsc#   </th>											
								<th>bnfcryTxnType#   </th>
								<th>bnfcryMblNum#   </th>	
								<th>bnfcryStatus#   </th>																										 
								<th colspan="3"></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="c" items="${bnfcryInfo }">
								<tr>
									<td>${c.bnfcryId }</td>	
									<td>${c.uci }</td>								
									<td>${c.custAcctNum }</td>
									<td>${c.bnfcryAcctNum }</td>
									<td>${c.bnfcryAcctName }</td>
									<td>${c.bnfcryBankName }</td>									
									<td>${c.bnfcryBankIfsc }</td>
									<td>${c.bnfcryTxnType }</td>
									<td>${c.bnfcryMblNum }</td>
									<td>${c.bnfcryStatus }</td>																		
									<%--<td><form method="POST" action="/provideAdminComments">
											<input type="text" name="AdminComments"  />
											<input type="hidden" name="register_id" value="${c.regId }" />
											<input type="button" name="btn" value="ACCEPT"/>
											<input type="button" name="btn" value="REJECT"/>
									</form><td> --%>
									
									<%-- 	<td><input type="text" name="AdminCommnets"></td>	--%>									
								  <td>
										<a href="/employeeLogin/rejectBnfcry?uci=${uci }&bnfcryId=${c.bnfcryId }" class="btn btn-sm btn-danger">
											Reject
										</a>										
									</td>
									<td>
										<a href="/employeeLogin/acceptBnfcry?uci=${uci }&bnfcryId=${c.bnfcryId }" class="btn btn-sm btn-danger">
											Approve
										</a>
									</td>
								</tr>
							</c:forEach>
							
						</tbody>					
					</table>
				</c:otherwise>
			</c:choose>
	<div id="footer">	
	 
		<footer style="text-align:center;">Copyright&copy;2020 IBS Bank.com. All rights reserved | Designed by Batch-7 Group3</footer>
	
	 </div>
</body>
</html>