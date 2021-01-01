<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
		<link rel="stylesheet" href="/css/registrationForm.css"/>
		 <link rel="stylesheet" href="/css/site.css"/>
		<title>ServiceProvider-CheckPayment</title>
		<style>
						 a {    
				      font-size: 18px;
				      color: Gold;
				      background-color: Teal;
				     
				   }
		
		</style>
</head>
<body>
<jsp:include page="serviceProviderHome.jsp"/>
<h2><b>Check Payment via Account</b></h2>
	<form action="serviceProviderLogin"  method="POST" >
					<div>
						<form:errors path="*" />
					</div>
			<div>
				<label>From Account </label>
				<input  type="number" name="fromAccount"  />
			</div>								
			<div>
				 <button>Submit</button>
			</div>
			<h2><b>Check Payment via Date</b></h2>
		</form>
		 <form action="serviceProviderLogin/viaDate" method="POST" >
					<div>
						<label>From Date </label>
						<input type="date" name="fromDate"  />
				</div>
					<div>
						<label>To Date </label>
						<input type="date" name="toDate"  />
					</div>					
					<div>				
					<button>Submit</button>							
					</div>
			</form>
	
	 <div id="footer">
		 <p>
			<footer style="text-align:center;">Copyright&copy;2020 IBS Bank.com. All rights reserved | Designed by Batch-7 Group3</footer>
		</div>
</body>
</html>