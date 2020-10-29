<%@page import="java.time.LocalDate" %>
<html>
	<head>
	 	<title>NewUserRegistration</title>
	</head>
	<body>
	<h6 style="text-align:right"><%=LocalDate.now() %></h6>
	<h1 style="text-align:center;background-color:DodgerBlue;">IBS Application</h1>
	<jsp:include page="menu.jsp"/>
	<h2>Welcome! Register below</h2>
<form>
<div>
	<label>FirstName*</label>
	<input type="text" name="FirstName" required />
</div>
<div>
	<label>LastName</label>
	<input type="text" name="lastName" required />
</div>
<div>
	<label>DateOfBirth*</label>
	<input type="text" name="DateOfBirth" required />
</div>
<div>
	<label>EmailId*</label>
	<input type="text" name="Email_Id" required />
</div>
<div>
	<label>MobileNumber*</label>
	<input type="text" name="MobileNumber" required />
</div>
<div>
	<label>Address*</label>
	<input type="text" name="Address" required />
</div>
<div>
	<label>City*</label>
	<input type="text" name="City" required />
</div>
<div>
	<label>PinCode*</label>
	<input type="text" name="PinCode" required />
</div>
<form name="TypeofAcctHolder" method="get" action="#">
	<label>TypeofAcctHolder*</label>
	<select name="clr">
	<option>SavingAccount</option>
	<option>CurrentAccount</option>
	<option>FixedDeposit</option>
	<option>RecurringDeposit</option>
	</select>	
</form>

<form name="UserAccountType" method="get" action="#">
	<label>UserAccountType*</label>
	<select name="clr">
	<option>Customer</option>
	<option>ServiceProvider</option>
	</select>	
</form>
<div>
	<label>KYCIdentityProof*</label>
	<input type="file" name="KYCIdentityProof" required />	
</div>

<div>
	<button>SEND</button>	
</div>
</form>