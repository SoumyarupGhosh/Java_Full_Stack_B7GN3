<%@page import="java.time.LocalDate" %>
<html>
	<head>
	 	<title>UserLogin</title>
	</head>
	<body>
	<h6 style="text-align:right"><%=LocalDate.now() %></h6>
	<h1 style="text-align:center;background-color:DodgerBlue;">IBS Application</h1>
<jsp:include page="menu.jsp"/>

<h2>Welcome Back To Your Bank</h2>
<form>
<div>
	<label>UserId*</label>
	<input type="text" name="UserId" min="0"  step"0.01" required />
</div>
<div>
	<label>UserPassword*</label>
	<input type="password" name="Password"  min="0"  step"0.01" required />
</div>

<div>
	<button>SEND</button>	
</div>
</form>