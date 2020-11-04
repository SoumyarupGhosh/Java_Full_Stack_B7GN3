<%@page import="java.time.LocalDate"%>

<html>
	<head>
		<title>IBS-Home</title>		
	</head>
	
	<body style="background-color:PaleGoldenRod;">	
	<h1 style="text-align:center;background-color:DarkCyan;color:White;font-size:45"><img src="${pageContext.request.contextPath}/resources/BankLogo.jpg" width="40" height=40 /> IBS Bank </h1>
	<h2 style="line-height: 0;text-align:center">Welcome To IBS Banking</h2>
	<h6 style="line-height: 0;text-align:center">Safe,Secure And Convenient Banking</h2>
	<jsp:include page="homeMenu.jsp"/>

	 <div style="display:inline-block;vertical-align:top">
	 <img src="${pageContext.request.contextPath}/resources/HomeImage1.jpg" width="500" height="200"/>
	 </div>
	<div style="display:inline-block;vertical-align:top">
	<h5 style="word-wrap:break-word;">*With the rapid growth of Internet technology, online banking has played an important and central role in the e-payment area.</h2>
	<h5 style="">*Banking online allows a customer to make deposits, withdraws, transfer with the click of mouse.</h2>
	  
	 </div>
		<h1> </h1>
		<h5 style="text-align:center;">Copyright&copy;2020 IBS Bank.com. All rights reserved | Designed by Batch-7 Group3</h5>
		
	</body>
</html>