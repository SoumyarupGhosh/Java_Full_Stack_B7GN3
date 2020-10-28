<%@page import="java.time.LocalDate"%>
<html>
	<head>
		<title>IBS Bank - Home</title>
	</head>
	<body>
		<h1 align="center">IBS Bank - Home</h1>
		<h5 align ="right">Welcome user !!</h5>
		<h6 align="right">Login time <%=(new java.util.Date()).toLocaleString()%></h6>
	
	<nav>
	<hr />
	<a href="customer_home.jsp">Home</a>
	 <span>|</span>
	 <a href="transfers.jsp">Fund Transfers</a>
	 <span>|</span>
	 <a href="cards.jsp">Debit/Credit Cards</a>
	 <span>|</span>
	 <a href="loans.jsp">Loan Managements</a>
	 <span>|</span>
	 <a href="logout.jsp">Logout</a>
	<hr />
	</nav>
	</body>
</html>