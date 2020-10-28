<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="customer_home.jsp"/>
<h5>Transfers</h5>
	<form action="transferFunds" method="POST" >
			<div>
				<label>From Account </label>
				<input type="number" name="fromAccount" required />
			</div>
			<div>
				<label>To Account </label>
				<input type="number" name="toAccount" required />
			</div>
			<div>
				<label>Transfer Amount</label>
				<input type="date" name="transferAmount" min="1" max="1000000" step="1" required />
			</div>
			<div>
				<label>Transfer Type </label>
				<input type="date" name="transferType" required />
			</div>
			<div>
				<label>Comments </label>
				<input type="date" name="txnComments" />
			</div>
			<div>
				<button>Transfer Amount</button>
			</div>
	</form>
</body>
</html>