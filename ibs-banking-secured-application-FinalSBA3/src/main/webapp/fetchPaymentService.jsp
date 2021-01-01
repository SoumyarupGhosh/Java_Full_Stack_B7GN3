<%@page import="java.time.LocalDate" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
	<link rel="stylesheet" href="/css/registrationForm.css"/>
	<link rel="stylesheet" href="/css/site.css"/>
    <style>
    a {    
      font-size: 18px;
      color: Gold;
      background-color: Teal;
       
   }
    
    </style>


	 	<title>IBS ServiveProvider</title>

	</head>
<body>
	<h1><img src="${pageContext.request.contextPath}/resources/BankLogo.jpg" width="60" height=60 /> IBS Bank</h1>
	<h3>Payment Received</h3>
	
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <ul class="navbar-nav">
  	<li class="nav-item ">
      <a class="nav-link" href="/">Home</a>
    </li>
</ul>	
</nav>
		<c:choose>
					<c:when test="${chkPayment==null || chkPayment.isEmpty() }">
					<div class="alert alert-info">
						<strong>No Payment available for selected customer!!!</strong>
					</div>
				</c:when>
				<c:otherwise>
					<table class="table table-bordered table-striped">
						<thead>
							<tr>
								<th>txnId#   </th>
								<th>txnType#   </th>	
								<th>fromCustomerUci#   </th>	
								<th>toServicePrvider#   </th>
								<th>paymentAmt#   </th>											
								<th>txnDateTime#   </th>
								<th>txnCmnts#   </th>											 
								<th colspan="3"></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="c" items="${chkPayment }">
								<tr>
									<td>${c.txnId }</td>									
									<td>${c.txnType }</td>
									<td>${c.fromCustomerUci }</td>
									<td>${c.toServicePrvider }</td>
									<td>${c.paymentAmt }</td>															
									<td>${c.txnDateTime }</td>
									<td>${c.txnCmnts }</td>									
									<%--<form:form method="POST" action="/reject">
									<td><form:input type="text" path="AdminComments"  /></td>
									</form:form>
										<td><input type="text" name="AdminCommnets"></td>										
									 <td>
										<a href="/employeeLogin/reject?registeredId=${c.regId }" class="btn btn-sm btn-danger">
											Reject
										</a>										
									</td>
									<td>
										<a href="/employeeLogin/accept?registeredId=${c.regId }" class="btn btn-sm btn-danger">
											Approve --%>
										</a>
									</td>
								</tr>
							</c:forEach>
							
						</tbody>					
					</table>
				</c:otherwise>
			</c:choose>
			
	 <div id="footer">
		 <p>
			<footer style="text-align:center;">Copyright&copy;2020 IBS Bank.com. All rights reserved | Designed by Batch-7 Group3</footer>
		</div>
</body>
</html>