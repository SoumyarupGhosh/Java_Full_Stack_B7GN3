<%@ page import="java.time.LocalDate"%>
<%@ page import = "java.io.*,java.util.*, javax.servlet.*" %>
 
<html>
	<head>
		<link rel="stylesheet" href="/css/site.css"/>
		 <link rel="stylesheet" href="/css/IBS-Styling.css"/>
		<title>IBS-Home</title>	
		<style>
		 body{
		 		 background-image: url('${pageContext.request.contextPath}/resources/BankLogo.jpg');
		 		 background-repeat: no-repeat;
		 		 background-size:100% 100%;
		 		 background-blend-mode:soft-light;
		 	}
		 </style>
	</head>
	
	<body>	
	<h1><img src="${pageContext.request.contextPath}/resources/BankLogo.jpg" width="60" height=60 /> IBS Bank </h1>	
	<br></br>	
	<h2> Welcome To IBS Banking </h2>
	<div style="text-align:center"><h5>Safe,Secure And Convenient Banking</h5></div>		
	<%         Date date = new Date();        out.print( "<h5 align = \"right\">" +date.toString()+"</h5>");      %>

			<hr></hr>
			<ul>
				<jsp:include page="/header"/> 
			</ul>
			<hr></hr>
					
			<br></br>
			 <div id="imagebody" style="text-align:center">
			 	<img src="${pageContext.request.contextPath}/resources/HomeImage1.jpg" width="600" height="250"/>
			 </div>
			<div id="imagebodyinfo" style="text-align:center">
				<h5 style="word-wrap:break-word;">*With the rapid growth of Internet technology, online banking has played an important and central role in the e-payment area.</h5>
				<h5 style="">*Banking online allows a customer to make deposits, withdraws, transfer with the click of mouse.</h5>
		 	</div>	
		 
		 <div id="footer">
			<footer style="text-align:center;">Copyright&copy;2020 IBS Bank.com. All rights reserved | Designed by Batch-7 Group3</footer>
		</div>
		 <p>
	 	</body>
</html>