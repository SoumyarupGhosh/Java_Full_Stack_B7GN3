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
  <h1><img src="${pageContext.request.contextPath}/resources/BankLogo.jpg" width="60" height="60" /> IBS Bank </h1>
	<h2>Welcome ${uci } !!<img src="${pageContext.request.contextPath}/resources/BankHeaderLogo.gif" width="70" height=70 />
	<%         Date date = new Date();        out.print( "<h5 align = \"right\">" +date.toString()+"</h5>");      %></h2>
	
	
	<jsp:include page="employeeMenuTBD.jsp" />
	
	<h3><font color="brown"> KYC Request</font></h3>
	
	<br></br>
		<c:choose>
					<c:when test="${kycInfo==null || kycInfo.isEmpty() }">
					<div class="alert alert-info">
						<div style="text-align:center"><strong>No Request available to take an action upon</strong></div>
					</div>
				</c:when>
				<c:otherwise>
					<table class="table table-bordered table-striped" cellspacing="0" cellpadding="0" border = "1" bgcolor="white">
						<thead>
							<tr>
							<th>ActionReject</th>
							<th>ActionAccept</th>
								<th>regId#   </th>
								<th>FirstName#   </th>	
								<th>lastName#   </th>	
								<th>gender#   </th>
								<th>dob#   </th>	
								<th>emailId#   </th>											
								<th>mobileNum#   </th>
								<th>address#   </th>
								<th>city#   </th>
								<th>pincode#   </th>
								<th>AcctHolder#   </th>
								<th>custAcctType#   </th>
								<th>kycProof#   </th>
								<th>kycProofDoc#   </th>
								<th>kycUploadInd#   </th>
								<th>servPBankName#   </th>
								<th>servPBankBranch#   </th>
								<th>servPBankAccount#   </th>
								<th>servPBankIFSC#   </th>
								
																 
								<th colspan="3"></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="c" items="${kycInfo }">
								<tr>
								<td>
										<a href="/employeeLogin/reject?uci=${uci }&registeredId=${c.regId }" class="btn btn-sm btn-danger">
											Reject
										</a>										
									</td>
									<td>
										<a href="/employeeLogin/accept?uci=${uci }&registeredId=${c.regId }" class="btn btn-sm btn-danger">
											Approve
										</a>
									</td>
									<td>${c.regId }</td>									
									<td>${c.firstName }</td>
									<td>${c.lastName }</td>
									<td>${c.gender }</td>
									<td>${c.dob }</td>									
									<td>${c.emailId }</td>
									<td>${c.mobileNum }</td>
									<td>${c.address }</td>
									<td>${c.city }</td>									
									<td>${c.pincode }</td>									
									<td>${c.typeOfAcctHolder }</td>
									<td>${c.custAcctType }</td>									
									<td>${c.kycIdentityProof }</td>
									<td>${c.kycProofDoc }</td>
									<td>${c.kycUploadInd }</td>
									<td>${c.servProBankName }</td>									
									<td>${c.servProBankBranch }</td>
									<td>${c.servProBankAccount }</td>
									<td>${c.servProBankIFSC }</td>
									<%--<td><form method="POST" action="/provideAdminComments">
											<input type="text" name="AdminComments"  />
											<input type="hidden" name="register_id" value="${c.regId }" />
											<input type="button" name="btn" value="ACCEPT"/>
											<input type="button" name="btn" value="REJECT"/>
									</form><td> --%>
									
									<%-- 	<td><input type="text" name="AdminCommnets"></td>	--%>									
								  
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