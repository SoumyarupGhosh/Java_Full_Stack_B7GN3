<html>
<head>
	<link href ="${pageContext.request.contextPath}/resources/IBS-Styling.css" type ="text/css" rel ="stylesheet"></link>
</head>       


<nav>
<hr>
		
		<a href="/customerLogin/?uci=${uci}">Home</a>
		<span> | </span>
		<a href="/customerLogin/acctSummary?uci=${uci}">Account Summary</a>
		<span> | </span>
    <!--    <a href="/customerLogin/fundsTransferHome?uci=${uci}">Funds Transfer</a>    -->  
   		 <a href="/customerLogin/fundConfirmPassword?uci=${uci }">Funds Transfer</a>
        <span> | </span>
        <a href="/customerLogin/openNewAccountPage?uci=${uci}">Open New Account</a>
        <span> | </span>
        <!-- <a href="/customerLogin/billPymtPage?uci=${uci}">Bill Payment</a> -->
        <a href="/customerLogin/billConfirmPassword?uci=${uci}">Bill Payment</a>
        <span> | </span>
        <a href="/customerLogin/fixedDeposit?uci=${uci}">Fixed Deposit</a>
        <span> | </span>
        <a href="/customerLogin/recurringDeposit?uci=${uci}">Recurring Deposit</a>
        <span> | </span>
        <a href="/customerLogin/acctStmt?uci=${uci}">Account Statement</a> 
        <span> | </span>
        <a href="/changePassword?uci=${uci}">ChangePassword</a>
        <span> | </span>
         <a href="/logout">Log Out</a> 
      
     	 
<hr></hr>	
	
</nav>
</html>