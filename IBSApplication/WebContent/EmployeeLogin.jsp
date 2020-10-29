<%@page import="java.time.LocalDate" %>
<html>
	<head>
	 	<title>EmployeeLogin</title>
	</head>
	<body>
	<h6 style="text-align:right"><%=LocalDate.now() %></h6>
	<h1 style="text-align:center;background-color:DodgerBlue;">IBS Application</h1>
	h6,h1{line-height: 1; margin; 0;}
<jsp:include page="menu.jsp"/>

<h2>Hope You have a Good Day Today</h2>
<form>
<div>
	<label>EmployeeId*</label>
	<input type="text" name="UserId*" required />
</div>
<div>
	<label>EmployeePassword*</label>
	<input type="password" name="Password*"  min="0"  step"0.01" required />
</div>

<div>
	<button>SEND</button>	
</div>
</form>